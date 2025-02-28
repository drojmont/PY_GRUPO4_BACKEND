package com.backend.tourBooking.controller;

import com.backend.tourBooking.dto.output.CategoryOutputDTO;
import com.backend.tourBooking.entity.Category;
import com.backend.tourBooking.service.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategorById(@PathVariable Long id){
        Category category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryOutputDTO>> getAllCategories(){
        List<CategoryOutputDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

}
