package com.backend.tourBooking.dto.input;

import com.backend.tourBooking.entity.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductInputDTO {
    private String name;
    private String description;
    @JsonProperty("images")
    private List<String> images;
    @JsonProperty("categoryId")
    private Long category;

    public ProductInputDTO() {};

    public ProductInputDTO(String name, String description, List<String> images,Long category) {
        this.name = name;
        this.description = description;
        this.images = images;
        this.category = category;
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

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }
}
