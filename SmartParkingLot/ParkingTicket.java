package com.LLD.SmartParkingLot;

import java.sql.Timestamp;

public class ParkingTicket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot; // Keep for reference but don't expose publicly
    private ParkingLot parkingLot;
    private long slotId;
    private Timestamp entryTime;
    private Timestamp exitTime;
    private double parkingFee;
    private boolean isPaid;

    public ParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot, ParkingLot parkingLot, Timestamp entryTime) {
        this.ticketId = generateTicketId();
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot; // Internal reference
        this.parkingLot = parkingLot;
        this.slotId = parkingSlot.getSlotId();
        this.entryTime = entryTime;
        this.exitTime = null;
        this.parkingFee = 0.0;
        this.isPaid = false;
        System.out.println("Parking ticket generated: " + ticketId);
    }

    private String generateTicketId() {
        return "TICKET_" + System.currentTimeMillis();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot; // Keep for internal use
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public long getSlotId() {
        return slotId;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public Timestamp getExitTime() {
        return exitTime;
    }

    public void setExitTime(Timestamp exitTime) {
        this.exitTime = exitTime;
    }

    public double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(double parkingFee) {
        this.parkingFee = parkingFee;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        this.isPaid = true;
        System.out.println("Ticket " + ticketId + " marked as paid. Amount: $" + parkingFee);
    }

    public long getParkingDurationInMinutes() {
        if (exitTime == null) {
            return (System.currentTimeMillis() - entryTime.getTime()) / (1000 * 60);
        }
        return (exitTime.getTime() - entryTime.getTime()) / (1000 * 60);
    }
}