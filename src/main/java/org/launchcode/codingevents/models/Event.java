package org.launchcode.codingevents.models;

//import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.*;


@Entity
public class Event extends AbstractEntity{

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @ManyToOne
    @NotNull(message = "Category is required")
    private EventCategory eventCategory;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private EventDetails eventDetails;

    public Event(String name, EventCategory eventCategory) {
        this.name = name;
        this.eventCategory = eventCategory;

    }
    public Event(){}

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    public EventDetails getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(EventDetails eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return name;
    }

}
