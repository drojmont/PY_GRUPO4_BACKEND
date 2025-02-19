package com.backend.tourBooking.controller;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.service.IProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("productos")
@CrossOrigin
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
    private IProductService productService;

    public ProductoController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/registrar", produces = "application/json")
    public ResponseEntity<ProductOutputDTO> registerProduct(@RequestBody @Valid ProductInputDTO productInputDTO){

        ProductOutputDTO productOutputDTO = productService.saveProduct(productInputDTO);
        return new ResponseEntity<>(productOutputDTO, HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProductOutputDTO>> listAllProducts() {
        List<ProductOutputDTO> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductOutputDTO> getProductById(@PathVariable Long id) {
        ProductOutputDTO product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductOutputDTO> updateProduct(@PathVariable Long id, @RequestBody @Valid ProductInputDTO dto) {
        ProductOutputDTO updatedProduct = productService.updateProduct(id, dto);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

}
