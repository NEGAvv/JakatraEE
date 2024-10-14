package com.example.demo2.controller;

import com.example.demo2.container.TechnologyContainer;
import com.example.demo2.logger.FileLogger;
import com.example.demo2.model.Technology;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;
import com.example.demo2.logger.FileLogger;

import jakarta.ws.rs.core.Response;

@Path("technologies")
@RequestScoped
@Controller
public class TechnologyController implements Serializable {
    @Inject
    private Models models;

    @Inject
    private TechnologyContainer technologyContainer;

    private FileLogger fileLogger = new FileLogger();


    @GET
    @View("technologies.xhtml")
    public void showTechnologies() {
        models.put("technologies", technologyContainer.getTechnologies());
    }

    @POST
    public Response addTechnology(@FormParam("newTechName") String newTechName, @FormParam("newTechDescription") String newTechDescription) {
        Technology newTech = new Technology(newTechName, newTechDescription);
        technologyContainer.addTechnology(newTech);
        fileLogger.log("Added technology: " + newTech);
        return Response.ok("redirect:technologies").build();
    }

    @POST
    @Path("/delete")
    public Response deleteTechnology(@FormParam("id") int id) {
        fileLogger.log("Removing tech to remove: " + technologyContainer.getTechnology(id));
        technologyContainer.deleteById(id);
        return Response.ok("redirect:technologies").build();
    }

}
