# SmartParkingLot
A comprehensive Low-Level Design (LLD) implementation of a Smart Parking Lot Management System in Java.

## Overview

This system manages vehicle parking operations including entry, exit, slot allocation, fee calculation, and real-time availability tracking across multiple floors and vehicle types.

## System Architecture

### Core Components
ParkingLot
├── ParkingFloor (Multiple floors)
│   └── ParkingSlot (Multiple slots per floor)
├── EntryPanel (Vehicle entry processing)
├── ExitPanel (Vehicle exit & payment)
├── AllocationStrategy (Slot allocation logic)
└── ParkingFeeCalculator (Cost computation)

## 📁 Project Structure

src/main/java/com/LLD/SmartParkingLot/
├── ParkingLot.java              # Main parking lot class
├── ParkingFloor.java            # Floor management
├── ParkingSlot.java             # Individual slot
├── Vehicle.java                 # Vehicle entity
├── VehicleType.java             # Vehicle type enum
├── ParkingTicket.java           # Ticket management
├── EntryPanel.java              # Entry processing
├── ExitPanel.java               # Exit processing
├── AllocationStrategy.java      # Strategy interface
├── NearestFirstStrategy.java    # Concrete strategy
├── ParkingFeeCalculator.java    # Fee calculation
└── Main.java                    # Demo application
```

