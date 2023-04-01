package com.example.demo.controllers;
import java.util.List;


import com.example.demo.models.Materiel;
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
@RequestMapping("/materiel")
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

    @GetMapping("/{materielId}")
    public Materiel getmateriel(@PathVariable int materielId) {
        return materielService.getMateriel(materielId);
    }
    @DeleteMapping("/{materielId}")
    public String deletemateriel(@PathVariable int materielId) {
        return materielService.deletemateriel(materielId);
    }


}
