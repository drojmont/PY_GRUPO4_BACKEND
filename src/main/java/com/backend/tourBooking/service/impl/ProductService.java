package com.backend.tourBooking.service.impl;

import com.backend.tourBooking.dto.input.ProductInputDTO;
import com.backend.tourBooking.dto.output.ProductOutputDTO;
import com.backend.tourBooking.entity.Category;
import com.backend.tourBooking.entity.Feature;
import com.backend.tourBooking.entity.Product;
import com.backend.tourBooking.repository.CategoryRepository;
import com.backend.tourBooking.repository.FeatureRepository;
import com.backend.tourBooking.repository.ProductRepository;
import com.backend.tourBooking.service.IProductService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final FeatureRepository featureRepository;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, FeatureRepository featureRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.featureRepository = featureRepository;
        configureMapping();
    }

    @Override
    public ProductOutputDTO saveProduct(ProductInputDTO productInputDTO) {
        LOGGER.info("ProductInputDTO recibido: {}", productInputDTO);
        LOGGER.info("Valor de categoría en ProductInputDTO: {}", productInputDTO.getCategory());

        Product productEntity = modelMapper.map(productInputDTO, Product.class);
        if (productInputDTO.getCategory() != null) {
            Category category = categoryRepository.findById(productInputDTO.getCategory())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            productEntity.setCategoria(category);
        }
        if (productInputDTO.getFeatureIds() != null && !productInputDTO.getFeatureIds().isEmpty()) {
            List<Feature> features = new ArrayList<>(featureRepository.findAllById(productInputDTO.getFeatureIds()));
            productEntity.setFeatures(features);
        }
        productEntity.setImages(productInputDTO.getImages());

        Product savedProduct = productRepository.save(productEntity);
        LOGGER.info("Producto guardado: {} - Categoría asignada: {}", savedProduct, savedProduct.getCategoria());
        return modelMapper.map(savedProduct, ProductOutputDTO.class);
    }

    @Override
    public List<ProductOutputDTO> findAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductOutputDTO.class))
                .toList();
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

        modelMapper.map(dto, product);

        if (dto.getCategory() != null) {
            Category category = categoryRepository.findById(dto.getCategory())
                    .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            product.setCategoria(category);
        }
        if (dto.getFeatureIds() != null && !dto.getFeatureIds().isEmpty()) {
            List<Feature> features = new ArrayList<>(featureRepository.findAllById(dto.getFeatureIds()));
            product.setFeatures(features);
        }
        product.setImages(dto.getImages());

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
    private void configureMapping() {
        modelMapper.typeMap(Product.class, ProductOutputDTO.class)
                .addMappings(mapper -> mapper.map(
                        src -> {
                            return src.getFeatures() != null ?
                                    src.getFeatures().stream().map(Feature::getName).collect(Collectors.toList()) :
                                    new ArrayList<String>();
                        },
                        ProductOutputDTO::setFeatures));
    }
}
