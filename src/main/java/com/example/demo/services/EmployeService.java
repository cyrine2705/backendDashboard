package com.example.demo.services;

import com.example.demo.models.Employe;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.EmployeRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRespository employeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getAllEmployees(){
        return  employeRepository.findByRole(Role.EMPLOYE);
    }

    public User getEmploye(String id) {
       return employeRepository.findById(id).get();

    }
    public User updateEmploye(String id, Employe employe) {
        User updatedUser = employeRepository.findById(id).get();
        updatedUser.setLastName(employe.getLastName());
        updatedUser.setFirstName(employe.getFirstName());
        updatedUser.setBirthDate(employe.getBirthDate());
        updatedUser.setAdress(employe.getAdress());
        updatedUser.setPhoneNumber1(employe.getPhoneNumber1());
        updatedUser.setPhoneNumber2(employe.getPhoneNumber2());
        updatedUser.setImage(employe.getImage());
        updatedUser.setSituation(employe.getSituation());
        updatedUser.setSexe(employe.getSexe());
        updatedUser.setNbEnfants(employe.getNbEnfants());
        return employeRepository.save(updatedUser);
    }

    public String deleteEmploye( String employeId) {
        employeRepository.deleteById(employeId);
        return "deleted from dashboard";
    }

    public User changePassword(String id, String currentPassword, String newPassword) throws Exception {
     User  user= employeRepository.findById(id).get();

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            System.out.println(currentPassword);
            System.out.println(newPassword);
            System.out.println(user.getPassword());
            throw new Exception("Invalid current password");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        employeRepository.save(user);
        return user;
    }

}
