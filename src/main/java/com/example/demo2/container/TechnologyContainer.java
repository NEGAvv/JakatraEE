package com.example.demo2.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.demo2.model.Technology;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class TechnologyContainer implements Serializable {

    private List<Technology> technologies = new ArrayList<>(List.of(
            new Technology("Laravel", "Laravel is a PHP framework that simplifies web application development."),
            new Technology("Jakatra EE", "Jakarta EE is a Java framework for building scalable enterprise applications."),
            new Technology("Angular", "Angular is a TypeScript framework for creating dynamic single-page applications.")));

    public void addTechnology(Technology tech) {
        technologies.add(tech);
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }
    public Technology getTechnology(int id) {
        for (Technology tech : technologies) {
            if (tech.getId() == id) {
                return tech;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        technologies.removeIf(tech -> tech.getId() == id);
    }
}
