package ru.alex.burdovitsin.example02.model.dto;

import lombok.Getter;
import lombok.Setter;
import ru.alex.burdovitsin.example02.model.jpa.Bucket;
import ru.alex.burdovitsin.example02.model.jpa.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class BucketDto implements Serializable {

    public BucketDto() {
        this.bucketId = null;
        this.title = UUID.randomUUID().toString();
        this.items = new ArrayList<>();
        this.items.add(new ItemDto());
        this.items.add(new ItemDto());
    }

    public BucketDto(Bucket bucket) {
        this.bucketId = bucket.getBucketId();
        this.title = bucket.getTitle();
        this.items = new ArrayList<>();
        for (Item item : bucket.getItems()) {
            this.items.add(new ItemDto(item.getItemId(), item.getTitle()));
        }
    }

    private Long bucketId;

    private String title;

    private List<ItemDto> items;
}
