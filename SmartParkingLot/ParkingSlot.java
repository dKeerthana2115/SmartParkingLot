package com.LLD.SmartParkingLot;

public class ParkingSlot {
    private long slotId;
    private Vehicle vehicle;
    private String slotType;
    private boolean isOccupied;

    public ParkingSlot(long slotId, Vehicle vehicle, String slotType) {
        this.slotId = slotId;
        this.vehicle = null;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public long getSlotId() {
        return slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotId(long slotId) {
        this.slotId = slotId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setSlotType(String slotType) {
        this.slotType = slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isOccupied = true;
    }

    public void unParkVehicle() {
        this.vehicle = null;
        isOccupied = false;
    }

    public boolean canFit(Vehicle vehicle) {
        return !isOccupied && this.slotType.equals(vehicle.getVehicleType().toString());
    }

}
