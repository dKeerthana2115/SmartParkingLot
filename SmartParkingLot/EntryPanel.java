package com.LLD.SmartParkingLot;

public class EntryPanel {
    private ParkingLot parkingLot;
    private String panelId;

    public EntryPanel(String panelId, ParkingLot parkingLot) {
        this.panelId = panelId;
        this.parkingLot = parkingLot;
    }

    public ParkingTicket processVehicleEntry(Vehicle vehicle) {
        System.out.println("EntryPanel [" + panelId + "]: Processing entry for vehicle " + vehicle.getVehicleNumber());

        // Delegate to ParkingLot's higher-level method
        ParkingTicket ticket = parkingLot.parkVehicle(vehicle);

        if (ticket != null) {
            System.out.println(
                    "EntryPanel [" + panelId + "]: Entry successful, ticket generated: " + ticket.getTicketId());
        } else {
            System.out.println("EntryPanel [" + panelId + "]: Entry failed - no available slots");
        }

        return ticket;
    }

    public String getPanelId() {
        return panelId;
    }
}
