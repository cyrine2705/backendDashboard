package com.example.demo.services;

import com.example.demo.models.Employe;
import com.example.demo.models.Pointage;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.EmployeRespository;
import com.example.demo.repositories.PointageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeService {
    @Autowired
    private EmployeRespository employeRepository;
    @Autowired
    private PointageRepository pointageRespository;
    @Autowired
    private PasswordEncoder passwordEncoder;



    public List<User> getAllEmployees(){
        return  employeRepository.findByRole(Role.EMPLOYE);
    }

    public User getEmploye(String id) {
       return employeRepository.findById(id).get();

    }
    public String getEmployeByCin(int cin) {

         return employeRepository.findByCin(cin).get().getFirstName();

    }
    public String getDeviceToken (int cin ){
        return employeRepository.findByCin(cin).get().getDeviceToken();
    }
    public String saveDeviceToken(String deviceToken,String empId){
        User u =employeRepository.findById(empId).get();
        u.setDeviceToken(deviceToken);
        employeRepository.save(u);
        return "saved";

    }
    public String presence(int cin,String temps){

        User u = employeRepository.findByCin(cin).get();
        System.out.println(u.isPresent());
        if (!u.isPresent()){
            u.setPresent(true);
            u.setEntryTime(LocalDateTime.parse(temps));
            employeRepository.save(u);
            return u.toString();
        }
        else{
            u.setExitingTime(LocalDateTime.parse(temps));
            employeRepository.save(u);
            pointageRespository.save(new Pointage(LocalDate.now(),u.getId(), u.getEntryTime(),u.getExitingTime()));
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                u.setEntryTime(null);
                u.setExitingTime(null);
                u.setPresent(false);
                employeRepository.save(u);
            }, 5, TimeUnit.MINUTES);

            return "ended"+u.getExitingTime();
        }

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

    public User updateEmployeFromDashboard(String id, Employe employe) {
        User updatedUser = employeRepository.findById(id).get();
        updatedUser.setLastName(employe.getLastName());
        updatedUser.setFirstName(employe.getFirstName());
        updatedUser.setBirthDate(employe.getBirthDate());
        updatedUser.setRole(employe.getRole());
        updatedUser.setAdress(employe.getAdress());
        updatedUser.setPhoneNumber1(employe.getPhoneNumber1());
        updatedUser.setPhoneNumber2(employe.getPhoneNumber2());
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
