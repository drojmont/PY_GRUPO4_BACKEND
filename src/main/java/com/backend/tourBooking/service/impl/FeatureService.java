package com.backend.tourBooking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.backend.tourBooking.dto.input.FeatureInputDTO;
import com.backend.tourBooking.dto.output.FeatureOutputDTO;
import com.backend.tourBooking.entity.Feature;
import com.backend.tourBooking.repository.FeatureRepository;
import com.backend.tourBooking.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService implements IFeatureService {

    @Autowired
    private FeatureRepository repository;

    @Override
    public List<FeatureOutputDTO> getAllFeatures() {
        return repository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FeatureOutputDTO getFeatureById(Long id) {
        Feature feature = repository.findById(id).orElse(null);
        if (feature == null) {
            return null;
        }
        return convertToDto(feature);
    }

    @Override
    public FeatureOutputDTO createFeature(FeatureInputDTO featureInput) {
        Feature feature = convertToEntity(featureInput);
        Feature savedFeature = repository.save(feature);
        return convertToDto(savedFeature);
    }

    @Override
    public FeatureOutputDTO updateFeature(Long id, FeatureInputDTO featureInput) {
        Feature existingFeature = repository.findById(id).orElse(null);
        if (existingFeature == null) {
            return null;
        }
        existingFeature.setName(featureInput.getName());
        existingFeature.setDescription(featureInput.getDescription());
        Feature updatedFeature = repository.save(existingFeature);
        return convertToDto(updatedFeature);
    }

    @Override
    public void deleteFeature(Long id) {
        Feature existingFeature = repository.findById(id).orElse(null);
        if (existingFeature != null) {
            repository.delete(existingFeature);
        }
    }

    private FeatureOutputDTO convertToDto(Feature feature) {
        return new FeatureOutputDTO(feature.getId(), feature.getName(), feature.getDescription());
    }

    private Feature convertToEntity(FeatureInputDTO featureInput) {
        Feature feature = new Feature();
        feature.setName(featureInput.getName());
        feature.setDescription(featureInput.getDescription());
        return feature;
    }
}
