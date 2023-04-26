package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Event {
    private String id;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date from;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date to;
    private String type;
    private String description;
    private String title;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public String getType() {
        return type;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setType(String type) {
        this.type = type;
    }
}
