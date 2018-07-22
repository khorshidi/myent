package com.taher.myent.myentengine.controller;

import com.taher.myent.myentengine.Event;
import com.taher.myent.myentengine.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Taher Khorshidi
 */
@RestController(value = "/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void create(Event event) {
        eventService.save(event);
    }

}
