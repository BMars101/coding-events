package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.*;

@Entity
public class EventDetails extends AbstractEntity{
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

    public EventDetails(String description, String location, String contactEmail, boolean mustRegister, Integer numOfAttendees) {
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.mustRegister = mustRegister;
        this.numOfAttendees = numOfAttendees;
    }

    public EventDetails(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
}
