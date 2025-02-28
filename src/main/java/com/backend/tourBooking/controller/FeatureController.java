package com.backend.tourBooking.controller;
import java.util.List;

import com.backend.tourBooking.dto.input.FeatureInputDTO;
import com.backend.tourBooking.dto.output.FeatureOutputDTO;
import com.backend.tourBooking.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/features")
public class FeatureController {

    @Autowired
    private IFeatureService service;

    @GetMapping
    public List<FeatureOutputDTO> getAllFeatures() {
        return service.getAllFeatures();
    }

    @GetMapping("/{id}")
    public FeatureOutputDTO getFeatureById(@PathVariable Long id) {
        return service.getFeatureById(id);
    }

    @PostMapping
    public FeatureOutputDTO createFeature(@RequestBody FeatureInputDTO featureInput) {
        return service.createFeature(featureInput);
    }

    @PutMapping("/{id}")
    public FeatureOutputDTO updateFeature(@PathVariable Long id, @RequestBody FeatureInputDTO featureInput) {
        return service.updateFeature(id, featureInput);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFeature(@PathVariable Long id) {
        service.deleteFeature(id);
        return ResponseEntity.ok().build();
    }
}
