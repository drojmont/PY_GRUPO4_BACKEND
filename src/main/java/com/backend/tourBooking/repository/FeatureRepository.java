package com.backend.tourBooking.repository;
import com.backend.tourBooking.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
