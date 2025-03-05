package com.backend.tourBooking.dto.input;

public class CategoryInputDTO {

    private Long id_category;
    private String name;
    private String description;
    private String imageUrl;

    public CategoryInputDTO() {}

    public CategoryInputDTO(String description, String name, Long id_category, String imageUrl) {
        this.description = description;
        this.name = name;
        this.id_category = id_category;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
