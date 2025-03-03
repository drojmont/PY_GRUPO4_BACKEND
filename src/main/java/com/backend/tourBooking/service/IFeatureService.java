package com.backend.tourBooking.service;

import com.backend.tourBooking.dto.input.FeatureInputDTO;
import com.backend.tourBooking.dto.output.FeatureOutputDTO;

import java.util.List;

public interface IFeatureService {
    List<FeatureOutputDTO> getAllFeatures();

    FeatureOutputDTO getFeatureById(Long id);

    FeatureOutputDTO createFeature(FeatureInputDTO featureInput);

    FeatureOutputDTO updateFeature(Long id, FeatureInputDTO featureInput);

    void deleteFeature(Long id);
}
