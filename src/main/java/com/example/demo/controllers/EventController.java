package com.example.demo.controllers;

import com.example.demo.models.Event;
import com.example.demo.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
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
    public Event getEvent(@PathVariable String  eventId) {
        return eventService.getEvent(eventId);
    }


    @PutMapping
    public Event ModifyEvent(@RequestBody Event event) {
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable String eventId) {
        return eventService.deleteEvent(eventId);
    }


}
