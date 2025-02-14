package com.backend.tourBooking.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductInputDTO {
    private String name;
    private String description;
    private List<String> imageUrl;

    public ProductInputDTO(String name, String description, List<String> imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
