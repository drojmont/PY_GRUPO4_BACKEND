package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;

public interface IProductService {
    ProductOutputDTO saveProduct(ProductInputDTO productInputDTO);
}
