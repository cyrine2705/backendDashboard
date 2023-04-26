package com.example.demo.controllers;

import com.example.demo.models.Materiel;
import com.example.demo.services.MaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/material")
public class MaterielController {
    @Autowired
    private MaterielService materielService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Materiel createmateriel(@RequestBody Materiel materiel) {
        return	materielService.addMateriel(materiel);
    }

    @GetMapping
    public List<Materiel> getmateriel(){
        return materielService.getAllMateriel();
    }
    @GetMapping("/employe/{employeId}")
    public List<Materiel> getCongebyEmploye(@PathVariable String employeId) {
        return materielService.getMaterialByEmployeId(employeId);
    }

    @GetMapping("/{materielId}")
    public Materiel getmateriel(@PathVariable int materielId) {
        return materielService.getMateriel(materielId);
    }
    @DeleteMapping("/{materielId}")
    public String deletemateriel(@PathVariable int materielId) {
        return materielService.deletemateriel(materielId);
    }


}
