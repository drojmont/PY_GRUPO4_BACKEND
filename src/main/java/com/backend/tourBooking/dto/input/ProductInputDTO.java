package com.backend.tourBooking.dto.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductInputDTO {
    private String name;

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

    public List<String> getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(List<String> imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String description;

    //@NotEmpty(message = "La lista de imágenes no puede estar vacía")
    //@Size(min = 5, max = 5, message = "Debe proporcionar exactamente 5 imágenes")
    private List<String> imageUrl;

    public ProductInputDTO() {};

    public ProductInputDTO(String name, String description, List<String> imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
