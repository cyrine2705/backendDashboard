package com.example.demo.services;

import com.example.demo.models.Materiel;
import com.example.demo.repositories.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MaterielService {
    @Autowired
    private MaterielRepository MaterielRepository;





    public Materiel addMateriel(Materiel materiel) {

        return MaterielRepository.save(materiel);

    }


    public List<Materiel> getAllMateriel(){
        return MaterielRepository.findAll();
    }
    public List<Materiel> getMaterialByEmployeId(String employeId){
        return MaterielRepository.findByIdEmploye(employeId);
    }

    public Materiel getMateriel(int materielId) {
        return MaterielRepository.findById(materielId).get();
    }


    public String deletemateriel(int materielId) {
        MaterielRepository.deleteById(materielId);
        return "deleted from dashboard";
    }
}
