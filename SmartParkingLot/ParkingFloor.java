package com.LLD.SmartParkingLot;

import java.util.Map;

public class ParkingFloor {
    private long floorId;
    private Map<String, ParkingSlot> slot;
    private boolean isMaintance;

    public ParkingFloor(long floorId, Map<String, ParkingSlot> slot) {
        this.floorId = floorId;
        this.slot = slot;
        this.isMaintance = false;
    }

    public long getFloorId() {
        return floorId;
    }

    public void setFloorId(long floorId) {
        this.floorId = floorId;
    }

    public ParkingSlot getSlot(String slotId) {
        return this.slot.get(slotId);
    }

    public void addParkingSlot(ParkingSlot slot) {
        this.slot.put(String.valueOf(slot.getSlotId()), slot);
    }

    public Map<String, ParkingSlot> getSlots() {
        return this.slot;
    }

    public boolean isSlotAvailable(Vehicle vehicle) {
        for (ParkingSlot slot : this.slot.values()) {
            if (slot.canFit(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFloorFull() {
        for (ParkingSlot slot : this.slot.values()) {
            if (!slot.isOccupied()) {
                System.out.println("Slots are not full in Floor" + floorId);
                return false;
            }
        }
        System.out.println("Slots are full in Floor" + floorId);
        return true;
    }

    public void isMaintance() {
        this.isMaintance = true;
    }

    public ParkingTicket parkVehicle(Vehicle vehicle, ParkingLot parkingLot) {
        if (isMaintance) {
            System.out.println("Floor " + floorId + " is under maintenance");
            return null;
        }

        for (ParkingSlot slot : this.slot.values()) {
            if (slot.canFit(vehicle)) {
                slot.parkVehicle(vehicle);

                ParkingTicket ticket = new ParkingTicket(vehicle, slot, parkingLot,
                        new java.sql.Timestamp(System.currentTimeMillis()));
                System.out.println("Floor " + floorId + ": Vehicle parked at slot " + slot.getSlotId());
                return ticket;
            }
        }
        return null;
    }

    public boolean unparkVehicle(ParkingTicket ticket) {
        ParkingSlot ticketSlot = ticket.getParkingSlot();

        // Check if this slot belongs to this floor
        for (ParkingSlot slot : this.slot.values()) {
            if (slot.getSlotId() == ticketSlot.getSlotId()) {
                slot.unParkVehicle();
                System.out.println("Floor " + floorId + ": Vehicle unparked from slot " + slot.getSlotId());
                return true;
            }
        }
        return false;
    }

}
