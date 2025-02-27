package com.backend.tourBooking.dto.output;

import com.backend.tourBooking.entity.Category;

import java.util.List;


public class ProductOutputDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> images;
    private CategoryOutputDTO categoryOutputDTO;

    public ProductOutputDTO() {};

    public ProductOutputDTO(Long id, String name, String description, List<String> images, CategoryOutputDTO categoryOutputDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
        this.categoryOutputDTO = categoryOutputDTO;
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

    public CategoryOutputDTO getCategoryOutputDTO() {
        return categoryOutputDTO;
    }

    public void setCategoryOutputDTO(CategoryOutputDTO categoryOutputDTO) {
        this.categoryOutputDTO = categoryOutputDTO;
    }
}
