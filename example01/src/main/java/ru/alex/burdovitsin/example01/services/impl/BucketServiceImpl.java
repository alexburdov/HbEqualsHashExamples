package ru.alex.burdovitsin.example01.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.alex.burdovitsin.example01.model.dto.BucketDto;
import ru.alex.burdovitsin.example01.model.jpa.Bucket;
import ru.alex.burdovitsin.example01.repositories.BucketRepository;
import ru.alex.burdovitsin.example01.services.BucketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.*;

@Slf4j
@Service
public class BucketServiceImpl implements BucketService {

    private static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    private final BucketRepository bucketRepository;

    public BucketServiceImpl(BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    @Override
    public BucketDto add(BucketDto bucket) {
        Bucket bucketEntity = new Bucket(bucket);
        int oldHash = bucketEntity.hashCode();
        bucketEntity.setHash(oldHash);
        String oldTitle = bucketEntity.getTitle();
        String newTitle = UUID.randomUUID().toString();
        bucketEntity.setTitle(newTitle);
        int changedHash = bucketEntity.hashCode();
        Bucket newBucket = bucketRepository.save(bucketEntity);
        int newHash = newBucket.hashCode();
        boolean isEq = bucketEntity.equals(newBucket);
        log.info("Old title is {}, New title {}, Old hash {}, Changed hash {}", oldTitle, newTitle, oldHash, changedHash);
        log.info("New hash {}, is entity equals {}", newHash, isEq);
        Long id = newBucket.getId();
        Bucket readBucket = bucketRepository.findById(id).orElse(null);
        if (Objects.nonNull(readBucket)) {
            int readHash = readBucket.hashCode();
            log.info("Read bucket hash {}", readHash);
        }
        return new BucketDto(newBucket);
    }

    @Override
    public List<BucketDto> findAll() {
        List<BucketDto> result = new ArrayList<>();
        Iterable<Bucket> buckets = bucketRepository.findAll();
        for (Bucket bucket : buckets) {
            try {
                Future<Bucket> future = EXECUTOR_SERVICE.submit(() -> {
                    bucket.setHashNow(bucket.getHash());
                    bucket.setTitle(UUID.randomUUID().toString());
                    bucketRepository.save(bucket);
                    return bucket;
                });
                result.add(new BucketDto(future.get()));
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
