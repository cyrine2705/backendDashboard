package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Materiel {
    private int id;
    private String type;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date;
    private String description;
    private int quantite;
    private String etat;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getEtat() {
        return etat;
    }
}
