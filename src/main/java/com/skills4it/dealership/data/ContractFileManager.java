package com.skills4it.dealership.data;

import com.skills4it.dealership.models.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static com.skills4it.dealership.ui.Helpers.*;

public class ContractFileManager {
    private static final Path INVENTORY_PATH = Path.of("src", "main", "resources", "contracts.csv");
    private static Dealership dealership;
    private static SalesContract salesContract;

    public static void vehicleSellAndLeaseService(String option) {
        boolean isDone = false;

        while (!isDone) {
            String name = readString("Enter in your name: ");

            String email = readString("Enter in your email: ");

            int vin = readInt("Enter in the vin of your preferred vehicle: ");
            Vehicle foundVehicle = dealership.getVehiclesByVin(vin);

            if (foundVehicle != null && option.equals("sell")){
                boolean isFincanced = readBoolean("Would you like to finance your vehicle? Enter yes/no: ");
                salesContract.getTotalPrice(foundVehicle);

                LeaseContract salesContract = new SalesContract(printDate(), name, email,foundVehicle , ,"");
            } else if (vehicleByVin != null && option.equals("lease")) {
                LeaseContract leaseContract = new SalesContract(printDate(), name, email, foundVehicle, "","");
            }

        }
    }
    public static void saveContract(Contract contract){
        SalesContract salesContract = contract instanceof SalesContract ? ((SalesContract) contract) : null;
        if (salesContract != null){

        }

        try (BufferedWriter writer = Files.newBufferedWriter(INVENTORY_PATH)) {
            writer.write(dealership.toCsvHeaderLine());
            writer.newLine();

            List<Vehicle> vehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.toCsvLine());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Could not save inventory file: " + INVENTORY_PATH, e);
        }

    }
    public String saleWriteFormat() {
        return String.join("|", contractType, printDate(),customerName, costumerEmail,
                vin,year,make,model,vehicleType,
                color,vehiclePrice,salesTax,recordingFee,
                totalPrice,financeOption,monthlyPayment);
    }
    public String leaseWriteFormat() {
        return String.join("|", contractType, printDate(),customerName, costumerEmail,
                vin,year,make,model,vehicleType,color,vehiclePrice,
                expectedEndValue, leaseFee,totalPrice,financeOption,monthlyPayment);
    }

}
