package com.example.demo.controllers;

import com.example.demo.models.HR;
import com.example.demo.models.User;
import com.example.demo.services.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HRs")
public class HRController {
    @Autowired
    private HRService HRService;


    @GetMapping
    public List<User> getHrs() {
        return HRService.getAllEmployees();
    }

    @GetMapping("/{employeId}")
    public HR getEmploye(@PathVariable String employeId) {
        return HRService.getRH(employeId);
    }

    @PutMapping
    public HR ModifyEmploye(@RequestBody HR hr) {
        return HRService.updateRH(hr);
    }

    @DeleteMapping("/{employeId}")
    public String deleteEmploye(@PathVariable String employeId) {
        return HRService.deleteHR(employeId);
    }
}

