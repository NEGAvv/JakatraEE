package com.example.demo2.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo2.model.Technology;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
public class TechnologyContainer implements Serializable {
    private Technology technology;
    private List<Technology> technologyList;

    public TechnologyContainer() {
        this.technologyList = new ArrayList<>();
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void addTechnology(Technology technology) {
        this.technologyList.add(technology);
    }

    public void removeTechnology(Technology technology) {
        this.technologyList.remove(technology);
    }
}
