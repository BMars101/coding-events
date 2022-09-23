package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class EventCategory extends AbstractEntity{

    @NotBlank
    private String name;

    public EventCategory(String name){
        this.name = name;
    }

    public EventCategory(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    public int getId() {
//        return id;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
