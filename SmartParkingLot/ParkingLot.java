package com.LLD.SmartParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private long lotId;
    private List<ParkingFloor> floors;
    private AllocationStrategy allocationStrategy;

    public ParkingLot(long lotId, AllocationStrategy strategy) {
        this.lotId = lotId;
        this.floors = new ArrayList<>();
        this.allocationStrategy = strategy;
    }

    public long getLotId() {
        return lotId;
    }

    public void addLot(long lotId) {
        this.lotId = lotId;
    }

    public void addFloor(ParkingFloor floor) {
        this.floors.add(floor);
    }

    public void removeFloor(ParkingFloor floor) {
        this.floors.remove(floor);
    }

    public void maintanceOfFloor(ParkingFloor floor) {
        floor.isMaintance();
    }

    public boolean isAllFloorFull() {
        for (ParkingFloor floor : floors) {
            if (floor.isFloorFull()) {
                System.out.println("Floor is full" + floor.getFloorId());
                return true;
            }
        }
        System.out.println("Floor is not full");
        return false;
    }

    public boolean isFloorFull(ParkingFloor floor) {
        if (floor.isFloorFull()) {
            System.out.println("Floor is full" + floor.getFloorId());
            return true;
        }
        System.out.println("Floor is not full" + floor.getFloorId());
        return false;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }
    
    public boolean isSlotAvailable(Vehicle vehicle) {
        System.out.println("ParkingLot: Checking slot availability for vehicle " + vehicle.getVehicleNumber());
        
        for (ParkingFloor floor : floors) {
            if (floor.isSlotAvailable(vehicle)) {
                System.out.println("ParkingLot: Slot available on floor " + floor.getFloorId());
                return true;
            }
        }
        
        System.out.println("ParkingLot: No slots available for vehicle " + vehicle.getVehicleNumber());
        return false;
    }
    
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        System.out.println("ParkingLot: Processing vehicle entry for " + vehicle.getVehicleNumber());
        
        // Delegate to floors to find and park vehicle
        for (ParkingFloor floor : floors) {
            ParkingTicket ticket = floor.parkVehicle(vehicle, this);
            if (ticket != null) {
                System.out.println("ParkingLot: Vehicle " + vehicle.getVehicleNumber() + " parked successfully on floor " + floor.getFloorId());
                return ticket;
            }
        }
        
        System.out.println("ParkingLot: No available slot for vehicle " + vehicle.getVehicleNumber());
        return null;
    }
    
    public boolean unparkVehicle(ParkingTicket ticket) {
        System.out.println("ParkingLot: Processing vehicle exit for ticket " + ticket.getTicketId());
        
        // Find the floor that contains this slot and delegate unpark operation
        for (ParkingFloor floor : floors) {
            if (floor.unparkVehicle(ticket)) {
                ticket.setExitTime(new java.sql.Timestamp(System.currentTimeMillis()));
                System.out.println("ParkingLot: Vehicle " + ticket.getVehicle().getVehicleNumber() + " exited successfully");
                return true;
            }
        }
        
        System.out.println("ParkingLot: Failed to unpark vehicle for ticket " + ticket.getTicketId());
        return false;
    }
}
