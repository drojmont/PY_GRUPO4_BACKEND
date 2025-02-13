package com.backend.tourBooking.dto.input;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductInputDTO {
    private String nombre;
    private String descripcion;
    private double precio;
    private List<String> imgenUrl;


}
