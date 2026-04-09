package com.bridgelabz.controller;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.service.IQuantityMeasurementService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantity")
public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    @PostMapping
    public QuantityMeasurementEntity save(@RequestBody QuantityMeasurementEntity entity) {
        return service.save(entity);
    }

    @GetMapping
    public List<QuantityMeasurementEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/count")
    public long count() {
        return service.getTotalCount();
    }
}