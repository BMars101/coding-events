package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();
    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }
//    @GetMapping
//    public String displayHashMapEvents(Model model){
//        events.put("Code for Philly", "Join local coders and participate in coding projects in the area");
//        events.put("freeCodeCamp Hack Night", "Join other campers in this hackathon. Exercise skills, learn new skills and network.");
//        events.put("Tech Elevator Career Launch", "Learn about how to break into the tech industry with industry leaders.");
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEvent(){
        return "events/create";
    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName){
        events.add(eventName);
        return "redirect:";
    }


}
