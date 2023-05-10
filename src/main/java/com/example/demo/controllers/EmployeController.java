package com.example.demo.controllers;

import com.example.demo.models.Employe;
import com.example.demo.models.User;
import com.example.demo.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/employes")
public class EmployeController {

        @Autowired
        private EmployeService employeService;


        @GetMapping
        public List<User> getEmployes() {
            return employeService.getAllEmployees();
        }

        @GetMapping("/{id}")
        public User getEmploye(@PathVariable String id) {
            return employeService.getEmploye(id);
        }

        @PutMapping("/{employeId}")
        public User ModifyEmploye(@PathVariable String employeId,@RequestBody Employe employe) {
            return employeService.updateEmploye(employeId,employe);
        }
    @PutMapping("/device")
    public String saveDevice(@PathVariable String employeId,@RequestBody String token) {
        return employeService.saveDeviceToken(token, employeId);
    }
    @PutMapping("update/{employeId}")
    public User ModifyEmployeFromRH(@PathVariable String employeId,@RequestBody Employe employe) {
        return employeService.updateEmployeFromDashboard(employeId,employe);
    }

    @PutMapping("/changePassword/{employeId}")
    public User changePassword(@PathVariable String employeId,@RequestParam String currentPassword,@RequestParam String newPassword) throws Exception {
        return employeService.changePassword(employeId ,currentPassword,newPassword);    }

        @DeleteMapping("/{employeId}")
        public String deleteEmploye(@PathVariable String employeId) {
            return employeService.deleteEmploye(employeId);
        }
    }

