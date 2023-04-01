package com.example.demo.controllers;
import java.util.List;

import com.example.demo.models.Event;
import com.example.demo.services.EventService;
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
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event createEvent(@RequestBody Event event) {
        return	eventService.addEvent(event);
    }

    @GetMapping
    public List<Event> getEvent(){
        return eventService.getAllEvent();
    }

    @GetMapping("/{eventId}")
    public Event getEvent(@PathVariable int eventId) {
        return eventService.getEvent(eventId);
    }

    @PutMapping
    public Event ModifyEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable int eventId) {
        return eventService.deleteEvent(eventId);
    }


}
