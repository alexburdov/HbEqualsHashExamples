package ru.alex.burdovitsin.example00.services;

import ru.alex.burdovitsin.example00.model.dto.BucketDto;

import java.util.List;

public interface BucketService {

    BucketDto add(BucketDto bucket);

    List<BucketDto> findAll();
}
