package com.backend.tourBooking.dto.output;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductOutputDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> imageUrl;

    public ProductOutputDTO() {};

    public ProductOutputDTO(Long id, String name, String description, List<String> imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
