package com.skills4it.dealership.models;

public class SalesContract extends Contract{
    private final boolean isFinanced;
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.00;
    private static final double PROCESSING_FEE_UNDER_10000 = 295.00;
    private static final double PROCESSING_FEE_10000_OR_MORE = 495.00;
    private static final double PRICE_IS_10000_OR_MORE = .0425;
    private static final double PRICE_IS_UNDER_10000 = .0525;
    private double processingFee = 0; //storing processing fee with local variable causing printing issue


    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicleSold);
        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
        return basePriceOfVehicle() + salesTax() + RECORDING_FEE + processingFee();
    }

    public double basePriceOfVehicle(){
        return getVehicleSold().getPrice();
    }

    public double salesTax(){
        return getVehicleSold().getPrice() * SALES_TAX_RATE;
    }

//    public double processingFee(){ //method that fixed issue with printing the processing fee to CSV file
//        return (getVehicleSold().getPrice() < 10000) ? PROCESSING_FEE_UNDER_10000 : PROCESSING_FEE_10000_OR_MORE;
//    }
    public double processingFee(){ //method that causes processing fee to not properly print to CSV file
        if (getVehicleSold().getPrice() < 10000){
            return processingFee = 295;
        } else if(getVehicleSold().getPrice() >= 10000){
            return processingFee = 495;
        }
        return 0;
}

    @Override
    public double getMonthlyPayment() {

        double totalPrice = 0;

        if (isFinanced && basePriceOfVehicle() >= 10000){
            totalPrice = basePriceOfVehicle() * PRICE_IS_10000_OR_MORE;
            return totalPrice;
        } else if(isFinanced){
            totalPrice = basePriceOfVehicle() * PRICE_IS_UNDER_10000;
            return totalPrice;
        }
        return totalPrice;
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
                processingFee,
                getTotalPrice(),

                isFinanced() ? "YES" : "NO",

                getMonthlyPayment()
        );
    }
}
