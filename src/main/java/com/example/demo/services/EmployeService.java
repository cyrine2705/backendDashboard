package com.example.demo.services;

import com.example.demo.models.Employe;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.EmployeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeService {
    @Autowired
    private EmployeRespository employeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<User> getAllEmployees(){
        return employeRepository.findByRole(Role.EMPLOYE);
    }

    public Employe getEmploye(String employeId) {
        return (Employe) employeRepository.findById(employeId).get();
    }
    public Employe updateEmploye(Employe employe) {
        Employe updatedUser = (Employe) employeRepository.findById(employe.getId()).get();
        updatedUser.setLastName(employe.getLastName());
        updatedUser.setFirstName(employe.getFirstName());
        updatedUser.setEmail(employe.getEmail());
        updatedUser.setBirthDate(employe.getBirthDate());
        updatedUser.setAdress(employe.getAdress());
        updatedUser.setCin(employe.getCin());
        updatedUser.setPhoneNumber1(employe.getPhoneNumber1());
        updatedUser.setPhoneNumber2(employe.getPhoneNumber2());
        updatedUser.setImage(employe.getImage());
        updatedUser.setNbConge(employe.getNbConge());
        updatedUser.setSituation(employe.getSituation());
        updatedUser.setSexe(employe.getSexe());
        updatedUser.setNbEnfants(employe.getNbEnfants());
        updatedUser.setStartTime(employe.getStartTime());
        updatedUser.setEndTime(employe.getEndTime());
        return (Employe) employeRepository.save(updatedUser);
    }

    public String deleteEmploye( String employeId) {
        employeRepository.deleteById(employeId);
        return "deleted from dashboard";
    }

    public Employe changePassword(String email, String currentPassword, String newPassword) throws Exception {
        Employe user =(Employe) employeRepository.findByEmail(email).get();

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new Exception("Invalid current password");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        employeRepository.save(user);
        return user;
    }

}
