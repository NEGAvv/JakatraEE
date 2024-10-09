package com.example.demo2.controller;

import com.example.demo2.container.TechnologyContainer;
import com.example.demo2.model.Technology;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;
import com.example.demo2.logger.FileLogger;

@Named
@ViewScoped
public class TechnologyController implements Serializable {

    @Inject
    private TechnologyContainer technologyContainer;

    @Valid
    private Technology technology = new Technology();

    private final FileLogger fileLogger = new FileLogger();

    public void addTechnology() {
        technologyContainer.addTechnology(technology.getName(), technology.getDescription());

        fileLogger.log("Added technology: " + technology.getName());
        technology = new Technology();
    }

    public void removeTechnology(Technology techToRemove) {
        fileLogger.log("Removing tech to remove: " + techToRemove);
        technologyContainer.removeTechnology(techToRemove);
    }

    public Technology getTechnology() {
        return technology;
    }

    public List<Technology> getTechnologyList() {
        return technologyContainer.getTechnologyList();
    }
}
