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
}
