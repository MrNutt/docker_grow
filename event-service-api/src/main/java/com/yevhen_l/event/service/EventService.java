package com.yevhen_l.event.service;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Long id, Event event);
    Event deleteEvent(Long id);
    Event getEvent(Long id);
    List<Event> getAllEvents();
}
