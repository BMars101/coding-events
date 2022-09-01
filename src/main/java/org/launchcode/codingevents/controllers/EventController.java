package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventsData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventsData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEvent(Model model){
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@ModelAttribute Event newEvent){
        EventsData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String deleteEventForm(Model model){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventsData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String deleteEvents(@RequestParam(required = false) int[] eventIds){

        if(eventIds != null){
            for(int id : eventIds){
                EventsData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId){
        Event eventToEdit = EventsData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit event " + eventToEdit.getName() + "(id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title);
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description){
        Event eventToEdit = EventsData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";

    }


}
