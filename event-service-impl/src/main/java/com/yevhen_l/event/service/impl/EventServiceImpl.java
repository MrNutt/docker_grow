package com.yevhen_l.event.service.impl;

import com.yevhen_l.event.service.Event;
import com.yevhen_l.event.service.EventService;
import com.yevhen_l.event.service.impl.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        Optional<Event> existingEvent = eventRepository.findById(id);
        Event result = null;
        if (existingEvent.isPresent()) {
            event.setId(existingEvent.get().getId());
            result = eventRepository.save(event);
        }

        return result;
    }

    public Event deleteEvent(Long id) {
        Optional<Event> existingEvent = eventRepository.findById(id);
        Event result = null;
        if (existingEvent.isPresent()) {
            result = existingEvent.get();
            eventRepository.deleteById(id);
        }

        return result;
    }

    public Event getEvent(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public List<Event> getAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }
}
