package com.bridgelabz;

import com.bridgelabz.controller.QuantityMeasurementController;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.repository.QuantityMeasurementDatabaseRepository;
import com.bridgelabz.repository.impl.QuantityMeasurementCacheRepository;
import com.bridgelabz.service.impl.QuantityMeasurementServiceImpl;
import com.bridgelabz.util.ApplicationConfig;

import java.util.logging.Logger;

public class QuantityMeasurementApp {

    private static final Logger logger = Logger.getLogger(QuantityMeasurementApp.class.getName());

    public static void main(String[] args) {

        String repoType = ApplicationConfig.get("repository.type");

        IQuantityMeasurementRepository repository;

        if ("db".equalsIgnoreCase(repoType)) {
            repository = new QuantityMeasurementDatabaseRepository();
            logger.info("Using DATABASE repository");
        } else {
            repository = QuantityMeasurementCacheRepository.getInstance();
            logger.info("Using CACHE repository");
        }

        QuantityMeasurementServiceImpl service =
                new QuantityMeasurementServiceImpl(repository);

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1.0, "FEET");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES");

        logger.info(controller.add(q1, q2).toString());
        logger.info(controller.subtract(q1, q2).toString());
        logger.info(String.valueOf(controller.divide(q1, q2)));
        logger.info(controller.convert(q1, "INCHES").toString());
        logger.info(String.valueOf(controller.compare(q1, q2)));

        logger.info("----- STORED DATA -----");
        repository.findAll().forEach(e -> logger.info(e.toString()));

        repository.deleteAll();

        try {
            repository.releaseResources();
        } catch (Exception ignored) {}
    }
}