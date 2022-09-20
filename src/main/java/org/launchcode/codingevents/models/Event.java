package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    @NotBlank
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters.")
    private String name;

    @Size(max=500, message = "Description too long.")
    private String description;

    @NotNull
    @NotBlank
    @Size(max=46, message= "Please enter a location.")
    private String location;

    @NotBlank
    @Email(message = "Invalid email. Please try again")
    private String contactEmail;

    @AssertTrue(message="Must register for event.")
    private boolean mustRegister = true;

    @NotNull
    @Min(value=1, message="At least one attendee required")
    private Integer numOfAttendees;
    private int id;
    private static int nextId = 1;
    private EventType type;

    public Event(String name, String description, String contactEmail, String location, boolean mustRegister, Integer numOfAttendees, EventType type) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister = mustRegister;
        this.numOfAttendees = numOfAttendees;
        this.type = type;
        this.id = nextId;
        nextId++;
    }
    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
