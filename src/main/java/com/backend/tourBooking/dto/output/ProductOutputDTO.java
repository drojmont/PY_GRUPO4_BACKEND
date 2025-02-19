package com.backend.tourBooking.dto.output;

import java.util.List;


public class ProductOutputDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> images;

    public ProductOutputDTO() {};

    public ProductOutputDTO(Long id, String name, String description, List<String> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }


}
