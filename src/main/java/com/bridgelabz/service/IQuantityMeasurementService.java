package com.bridgelabz.service;

import com.bridgelabz.Quantity;
import com.bridgelabz.IMeasurable;

public interface IQuantityMeasurementService {

    <U extends IMeasurable> boolean compare(Quantity<U> q1, Quantity<U> q2);

    <U extends IMeasurable> Quantity<U> convert(Quantity<U> quantity, U targetUnit);

    <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2);

    <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit);

    <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2);

    <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit);

    <U extends IMeasurable> double divide(Quantity<U> q1, Quantity<U> q2);
}
