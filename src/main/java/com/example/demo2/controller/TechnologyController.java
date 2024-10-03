package com.example.demo2.controller;

import com.example.demo2.container.TechnologyContainer;
import com.example.demo2.model.Technology;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class TechnologyController implements Serializable {

    @Inject
    private TechnologyContainer technologyContainer;

    @Valid
    private Technology technology = new Technology();

    public String addTechnology() {
        technologyContainer.addTechnology(new Technology(technology.getName(), technology.getDescription()));
        technology = new Technology();

        return "about.xhtml?faces-redirect=true";
    }

    public Technology getTechnology() {
        return technology;
    }

    public List<Technology> getTechnologyList() {
        return technologyContainer.getTechnologyList();
    }
}
