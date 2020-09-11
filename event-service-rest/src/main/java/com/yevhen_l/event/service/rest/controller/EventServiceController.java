package com.yevhen_l.event.service.rest.controller;

import com.yevhen_l.event.service.Event;
import com.yevhen_l.event.service.EventService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/docker-api/event-service")
@Api(value = "event-service")
public class EventServiceController {

    @Autowired
    private EventService eventService;

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @ApiOperation(
            response = Event.class,
            produces = APPLICATION_JSON_VALUE,
            value = "Create Event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event created", response = Event.class),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public @ResponseBody
    ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event newEvent = eventService.createEvent(event);
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(
            response = Event.class,
            produces = APPLICATION_JSON_VALUE,
            value = "Get Event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event returned", response = Event.class),
            @ApiResponse(code = 404, message = "Event is not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public @ResponseBody
    ResponseEntity<Event> getEvent(@ApiParam(name = "id", value = "Event id value", example = "1")
                                   @PathVariable(name = "id") Long id) {
        Event event = eventService.getEvent(id);
        ResponseEntity<Event> responseEntity;
        if (null != event) {
            responseEntity = ResponseEntity.ok(event);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }

        return responseEntity;
    }

    @PutMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(response = Event.class,
            produces = APPLICATION_JSON_VALUE,
            value = "Update Event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event updated", response = Event.class),
            @ApiResponse(code = 404, message = "Event not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public @ResponseBody
    ResponseEntity<Event> updateEvent(@ApiParam(name = "id", value = "event id", example = "1")
                                      @PathVariable(name = "id") Long id, @RequestBody Event event) {
        Event existingEvent = eventService.getEvent(id);
        ResponseEntity<Event> responseEntity;
        if (null != existingEvent) {
            Event updatedEvent = eventService.updateEvent(id, event);
            responseEntity = ResponseEntity.ok(updatedEvent);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }
        return responseEntity;
    }

    @DeleteMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    @ApiOperation(response = Event.class,
            produces = APPLICATION_JSON_VALUE,
            value = "Delete Event")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Event deleted", response = Event.class),
            @ApiResponse(code = 404, message = "Event not found"),
            @ApiResponse(code = 500, message = "Internal error")
    })
    public @ResponseBody
    ResponseEntity<Event> deleteEvent(@ApiParam(name = "id", value = "event id", example = "1")
                                      @PathVariable(name = "id") Long id) {
        Event existingEvent = eventService.getEvent(id);
        ResponseEntity<Event> responseEntity;
        if (null != existingEvent) {
            eventService.deleteEvent(id);
            responseEntity = ResponseEntity.ok(existingEvent);
        } else {
            responseEntity = ResponseEntity.notFound().build();
        }

        return responseEntity;
    }
}
