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
        model.addAttribute("events", EventsData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEvent(){
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




}
