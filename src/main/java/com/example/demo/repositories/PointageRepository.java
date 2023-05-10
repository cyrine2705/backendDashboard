package com.example.demo.repositories;

import com.example.demo.models.Pointage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointageRepository extends MongoRepository<Pointage,String> {
}
