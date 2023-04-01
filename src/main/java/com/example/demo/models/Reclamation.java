package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Reclamation {
    private Integer id;

    private String sujet;
    private String description;
    private Integer idEmploye;

    public String getDescription() {
        return description;
    }

    public String getSujet() {
        return sujet;
    }

    public Integer getIdEmploye() {
        return idEmploye;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public void setIdEmploye(Integer idEmploye) {
        this.idEmploye = idEmploye;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }


}
