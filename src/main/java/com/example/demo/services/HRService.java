package com.example.demo.services;

import com.example.demo.models.Employe;
import com.example.demo.models.HR;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.HRRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {
    @Autowired
    private HRRespository HRRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<User> getAllEmployees(){
        return   HRRepository.findByRole(Role.RH);
    }

    public HR getRH(String employeId) {
        return (HR)  HRRepository.findById(employeId).get();
    }
    public HR updateRH(HR hr) {
        HR updatedUser = (HR) HRRepository.findById(hr.getId()).get();
        updatedUser.setLastName(hr.getLastName());
        updatedUser.setFirstName(hr.getFirstName());
        updatedUser.setEmail(hr.getEmail());
        updatedUser.setBirthDate(hr.getBirthDate());
        updatedUser.setAdress(hr.getAdress());
        updatedUser.setCin(hr.getCin());
        updatedUser.setPhoneNumber1(hr.getPhoneNumber1());
        updatedUser.setPhoneNumber2(hr.getPhoneNumber2());
        updatedUser.setImage(hr.getImage());
        updatedUser.setNbConge(hr.getNbConge());
        updatedUser.setSituation(hr.getSituation());
        updatedUser.setSexe(hr.getSexe());
        updatedUser.setNbEnfants(hr.getNbEnfants());
        updatedUser.setStartTime(hr.getStartTime());
        updatedUser.setEndTime(hr.getEndTime());
        return (HR) HRRepository.save(updatedUser);
    }

    public String deleteHR( String employeId) {
        HRRepository.deleteById(employeId);
        return "deleted from dashboard";
    }
    public void changePassword(String email, String currentPassword, String newPassword) throws Exception {
        Employe user =(Employe) HRRepository.findByEmail(email).get();

        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            throw new Exception("Invalid current password");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        HRRepository.save(user);
    }
}
