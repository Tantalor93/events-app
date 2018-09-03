package com.github.tantalor93;

import com.github.tantalor93.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class Application {
    @Autowired
    EventsService eventsService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
