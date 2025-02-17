package com.backend.tourBooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(length = 2000)
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Product() {}

    public Product(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl =imageUrl;
    }

    public List<String> getStringUrlAsList(){
        return this.imageUrl != null ? new ArrayList<>(Arrays.asList(this.imageUrl.split(","))) : new ArrayList<>();

    }
    public void setImageUrlFromList(List<String> imageUrlList) {
        this.imageUrl = (imageUrlList == null || imageUrlList.isEmpty()) ? "" : String.join(",", imageUrlList);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
