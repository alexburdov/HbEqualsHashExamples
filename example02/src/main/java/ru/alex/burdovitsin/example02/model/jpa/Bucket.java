package ru.alex.burdovitsin.example02.model.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example02.model.dto.BucketDto;
import ru.alex.burdovitsin.example02.model.dto.ItemDto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Bucket", indexes = {@Index(columnList = "bucket_id")})
@Setter
@Getter
public class Bucket {
    public Bucket() {
        this.items = new ArrayList<>();
        this.title = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
    }

    public Bucket(BucketDto bucketDto) {
        this.bucketId = bucketDto.getBucketId();
        this.title = bucketDto.getTitle();
        this.items = new ArrayList<>();
        for (ItemDto itemDto : bucketDto.getItems()) {
            this.items.add(new Item(itemDto.getItemId(), itemDto.getTitle()));
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bucket_id")
    private Long bucketId;

    private String title;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bucket_id")
    private List<Item> items;
}
