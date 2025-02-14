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

}
