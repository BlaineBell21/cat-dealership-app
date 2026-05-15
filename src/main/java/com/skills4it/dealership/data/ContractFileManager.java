package com.skills4it.dealership.data;

import com.skills4it.dealership.models.*;
import com.skills4it.dealership.ui.UserInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import static com.skills4it.dealership.ui.Helpers.*;

public class ContractFileManager {
    private static final Path CONTRACT_PATH = Path.of("src", "main", "resources", "contracts.csv");
    private static SalesContract salesContract;


    public static void createSalesContract(String name, String email, Vehicle foundVehicle){
        boolean isFinancing = readBoolean("Would you like to finance your vehicle? Enter yes/no: ");

        SalesContract salesContract = new SalesContract(
                printDate(),
                name,
                email,
                foundVehicle,
                isFinancing);
        System.out.println("created contract");
        saveContract(salesContract);
    }

    public static void leaseContract(String name, String email, int vin, Vehicle foundVehicle){

    }

    public static void saveContract(Contract contract) {
        System.out.println("made it to saving");
        try {
            FileWriter fileWriter = new FileWriter("contracts.csv", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(contract.toString());

            printWriter.close();
            System.out.println("contract saved");
        } catch (IOException e) {
            throw new IllegalStateException("Error saving contract to: " + CONTRACT_PATH, e);
        }
    }
}
