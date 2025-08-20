package ru.alex.burdovitsin.example02.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
public class ItemDto implements Serializable {

    public  ItemDto() {
        this.itemId = null;
        this.title = UUID.randomUUID().toString();
    }

    public ItemDto(Long itemId, String title) {
        this.itemId = itemId;
        this.title = title;
    }

    private Long itemId;

    private String title;
}
