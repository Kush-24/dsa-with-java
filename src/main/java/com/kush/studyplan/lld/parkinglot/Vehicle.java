package com.kush.studyplan.lld.parkinglot;
public class Vehicle {
    private ParkingSpot.SpotSize size;

    public Vehicle(ParkingSpot.SpotSize size) {
        this.size = size;
    }

    public ParkingSpot.SpotSize getSize() {
        return size;
    }
}

