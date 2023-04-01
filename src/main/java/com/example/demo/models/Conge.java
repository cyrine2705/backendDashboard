package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Conge {
    private int id;
    private String type;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date datedebut;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date datefin;
    private String description;
    private String preuve;
    private String etat;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public String getDescription() {
        return description;
    }

    public String getPreuve() {
        return preuve;
    }

    public String getEtat() {
        return etat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreuve(String preuve) {
        this.preuve = preuve;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
