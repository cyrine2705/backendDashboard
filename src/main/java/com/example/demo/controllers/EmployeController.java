package com.example.demo.controllers;

import com.example.demo.models.Employe;
import com.example.demo.models.User;
import com.example.demo.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employes")
public class EmployeController {

        @Autowired
        private EmployeService employeService;


        @GetMapping
        public Optional<User> getEmployes() {
            return employeService.getAllEmployees();
        }

        @GetMapping("/{employeId}")
        public Employe getEmploye(@PathVariable String employeId) {
            return employeService.getEmploye(employeId);
        }

        @PutMapping
        public Employe ModifyEmploye(@RequestBody Employe employe) {
            return employeService.updateEmploye(employe);
        }

    @PutMapping("/changePassword")
    public Employe changePassword(@RequestBody String email, String currentPassword, String newPassword) throws Exception {
        return employeService.changePassword(email,currentPassword,newPassword);    }

        @DeleteMapping("/{employeId}")
        public String deleteEmploye(@PathVariable String employeId) {
            return employeService.deleteEmploye(employeId);
        }
    }

