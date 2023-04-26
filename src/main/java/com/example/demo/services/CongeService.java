package com.example.demo.services;

import com.example.demo.models.Conge;
import com.example.demo.models.User;
import com.example.demo.repositories.CongeRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CongeService {
    @Autowired
    private CongeRepository CongeRepository;
    @Autowired
    private UserRepository userRepository;

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

    public Conge changeState (String congeId ,String state,Integer nb){
        Conge c =CongeRepository.findById(congeId).get();
        c.setState(state);
        if (state.equals("Approuved")) {
            User user = (User) userRepository.findById(c.getIdEmploye()).get();
            System.out.println(nb);
        user.setNbConge(user.getNbConge()-nb);
        userRepository.save(user);
        }
        return CongeRepository.save(c);
    }

    public String deleteconge(String congeId) {
        CongeRepository.deleteById(congeId);
        return "deleted from dashboard";
    }
}
