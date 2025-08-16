package ru.alex.burdovitsin.example01.model.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example01.model.dto.BucketDto;

@Entity
@Table(name = "Bucket")
@Setter
@Getter
public class Bucket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int hash;

    @Transient
    private int hashNow;

    public Bucket() {
    }

    public Bucket(BucketDto bucketDto) {
        this.id = bucketDto.getId();
        this.title = bucketDto.getTitle();
    }

}
