package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.CategoryOutputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id_categoria);
    List<CategoryOutputDTO> getAllCategories();
    CategoryOutputDTO saveCategory(ProductInputDTO productInputDTO);
}
