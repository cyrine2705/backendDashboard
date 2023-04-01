package com.example.demo.controllers;
import java.util.List;

import com.example.demo.models.Reclamation;
import com.example.demo.services.ReclamationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reclamation")
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
    public Reclamation getreclamation(@PathVariable int reclamationId) {
        return reclamationService.getreclamation(reclamationId);
    }

    @PutMapping
    public Reclamation ModifyEmploye(@RequestBody Reclamation reclamation) {
        return reclamationService.updatereclamation(reclamation);
    }

    @DeleteMapping("/{reclamationId}")
    public String deleteReclamation(@PathVariable int reclamationId) {
        return reclamationService.deleteReclamation(reclamationId);
    }


}
