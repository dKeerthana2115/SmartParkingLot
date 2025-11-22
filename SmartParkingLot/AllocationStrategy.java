package com.LLD.SmartParkingLot;

import java.util.List;

public interface AllocationStrategy {
    ParkingSlot allocateSlot(List<ParkingFloor> floors, Vehicle vehicle);
}