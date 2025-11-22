package com.LLD.SmartParkingLot;

import java.util.List;

public class NearestFirstStrategy implements AllocationStrategy {

    @Override
    public ParkingSlot allocateSlot(List<ParkingFloor> floors, Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            for (ParkingSlot slot : floor.getSlots().values()) {
                if (slot.canFit(vehicle)) {
                    System.out.println("Found suitable slot: " + slot.getSlotId() + " on floor: " + floor.getFloorId());
                    System.out.println("Allocating slot to vehicle: " + vehicle.getVehicleNumber());
                    return slot;
                } else {
                    System.out.println("Slot " + slot.getSlotId() + " is not suitable (occupied or wrong type)");
                }
            }
        }
        System.out.println("No available slots found for vehicle: " + vehicle.getVehicleNumber());
        return null;
    }
}