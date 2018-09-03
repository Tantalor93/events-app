package com.github.tantalor93.rest;

import com.github.tantalor93.dto.Event;
import com.github.tantalor93.dto.EventToCreate;
import com.github.tantalor93.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EventsController {
    private final EventsService eventsService;

    @Autowired
    public EventsController(final EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GetMapping(value = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> findAllEvents() {
        return ResponseEntity.ok(eventsService.findAllEvents());
    }

    @GetMapping(value = "/users/{id}/events", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Event>> findAllEventsForUser(@PathVariable("id") final String id) {
        return ResponseEntity.ok(eventsService.findAllEventsForUser(id));
    }

    @PostMapping(
            value = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Event> createEvent(@RequestBody EventToCreate eventToCreate) throws Exception {
        Event event = eventsService.saveEvent(eventToCreate);
        return ResponseEntity.created(new URI("/events/" + event.getId())).body(event);
    }

    @GetMapping(value = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> findEventById(@PathVariable("id") final String id) {
        final Optional<Event> eventById = eventsService.findEventById(id);
        if (eventById.isPresent()) {
            return ResponseEntity.ok(eventById.get());
        }
        return ResponseEntity.notFound().build();
    }
}
