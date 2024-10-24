package org.example.lifesafe.util;

import org.example.lifesafe.model.entities.Automobile;
import org.example.lifesafe.model.enums.CarUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class CalculateDevis {
    private static final double BASE_PRICE = 500.0;
    private static final double UNDER_25_YEARS_AGE_SURCHARGE = 0.10;
    private static final double LUXURY_VEHICLE_SURCHARGE = 0.15;
    private static final double PROFESSIONAL_USE_SURCHARGE = 0.10;
    private static final double NO_ACCIDENT_DISCOUNT = 0.20;
    private static final double ACCIDENT_SURCHARGE = 0.10;

    public double calculateAutomobileDevis(Automobile automobile) {
        double totalQuote = BASE_PRICE;

        if (automobile.getDriverAge() < 25) {
            totalQuote += BASE_PRICE * UNDER_25_YEARS_AGE_SURCHARGE;
        }

        if ("luxe".equalsIgnoreCase(automobile.getCar().getType())) {
            totalQuote += BASE_PRICE * LUXURY_VEHICLE_SURCHARGE;
        }

        if (automobile.getCarUse() == CarUse.Professional) {
            totalQuote += BASE_PRICE * PROFESSIONAL_USE_SURCHARGE;
        }

        if (automobile.getLastAccidentDate() != null) {
            int yearsSinceLastAccident = (int) ChronoUnit.YEARS.between(automobile.getLastAccidentDate(), LocalDate.now());
            if (yearsSinceLastAccident < 3) {
                totalQuote += BASE_PRICE * ACCIDENT_SURCHARGE;
            } else {
                totalQuote -= BASE_PRICE * NO_ACCIDENT_DISCOUNT;
            }
        }

        return totalQuote;
    }
}
