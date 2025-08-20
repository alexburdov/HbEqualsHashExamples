package ru.alex.burdovitsin.example00.model.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example00.model.dto.BucketDto;

@Entity
@Table(name = "Bucket")
@Setter
@Getter
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    public Bucket() {
    }

    public Bucket(BucketDto bucketDto) {
        this.id = bucketDto.getBucketId();
        this.title = bucketDto.getTitle();
    }
}
