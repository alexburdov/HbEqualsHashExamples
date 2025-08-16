package ru.alex.burdovitsin.example01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alex.burdovitsin.example01.model.dto.BucketDto;
import ru.alex.burdovitsin.example01.services.BucketService;

import java.util.List;

@RestController
public class BucketController {

    private final BucketService bucketService;

    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping("/echo")
    public String echo() {
        return "Hello World!";
    }

    @GetMapping("/new")
    public BucketDto newBucket() {
        return bucketService.add(new BucketDto());
    }

    @GetMapping("/get")
    public List<BucketDto> getBucket() {
        return bucketService.findAll();
    }
}
