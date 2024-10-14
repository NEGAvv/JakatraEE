package com.example.demo2.model;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class Technology implements Serializable {
    private static int idCounter = 1;
    private int id;
    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Description is required.")
    private String description;

    public Technology(String name, String description) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

