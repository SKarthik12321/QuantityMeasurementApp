package com.bridgelabz.controller;

import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quantities")
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
    public String deleteAll() {
        service.deleteAll();
        return "Deleted all records";
    }
}