package com.skills4it.dealership.models;

//Expected Ending Value (50% of the original price)
//Lease Fee (7% of the original price)
/*
CONTRACT_TYPE|DATE|CUSTOMER_NAME|CUSTOMER_EMAIL|VIN|YEAR|MAKE|MODEL|VEHICLE_TYPE|COLOR|ODOMETER|
VEHICLE_PRICE|EXPECTED_ENDING_VALUE|LEASE_FEE|TOTAL_PRICE|MONTHLY_PAYMENT
 */


public class LeaseContract extends Contract{

    private static final double  LEASE_FEE = .07;
    private static final double MONTHLY_FINANCE_FEE = .04;
    private static final double EXPECTED_ENDING_PRICE_FEE = .50;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public double getTotalPrice() {
       return basePriceOfVehicle() +expectedEndingValue() + leaseFee();
    }

    public double expectedEndingValue(){
        return basePriceOfVehicle() * EXPECTED_ENDING_PRICE_FEE;
    }

    public double basePriceOfVehicle(){
        return getVehicleSold().getPrice();
    }

    public double leaseFee(){
        return getVehicleSold().getPrice() * LEASE_FEE;
    }

    @Override
    public double getMonthlyPayment() {
       return getTotalPrice() * MONTHLY_FINANCE_FEE;
    }
    @Override
    public String toString() {

        Vehicle v = getVehicleSold();


        return String.format(
                "LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f",

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

                expectedEndingValue(),
                leaseFee(),
                getTotalPrice(),

                getMonthlyPayment()
        );
    }
}
