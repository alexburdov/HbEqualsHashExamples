package ru.alex.burdovitsin.example02.services.impl;

import org.springframework.stereotype.Service;
import ru.alex.burdovitsin.example02.model.dto.BucketDto;
import ru.alex.burdovitsin.example02.model.jpa.Bucket;
import ru.alex.burdovitsin.example02.repositories.BucketRepository;
import ru.alex.burdovitsin.example02.services.BucketService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BucketServiceImpl implements BucketService {

    private final BucketRepository bucketRepository;

    public BucketServiceImpl(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    @Override
    public BucketDto add(BucketDto bucket) {
        Bucket bucketEntity = new Bucket(bucket);
        Bucket newBucket = bucketRepository.save(bucketEntity);
        return new BucketDto(newBucket);
    }

    @Override
    public List<BucketDto> findAll() {
        List<BucketDto> result = new ArrayList<>();
        Iterable<Bucket> buckets = bucketRepository.findAll();
        for (Bucket bucket : buckets) {
            result.add(new BucketDto(bucket));
        }
        return result;
    }
}
