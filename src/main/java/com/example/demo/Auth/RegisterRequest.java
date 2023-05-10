package com.example.demo.Auth;

import com.example.demo.models.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.util.Date;

public class RegisterRequest {
    private String id;

    private String lastName;
    private String firstName;
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd")
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
    private String deviceToken;

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setPhoneNumber1(int phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public void setPhoneNumber2(int phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNbConge(int nbConge) {
        this.nbConge = nbConge;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

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

    public String getId() {
        return id;
    }
}

