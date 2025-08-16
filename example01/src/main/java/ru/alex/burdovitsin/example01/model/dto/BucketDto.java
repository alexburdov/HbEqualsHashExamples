package ru.alex.burdovitsin.example01.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example01.model.jpa.Bucket;

import java.util.UUID;

@Getter
@Setter
public class BucketDto {

    private Long id;
    private String title;
    private int hash;
    private int hashNow;

    public BucketDto(Bucket bucket) {
        this.id = bucket.getId();
        this.title = bucket.getTitle();
        this.hash = bucket.getHash();
        this.hashNow = bucket.getHashNow();
    }

    public BucketDto() {
        this.id = null;
        this.title = UUID.randomUUID().toString();
    }
}
