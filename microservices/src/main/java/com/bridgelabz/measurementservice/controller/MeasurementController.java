package com.bridgelabz.measurementservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementController {

    @GetMapping("/measurements")
    public String measurements() {
        return "Measurement Service Running";
    }
}
