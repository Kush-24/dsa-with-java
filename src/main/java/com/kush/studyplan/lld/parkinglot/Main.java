package com.kush.studyplan.lld.parkinglot;
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        // Adding some parking spots to the parking lot
        ParkingSpot spot1 = new ParkingSpot(1, ParkingSpot.SpotSize.SMALL);
        ParkingSpot spot2 = new ParkingSpot(2, ParkingSpot.SpotSize.MEDIUM);
        ParkingSpot spot3 = new ParkingSpot(3, ParkingSpot.SpotSize.LARGE);

        parkingLot.addParkingSpot(spot1);
        parkingLot.addParkingSpot(spot2);
        parkingLot.addParkingSpot(spot3);

        // Creating a vehicle
        Vehicle vehicle = new Vehicle(ParkingSpot.SpotSize.MEDIUM);

        // Finding an available spot for the vehicle
        ParkingSpot availableSpot = parkingLot.findAvailableSpot(vehicle);

        if (availableSpot != null) {
            System.out.println("Vehicle parked at spot: " + availableSpot.getSpotNumber());
            parkingLot.addParkingSpot(availableSpot);
        } else {
            System.out.println("No available spot for this vehicle size.");
        }
    }
}
