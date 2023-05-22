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

    public Materiel getMateriel(String materielId) {
        return MaterielRepository.findById(materielId).get();
    }

    public Materiel changeState (String materialId ,String state){
        Materiel m =MaterielRepository.findById(materialId).get();
        m.setState(state);
        return MaterielRepository.save(m);
    }

    public String deletemateriel(String materielId) {
        MaterielRepository.deleteById(materielId);
        return "deleted from dashboard";
    }
}
