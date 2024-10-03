package com.example.demo2.model;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;

public class Technology implements Serializable {
    @NotBlank(message = "Name is required.")
    private String name;
    @NotBlank(message = "Description is required.")
    private String description;

    public Technology() {
    }

    public Technology(String name, String description) {
        this.name = name;
        this.description = description;
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
}
