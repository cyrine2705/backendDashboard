package com.example.demo.repositories;

import com.example.demo.models.Conge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongeRepository extends MongoRepository<Conge,Integer>{
	
}
