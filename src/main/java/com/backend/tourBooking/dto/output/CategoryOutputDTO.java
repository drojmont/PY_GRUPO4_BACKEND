package com.backend.tourBooking.dto.output;

public class CategoryOutputDTO {
    private Long id_category;
    private String name;
    private String description;
    private String imageUrl;

    public CategoryOutputDTO() {}

    public CategoryOutputDTO(String name, Long id_category, String description, String imageUrl) {
        this.name = name;
        this.id_category = id_category;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_category() {
        return id_category;
    }

    public void setId_category(Long id_category) {
        this.id_category = id_category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
