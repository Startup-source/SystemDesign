package ParkingLotDesign.Spot;

import ParkingLotDesign.Vehicle;

public abstract class ParkingSpot {
    private String id;
    private boolean isFree;
    private Vehicle vehicle;
    private SpotType spotType;

    public ParkingSpot(String id, SpotType spotType) {
        this.id = id;
        this.spotType = spotType;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isFree = true;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
