package com.backend.tourBooking.service.impl;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.entity.Product;
import com.backend.tourBooking.repository.ProductRepository;
import com.backend.tourBooking.service.IProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProductOutputDTO saveProduct(ProductInputDTO productInputDTO) {

       Product productEntity = modelMapper.map(productInputDTO, Product.class);

        if (productInputDTO.getImageUrl() != null) {
            productEntity.setImageUrl(String.join(",", productInputDTO.getImageUrl()));
        }

        Product savedProduct = productRepository.save(productEntity);
        ProductOutputDTO productOutputDTO = modelMapper.map(savedProduct, ProductOutputDTO.class);
        productOutputDTO.setImageUrl(savedProduct.getStringUrlAsList());

       return productOutputDTO;
    }
    @Override
    public List<ProductOutputDTO> findAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductOutputDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProductOutputDTO findProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return modelMapper.map(product, ProductOutputDTO.class);
    }

    @Override
    public ProductOutputDTO updateProduct(Long id, ProductInputDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setImageUrl(String.join(",", dto.getImageUrl()));

        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductOutputDTO.class);
    }

    @Override
    public void deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productRepository.deleteById(id);
    }
}
