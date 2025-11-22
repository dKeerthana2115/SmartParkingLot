package com.LLD.SmartParkingLot;

public class ExitPanel {
    private ParkingLot parkingLot;
    private String panelId;
    private ParkingFeeCalculator feeCalculator;

    public ExitPanel(String panelId, ParkingLot parkingLot) {
        this.panelId = panelId;
        this.parkingLot = parkingLot;
        this.feeCalculator = new ParkingFeeCalculator();
    }

    public boolean processVehicleExit(ParkingTicket ticket) {

        // Calculate parking fee using dedicated calculator
        long durationMinutes = ticket.getParkingDurationInMinutes();
        double fee = feeCalculator.calculateParkingFee(durationMinutes, ticket.getVehicle().getVehicleType());
        ticket.setParkingFee(fee);

        // Process payment
        if (processPayment(ticket)) {
            // Unpark vehicle using ParkingLot
            return parkingLot.unparkVehicle(ticket);
        }

        System.out.println("Payment failed for ticket: " + ticket.getTicketId());
        return false;
    }

    private boolean processPayment(ParkingTicket ticket) {
        System.out.println("Processing payment of $" + ticket.getParkingFee());
        ticket.markAsPaid();
        return true;
    }

    public String getPanelId() {
        return panelId;
    }
}