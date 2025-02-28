package com.backend.tourBooking.dto.input;

public class FeatureInputDTO {
    private String name;
    private String description;

    public FeatureInputDTO() {}

    public FeatureInputDTO(String name, String description) {
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
