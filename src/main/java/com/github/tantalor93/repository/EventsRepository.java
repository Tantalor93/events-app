package com.github.tantalor93.repository;

import com.github.tantalor93.model.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventsRepository extends CrudRepository<EventEntity, String> {
    List<EventEntity> findAllByUserId(final String userId);

    List<EventEntity> findAll();

}
