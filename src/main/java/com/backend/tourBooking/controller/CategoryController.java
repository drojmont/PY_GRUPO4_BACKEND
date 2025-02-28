package com.backend.tourBooking.controller;

import com.backend.tourBooking.dto.input.CategoryInputDTO;
import com.backend.tourBooking.dto.output.CategoryOutputDTO;
import com.backend.tourBooking.entity.Category;
import com.backend.tourBooking.service.ICategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<CategoryOutputDTO> saveCategory(@RequestBody @Valid CategoryInputDTO categoryInputDTO){
        CategoryOutputDTO categorytOutputDTO = categoryService.saveCategory(categoryInputDTO);
        return new ResponseEntity<>(categorytOutputDTO, HttpStatus.CREATED);
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
