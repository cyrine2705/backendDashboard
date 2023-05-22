package com.example.demo.controllers;

import com.example.demo.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/pointage")
@RequiredArgsConstructor
public class PointageController {
    @Autowired
    private EmployeService employeService;
    @PutMapping("/employe/{cin}")
    public String pointage(@PathVariable int cin, @RequestBody String datetime) {
        return employeService.presence(cin,datetime);
    }
    @GetMapping("/employe/{cin}")
    public String NameEmploye(@PathVariable int cin) {
        return employeService.getEmployeByCin(cin);
    }
    @GetMapping("/posture/{cin}")
    public String DeviceEmploye(@PathVariable int cin) {
        return employeService.getDeviceToken(cin);
    }
}
