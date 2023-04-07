package com.example.demo.services;

import com.example.demo.models.Event;
import com.example.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;





    public Event addEvent(Event event) {

        return eventRepository.save(event);

    }


    public List<Event> getAllEvent(){
        return eventRepository.findAll();
    }


    public  Event getEvent(String eventId) {
        return eventRepository.findById(eventId).get();
    }
    public Event  updateEvent(Event event) {
        Event updatedEvent = eventRepository.findById(event.getId()).get();
        updatedEvent.setId(event.getId());
        updatedEvent.setDateDebut(event.getDateDebut());
        updatedEvent.setDateFin(event.getDateFin());
        updatedEvent.setType(event.getType());
        return eventRepository.save(updatedEvent);}

    public String deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
        return "deleted from dashboard";
    }
}
