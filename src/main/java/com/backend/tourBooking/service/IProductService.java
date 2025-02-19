package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;

import java.util.List;

public interface IProductService {
    ProductOutputDTO saveProduct(ProductInputDTO productInputDTO);
    List<ProductOutputDTO> findAllProducts();
    ProductOutputDTO findProductById(Long id);
    ProductOutputDTO updateProduct(Long id, ProductInputDTO dto);
    void deleteProductById(Long id);
}
