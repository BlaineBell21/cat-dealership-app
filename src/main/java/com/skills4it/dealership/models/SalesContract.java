package com.skills4it.dealership.models;

//Sales Tax Amount (5%)
//Recording Fee ($100)
//Processing fee ($295 for vehicles under $10,000 and $495 for all others
//Whether they want to finance (yes/no)
//Monthly payment (if financed) based on:
//All loans are at 4.25% for 48 months if the price is $10,000 or more
//Otherwise they are at 5.25% for 24 month


public class SalesContract extends Contract{

    public SalesContract(String date, String customerName, String customerEmail, String vehicleSold, double totalPrice, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicleSold, totalPrice, monthlyPayment);
    }

    @Override
    void getTotalPrice() {

    }


    @Override
    void getMonthlyPayment() {

    }
}
