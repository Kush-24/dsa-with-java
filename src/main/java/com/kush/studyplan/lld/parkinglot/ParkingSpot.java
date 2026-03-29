package com.kush.studyplan.lld.parkinglot;
public class ParkingSpot {
     enum SpotSize {
        SMALL, MEDIUM, LARGE
    }

    private int spotNumber;
    private SpotSize size;
    private boolean available;

    public ParkingSpot(int spotNumber, SpotSize size) {
        this.spotNumber = spotNumber;
        this.size = size;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public SpotSize getSize() {
        return size;
    }

	public int getSpotNumber() {
		return spotNumber;
	}

	public void setSpotNumber(int spotNumber) {
		this.spotNumber = spotNumber;
	}

	public void setSize(SpotSize size) {
		this.size = size;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
    
}

