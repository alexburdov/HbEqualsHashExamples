package ru.alex.burdovitsin.example00.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.burdovitsin.example00.model.jpa.Bucket;

public interface BucketRepository extends CrudRepository<Bucket, Long> {
}
