package ru.alex.burdovitsin.example01.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.alex.burdovitsin.example01.model.jpa.Bucket;

public interface BucketRepository extends CrudRepository<Bucket, Long> {
}
