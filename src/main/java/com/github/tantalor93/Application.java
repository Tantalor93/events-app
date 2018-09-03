package com.github.tantalor93;

import com.github.tantalor93.dto.Event;
import com.github.tantalor93.dto.EventToCreate;
import com.github.tantalor93.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Application implements CommandLineRunner {
    @Autowired
    EventsService eventsService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Override
    public void run(final String... args) throws Exception {
        eventsService.saveEvent(new EventToCreate("user1", "type1"));
        List<Event> user1 = eventsService.findAllEventsForUser("user1");
        System.out.println(user1);
    }
}
