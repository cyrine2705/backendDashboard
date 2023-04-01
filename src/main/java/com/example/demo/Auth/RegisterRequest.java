package com.example.demo.Auth;

import com.example.demo.models.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.Date;

public class RegisterRequest {

    private String lastName;
    private String firstName;
    private String email;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date birthDate;
    private String adress;
    private int cin;
    private int phoneNumber1;
    private int phoneNumber2;
    private String image;
    private String password;
    private int nbConge;

    private Role role;
    private String situation;
    private String sexe;
    private int nbEnfants;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAdress() {
        return adress;
    }

    public int getCin() {
        return cin;
    }

    public int getPhoneNumber1() {
        return phoneNumber1;
    }

    public int getPhoneNumber2() {
        return phoneNumber2;
    }

    public String getImage() {
        return image;
    }

    public String getPassword() {
        return password;
    }

    public int getNbConge() {
        return nbConge;
    }

    public Role getRole() {
        return role;
    }

    public String getSituation() {
        return situation;
    }

    public String getSexe() {
        return sexe;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}

