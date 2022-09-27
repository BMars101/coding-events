package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends AbstractEntity {

    private String name;

    @ManyToMany(mappedBy="tags")
    private final List<Event> events = new ArrayList<>();
    public Tag(String name){
        this.name = name;
    }
    public Tag(){}

    public String getName() {
        return name;
    }

    public String getDisplayTagName(){
        return "#" + name + " ";
    }

    public void setName(String name) {
        this.name = name;
    }
}
