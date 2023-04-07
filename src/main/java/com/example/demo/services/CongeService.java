package com.example.demo.services;

import com.example.demo.models.Conge;
import com.example.demo.repositories.CongeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CongeService {
    @Autowired
    private CongeRepository CongeRepository;

    public Conge addConge(Conge Conge) {

        return CongeRepository.save(Conge);

    }


    public List<Conge> getAllConge(){
        return CongeRepository.findAll();
    }
    public List<Conge> getCongeByEmployeId(String employeId){
        return CongeRepository.findByIdEmploye(employeId);
    }

    public Conge getConge(String congeId) {
        return CongeRepository.findById(congeId).get();
    }


    public String deleteconge(String congeId) {
        CongeRepository.deleteById(congeId);
        return "deleted from dashboard";
    }
}
