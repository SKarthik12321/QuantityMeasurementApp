package com.bridgelabz;

import com.bridgelabz.controller.QuantityMeasurementController;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.repository.impl.QuantityMeasurementCacheRepository;import com.bridgelabz.service.IQuantityMeasurementService;
import com.bridgelabz.service.impl.QuantityMeasurementServiceImpl;
public class QuantityMeasurementApp {

    public static void main(String[] args) {

        IQuantityMeasurementRepository repository =
                QuantityMeasurementCacheRepository.getInstance();

        QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl();

        QuantityMeasurementController controller =
                new QuantityMeasurementController(service);

        QuantityDTO q1 = new QuantityDTO(1.0, "FEET");
        QuantityDTO q2 = new QuantityDTO(12.0, "INCHES");

        System.out.println(controller.add(q1, q2));
        System.out.println(controller.subtract(q1, q2));
        System.out.println(controller.divide(q1, q2));
        System.out.println(controller.convert(q1, "INCHES"));
        System.out.println(controller.compare(q1, q2));

        QuantityDTO t1 = new QuantityDTO(100.0, "CELSIUS");
        QuantityDTO t2 = new QuantityDTO(50.0, "CELSIUS");

        System.out.println(controller.add(t1, t2));
    }
}
