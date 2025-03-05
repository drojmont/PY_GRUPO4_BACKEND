package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.input.CategoryInputDTO;
import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.CategoryOutputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.entity.Category;

import java.util.List;

public interface ICategoryService {
    CategoryOutputDTO saveCategory(CategoryInputDTO categorytInputDTO);
    CategoryOutputDTO getCategoryById(Long id_categoria);
    List<CategoryOutputDTO> getAllCategories();
    CategoryOutputDTO saveCategory(ProductInputDTO productInputDTO);

    void deleteCategory(Long id_category);
}
