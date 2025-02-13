package com.backend.tourBooking.controller;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.service.IProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productos")
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    private IProductService productService;

    public ProductoController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<ProductOutputDTO> registerProduct(@RequestBody @Valid ProductInputDTO productInputDTO){

        ProductOutputDTO productOutputDTO = productService.saveProduct(productInputDTO);
        return new ResponseEntity<>(productOutputDTO, HttpStatus.CREATED);

    }

}
