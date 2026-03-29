package com.kush.studyplan.lld.parkinglot;
import java.util.*;

public class ParkingLot {
    private Map<ParkingSpot.SpotSize, List<ParkingSpot>> availableSpotsBySize;

    public ParkingLot() {
        availableSpotsBySize = new HashMap<>();
        // Initialize available spots for each size
        for (ParkingSpot.SpotSize size : ParkingSpot.SpotSize.values()) {
            availableSpotsBySize.put(size, new ArrayList<>());
        }
    }

    public void addParkingSpot(ParkingSpot spot) {
        ParkingSpot.SpotSize size = spot.getSize();
        availableSpotsBySize.get(size).add(spot);
    }
    
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        ParkingSpot.SpotSize size = vehicle.getSize();
        if (availableSpotsBySize.containsKey(size)) {
            List<ParkingSpot> availableSpots = availableSpotsBySize.get(size);
            for (ParkingSpot spot : availableSpots) {
                if (spot.isAvailable()) {
                	spot.setAvailable(false); //its occupied now
                    return spot;
                }
            }
        }else {
        	System.out.println(size+":SpotSize is not Available..");
        }
        return null;
    }
    // Other methods...
}

