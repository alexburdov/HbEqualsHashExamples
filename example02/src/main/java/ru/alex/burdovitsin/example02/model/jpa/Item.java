package ru.alex.burdovitsin.example02.model.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Item")
@Setter
@Getter
public class Item {

    public Item() {
        this.itemId = null;
        this.title = UUID.randomUUID().toString();
    }

    public Item(Long id, String title) {
        this.itemId = id;
        this.title = title;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long itemId;

    private String title;
}
