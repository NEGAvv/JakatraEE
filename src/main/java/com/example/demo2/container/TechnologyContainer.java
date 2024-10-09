package com.example.demo2.container;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.demo2.logger.FileLogger;
import com.example.demo2.model.Technology;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.concurrent.atomic.AtomicLong;

@Named
@ApplicationScoped
public class TechnologyContainer implements Serializable {
    private FileLogger fileLogger = new FileLogger();

    private final List<Technology> technologyList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong();

    public List<Technology> getTechnologyList() {
        return technologyList;
    }

    public void addTechnology(String name, String description) {
        Technology t = new Technology(idCounter.incrementAndGet(), name, description);
        fileLogger.log("Added technology: " + t.getName());
        technologyList.add(t);
    }

    public void removeTechnology(Technology t) {
        fileLogger.log("Removing tech to remove: " + t);
        technologyList.remove(t);
    }
}
