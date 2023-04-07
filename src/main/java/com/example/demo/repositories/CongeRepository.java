package com.example.demo.repositories;

import com.example.demo.models.Conge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CongeRepository extends MongoRepository<Conge,String>{
	List<Conge> findByIdEmploye (String idEmploye);
}
