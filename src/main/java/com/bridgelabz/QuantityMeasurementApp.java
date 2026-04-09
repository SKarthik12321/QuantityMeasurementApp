package com.bridgelabz;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.repository.QuantityMeasurementDatabaseRepository;
import com.bridgelabz.repository.impl.QuantityMeasurementCacheRepository;
import com.bridgelabz.service.impl.QuantityMeasurementServiceImpl;
import com.bridgelabz.util.ApplicationConfig;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository;

        if (ApplicationConfig.getRepositoryType().equalsIgnoreCase("db")) {
            repository = new QuantityMeasurementDatabaseRepository();
        } else {
            repository = QuantityMeasurementCacheRepository.getInstance();
        }

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        service.compare(
                new QuantityDTO(1.0, "FEET"),
                new QuantityDTO(12.0, "INCH")
        );

        System.out.println(repository.findAll());
        System.out.println("COUNT = " + repository.getTotalCount());
    }
}