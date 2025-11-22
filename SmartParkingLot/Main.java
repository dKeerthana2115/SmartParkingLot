package com.LLD.SmartParkingLot;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        AllocationStrategy strategy = new NearestFirstStrategy();

        ParkingLot parkingLot = new ParkingLot(1, strategy);

        Map<String, ParkingSlot> floor1Slots = new HashMap<>();
        ParkingSlot slot1 = new ParkingSlot(101, null, "CAR");
        ParkingSlot slot2 = new ParkingSlot(102, null, "CAR");
        ParkingSlot slot3 = new ParkingSlot(103, null, "BIKE");

        floor1Slots.put("101", slot1);
        floor1Slots.put("102", slot2);
        floor1Slots.put("103", slot3);

        ParkingFloor floor1 = new ParkingFloor(1, floor1Slots);
        parkingLot.addFloor(floor1);

        Map<String, ParkingSlot> floor2Slots = new HashMap<>();
        ParkingSlot slot4 = new ParkingSlot(201, null, "TRUCK");
        ParkingSlot slot5 = new ParkingSlot(202, null, "CAR");

        floor2Slots.put("201", slot4);
        floor2Slots.put("202", slot5);

        ParkingFloor floor2 = new ParkingFloor(2, floor2Slots);
        parkingLot.addFloor(floor2);

        EntryPanel entryPanel = new EntryPanel("ENTRY_01", parkingLot);
        ExitPanel exitPanel = new ExitPanel("EXIT_01", parkingLot);

        Vehicle car1 = new Vehicle("ABC123", VehicleType.CAR);
        Vehicle bike1 = new Vehicle("XYZ789", VehicleType.BIKE);
        Vehicle truck1 = new Vehicle("TRK456", VehicleType.TRUCK);
        Vehicle car2 = new Vehicle("DEF456", VehicleType.CAR);

        System.out.println("=== Vehicle Entry Process ===\n");

        ParkingTicket ticket1 = entryPanel.processVehicleEntry(car1);
        System.out.println();

        ParkingTicket ticket2 = entryPanel.processVehicleEntry(bike1);
        System.out.println();

        ParkingTicket ticket3 = entryPanel.processVehicleEntry(truck1);
        System.out.println();

        ParkingTicket ticket4 = entryPanel.processVehicleEntry(car2);
        System.out.println();

        Vehicle car3 = new Vehicle("GHI789", VehicleType.CAR);
        ParkingTicket ticket5 = entryPanel.processVehicleEntry(car3);
        System.out.println();

        if (ticket1 != null) {
            System.out.println("Processing exit for Car1:");
            boolean exitSuccess = exitPanel.processVehicleExit(ticket1);
            System.out.println("Exit successful: " + exitSuccess);
            System.out.println();
        }

        if (ticket2 != null) {
            System.out.println("Processing exit for Bike1:");
            boolean exitSuccess = exitPanel.processVehicleExit(ticket2);
            System.out.println("Exit successful: " + exitSuccess);
            System.out.println();
        }

    }
}