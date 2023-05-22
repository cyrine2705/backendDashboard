package com.example.demo.repositories;


import com.example.demo.models.Materiel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterielRepository extends MongoRepository<Materiel,String>{
    List<Materiel> findByIdEmploye (String idEmploye);
}
