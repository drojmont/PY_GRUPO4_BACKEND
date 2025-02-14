package com.backend.tourBooking.repository;

import com.backend.tourBooking.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
