package com.example.demo.repositories;

import com.example.demo.models.Employe;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRespository  extends UserRepository<Employe> {

}
