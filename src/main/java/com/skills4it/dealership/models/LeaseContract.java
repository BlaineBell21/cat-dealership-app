package com.skills4it.dealership.models;

//Expected Ending Value (50% of the original price)
//Lease Fee (7% of the original price)
//Monthly payment based on
//  All leases are financed at 4.0% for 36 months


public class LeaseContract extends Contract{


    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    public double getTotalPrice(Vehicle vehicle) {

    }

    @Override
    public double getMonthlyPayment(Vehicle vehicle) {

    }
}
