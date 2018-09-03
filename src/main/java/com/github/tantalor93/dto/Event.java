package com.github.tantalor93.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("event")
public class Event {
    private final String id;

    private final String userId;

    private final String type;

    public Event(final String id, final String userId, final String type) {
        this.id = id;
        this.userId = userId;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }
}
