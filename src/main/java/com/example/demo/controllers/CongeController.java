package com.example.demo.controllers;

import com.example.demo.models.Conge;
import com.example.demo.services.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/conge")
public class CongeController {
    @Autowired
    private CongeService congeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conge createconge(@RequestBody Conge conge) {
        return	congeService.addConge(conge);
    }

    @GetMapping
    public List<Conge> getconge(){
        return congeService.getAllConge();
    }

    @GetMapping("/{congeId}")
    public Conge getConge(@PathVariable String congeId) {
        return congeService.getConge(congeId);
    }
    @PostMapping("/{congeId}")
    public Conge changeLeaveState(@PathVariable String congeId, @RequestBody Map<String, Object> requestBody) {
        String etat = (String) requestBody.get("etat");
        Integer nb = (Integer) requestBody.get("nb");
        return congeService.changeState(congeId, etat,nb);
    }
    @GetMapping("/employe/{employeId}")
    public List<Conge> getCongebyEmploye(@PathVariable String employeId) {
        return congeService.getCongeByEmployeId(employeId);
    }
    @DeleteMapping("/{congeId}")
    public String deleteconge(@PathVariable String congeId) {
        return congeService.deleteconge(congeId);
    }


}
