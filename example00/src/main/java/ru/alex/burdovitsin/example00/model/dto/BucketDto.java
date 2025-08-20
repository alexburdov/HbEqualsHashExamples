package ru.alex.burdovitsin.example00.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example00.model.jpa.Bucket;

import java.util.UUID;

@Getter
@Setter
public class BucketDto {

    private Long bucketId;
    private String title;

    public BucketDto(Bucket bucket) {
        this.bucketId = bucket.getId();
        this.title = bucket.getTitle();
    }

    public BucketDto() {
        this.bucketId = null;
        this.title = UUID.randomUUID().toString();
    }
}
