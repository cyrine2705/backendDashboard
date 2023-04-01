package com.example.demo.controllers;
import java.util.List;

import com.example.demo.models.Conge;
import com.example.demo.models.Materiel;
import com.example.demo.services.CongeService;
import com.example.demo.services.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Conge getConge(@PathVariable int congeId) {
        return congeService.getConge(congeId);
    }
    @DeleteMapping("/{congeId}")
    public String deleteconge(@PathVariable int congeId) {
        return congeService.deleteconge(congeId);
    }


}
