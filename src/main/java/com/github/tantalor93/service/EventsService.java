package com.github.tantalor93.service;

import com.github.tantalor93.dto.Event;
import com.github.tantalor93.dto.EventToCreate;
import com.github.tantalor93.model.EventEntity;
import com.github.tantalor93.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsService {

    private final EventsRepository eventsRepository;

    @Autowired
    public EventsService(final EventsRepository eventsRepository) {
        this.eventsRepository = eventsRepository;
    }

    public Event saveEvent(final EventToCreate eventToCreate) {
        final EventEntity save = eventsRepository.save(new EventEntity(eventToCreate.getUserId(), eventToCreate.getType()));

        return new Event(save.getId(), save.getUserId(), save.getType());
    }

    public List<Event> findAllEventsForUser(final String userId) {
        return eventsRepository.findAllByUserId(userId)
                .stream()
                .map(eventEntity ->
                        new Event(
                                eventEntity.getId(),
                                eventEntity.getUserId(),
                                eventEntity.getType()
                        ))
                .collect(Collectors.toList());
    }
}
