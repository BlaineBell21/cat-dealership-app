package com.skills4it.dealership.models;

//Sales Tax Amount (5%)
//Recording Fee ($100)
//Processing fee ($295 for vehicles under $10,000 and $495 for all others


import java.util.List;

public class SalesContract extends Contract{
    private boolean isFinanced;
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_10000_OR_MORE = 495.00;
    private static final double PRICE_IS_10000_OR_MORE = .0425;
    private static final double PRICE_IS_UNDER_10000 = .0525;
    private static double processingFee = 0;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold, isFinanced);
        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
        double salesTax = 0;
        double totalPrice = getVehicleSold().getPrice();

        salesTax = totalPrice * SALES_TAX_RATE;

        processingFee = (totalPrice < 10000) ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_10000_OR_MORE;

        return totalPrice + salesTax + RECORDING_FEE + processingFee;
    }
    //All loans are at 4.25% for 48 months if the price is $10,000 or more
    //Otherwise they are at 5.25% for 24 month
    //Whether they want to finance (yes/no)
    //Monthly payment (if financed) based on:

    @Override
    public double getMonthlyPayment() {

        double basePriceOfVehicle = getVehicleSold().getPrice();
        double totalPrice = 0;

        if (isFinanced && basePriceOfVehicle >= 10000){
            return totalPrice * PRICE_IS_10000_OR_MORE;
        } else if(isFinanced && totalPrice < 10000){
            return totalPrice * PRICE_IS_UNDER_10000;
        }
        return 0;
    }
    @Override
    public String toString() {

        Vehicle v = getVehicleSold();

        return String.format(
                "SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",

                getDate(),
                getCustomerName(),
                getCustomerEmail(),

                v.getVin(),
                v.getYear(),
                v.getMake(),
                v.getModel(),
                v.getVehicleType(),
                v.getColor(),
                v.getOdometer(),
                v.getPrice(),

                SALES_TAX_RATE,
                RECORDING_FEE,
                PROCESSING_FEE,
                getTotalPrice(),

                isFinanced() ? "YES" : "NO",

                getMonthlyPayment()
        );
    }
}
