package com.example.demo.models;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pointage {
    @Id
    private String id;
    private LocalDate date;
    private String idEmploye;
    private LocalDateTime employeEntryTime;
    private LocalDateTime employeExitingTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getIdEmploye() {
        return idEmploye;
    }

    public void setIdEmploye(String idEmploye) {
        this.idEmploye = idEmploye;
    }

    public LocalDateTime getEmployeEntryTime() {
        return employeEntryTime;
    }

    public void setEmployeEntryTime(LocalDateTime employeEntryTime) {
        this.employeEntryTime = employeEntryTime;
    }

    public LocalDateTime getEmployeExitingTime() {
        return employeExitingTime;
    }

    public void setEmployeExitingTime(LocalDateTime employeExitingTime) {
        this.employeExitingTime = employeExitingTime;
    }

    public Pointage( LocalDate date, String idEmploye, LocalDateTime employeEntryTime, LocalDateTime employeExitingTime) {

        this.date = date;
        this.idEmploye = idEmploye;
        this.employeEntryTime = employeEntryTime;
        this.employeExitingTime = employeExitingTime;
    }
}
