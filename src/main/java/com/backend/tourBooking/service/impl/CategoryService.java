package com.backend.tourBooking.service.impl;


import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.CategoryOutputDTO;
import com.backend.tourBooking.entity.Category;
import com.backend.tourBooking.repository.CategoryRepository;
import com.backend.tourBooking.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryService(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;

        this.modelMapper = modelMapper;
    }


    @Override
    public Category getCategoryById(Long id_category) {
        return categoryRepository.findById(id_category)
                .orElseThrow(() -> new RuntimeException("Categoria no encontrado"));

    }

    @Override
    public List<CategoryOutputDTO> getAllCategories() {
        List<CategoryOutputDTO> categoryOutputDTOS = categoryRepository.findAll().stream().map(category -> modelMapper.map(category, CategoryOutputDTO.class)).toList();
        return categoryOutputDTOS;
    }

    @Override
    public CategoryOutputDTO saveCategory(ProductInputDTO productInputDTO) {
        return null;
    }

}
