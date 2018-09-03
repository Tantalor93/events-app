package com.github.tantalor93.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class EventEntity {

    @Id
    private String id;

    @Indexed
    private String userId;

    @Indexed
    private String type;

    public EventEntity(final String userId, final String type) {
        this.userId = userId;
        this.type = type;
    }

    protected EventEntity() {
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
