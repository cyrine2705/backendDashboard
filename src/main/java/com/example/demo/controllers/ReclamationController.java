package com.example.demo.controllers;

import com.example.demo.models.Reclamation;
import com.example.demo.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/reclamations")
public class ReclamationController {
    @Autowired
    private ReclamationService reclamationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reclamation createReclamation(@RequestBody Reclamation reclamation) {
        return	reclamationService.addReclamation(reclamation);
    }

    @GetMapping
    public List<Reclamation> getReclamtion(){
        return reclamationService.getAllreclamation();
    }

    @GetMapping("/{reclamationId}")
    public Reclamation getreclamation(@PathVariable String reclamationId) {
        return reclamationService.getreclamation(reclamationId);
    }

    @PutMapping
    public Reclamation ModifyEmploye(@RequestBody Reclamation reclamation) {
        return reclamationService.updatereclamation(reclamation);
    }

    @DeleteMapping("/{reclamationId}")
    public String deleteReclamation(@PathVariable String reclamationId) {
        return reclamationService.deleteReclamation(reclamationId);
    }


}
