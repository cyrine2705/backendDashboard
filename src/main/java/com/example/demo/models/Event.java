package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    private int id;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dateDebut;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dateFin;
    private String type;

    public int getId() {
        return id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setType(String type) {
        this.type = type;
    }
}
