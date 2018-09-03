package com.github.tantalor93.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonTypeName("event")
public class EventToCreate {

    private final String userId;

    private final String type;

    @JsonCreator
    public EventToCreate(@JsonProperty("userId") final String userId,
                         @JsonProperty("type") final String type) {
        this.userId = userId;
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public String getType() {
        return type;
    }
}
