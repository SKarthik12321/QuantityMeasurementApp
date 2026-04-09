package com.bridgelabz;

import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.repository.QuantityMeasurementDatabaseRepository;
import com.bridgelabz.repository.impl.QuantityMeasurementCacheRepository;
import com.bridgelabz.service.IQuantityMeasurementService;
import com.bridgelabz.service.impl.QuantityMeasurementServiceImpl;
import com.bridgelabz.util.ApplicationConfig;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository;

        if ("db".equalsIgnoreCase(ApplicationConfig.getRepositoryType())) {
            repository = new QuantityMeasurementDatabaseRepository();
        } else {
            repository = new QuantityMeasurementCacheRepository();
        }

        IQuantityMeasurementService service = new QuantityMeasurementServiceImpl();

        System.out.println("Total Records: " + repository.getTotalCount());

        repository.deleteAll();

        System.out.println("After Delete: " + repository.getTotalCount());
    }
}