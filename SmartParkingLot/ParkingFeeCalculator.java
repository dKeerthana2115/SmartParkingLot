package com.LLD.SmartParkingLot;

public class ParkingFeeCalculator {
    
    public double calculateParkingFee(long minutes, VehicleType vehicleType) {
        System.out.println("Calculating parking fee for " + vehicleType + " - Duration: " + minutes + " minutes");
        
        double hourlyRate = getHourlyRate(vehicleType);
        double hours = Math.ceil(minutes / 60.0);
        double totalFee = hours * hourlyRate;
        
        System.out.println("Hourly rate: $" + hourlyRate + ", Hours: " + hours + ", Total fee: $" + totalFee);
        return totalFee;
    }
    
    private double getHourlyRate(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR: return 5.0;
            case BIKE: return 2.0;
            case TRUCK: return 10.0;
            default: return 5.0;
        }
    }
    
    public double calculateDiscountedFee(long minutes, VehicleType vehicleType, double discountPercentage) {
        double originalFee = calculateParkingFee(minutes, vehicleType);
        double discount = originalFee * (discountPercentage / 100);
        double finalFee = originalFee - discount;
        
        System.out.println("Original fee: $" + originalFee + ", Discount: $" + discount + ", Final fee: $" + finalFee);
        return finalFee;
    }
}