package com.skills4it.dealership.models;

//Expected Ending Value (50% of the original price)
//Lease Fee (7% of the original price)
//Monthly payment based on
//  All leases are financed at 4.0% for 36 months


public class LeaseContract extends Contract{

    private boolean isFinanced;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold, isFinanced);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }
    @Override
    public String toString(){
        return null;
    }
}
