package com.bridgelabz.controller;

import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping
    public QuantityMeasurementEntity save(@RequestBody QuantityMeasurementEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<QuantityMeasurementEntity> getAll() {
        return service.getAll();
    }

    @DeleteMapping
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/count")
    public int count() {
        return service.getTotalCount();
    }
}