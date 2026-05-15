package com.skills4it.dealership.models;

//Sales Tax Amount (5%)
//Recording Fee ($100)
//Processing fee ($295 for vehicles under $10,000 and $495 for all others
//Whether they want to finance (yes/no)
//Monthly payment (if financed) based on:



public class SalesContract extends Contract{
    private boolean isFinanced;


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, double totalPrice, double monthlyPayment, boolean isFinancned) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
        this.isFinanced = isFinancned;
    }

    public void isFinancing(boolean financeOption){
        isFinanced = financeOption;
    }

    //All loans are at 4.25% for 48 months if the price is $10,000 or more
    //Otherwise they are at 5.25% for 24 month
    @Override
    public double getTotalPrice(Vehicle vehicle) {
        double salesTax = .05;
        double recordingFee = 100;
        double totalPrice = vehicle.getPrice();

        if (vehicle.getPrice() < 10000){
            totalPrice += 295;

        }
        totalPrice += 495 + recordingFee;
        if ()

        return totalPrice;
    }

    @Override
    public double getMonthlyPayment(Vehicle vehicle) {

    }
}
