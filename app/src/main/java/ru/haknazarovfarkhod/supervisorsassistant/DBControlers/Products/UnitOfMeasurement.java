package ru.haknazarovfarkhod.supervisorsassistant.DBControlers.Products;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Farhod.Haknazarov on 19.01.2018.
 */

public class UnitOfMeasurement {
    private String measurementName;

    public UnitOfMeasurement(String measurementName) {
        this.measurementName = measurementName;
    }

    public String getMeasurementName() {
        return measurementName;
    }

    public void setMeasurementName(String measurementName) {
        this.measurementName = measurementName;
    }

    public List<UnitOfMeasurement> getUnitOfMeasurementList(){
        List<UnitOfMeasurement> unitOfMeasurementArrayList = new ArrayList<>();
        unitOfMeasurementArrayList.add(new UnitOfMeasurement("шт"));
        unitOfMeasurementArrayList.add(new UnitOfMeasurement("кг"));

        return unitOfMeasurementArrayList;
    }
}
