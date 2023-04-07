package com.example.demo.services;

import com.example.demo.models.Reclamation;
import com.example.demo.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReclamationService {

    @Autowired
    private ReclamationRepository reclamationRepository;





    public Reclamation addReclamation(Reclamation reclamation) {

        return reclamationRepository.save(reclamation);
    }


    public List<Reclamation> getAllreclamation(){
        return reclamationRepository.findAll();
    }

    public Reclamation getreclamation(String reclamationId) {
        return reclamationRepository.findById(reclamationId).get();
    }
    public Reclamation  updatereclamation(Reclamation reclamation) {
        Reclamation updatedReclamation = reclamationRepository.findById(reclamation.getId()).get();
        updatedReclamation.setTopic(reclamation.getTopic());
        updatedReclamation.setDescription(reclamation.getDescription());
        updatedReclamation.setIdEmploye(reclamation.getIdEmploye());
        return  reclamationRepository.save(updatedReclamation);
    }

    public String deleteReclamation(String reclamationId) {
        reclamationRepository.deleteById(reclamationId);
        return "deleted from dashboard";
    }

}
