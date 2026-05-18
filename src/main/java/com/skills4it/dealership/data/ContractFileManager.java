package com.skills4it.dealership.data;

import com.skills4it.dealership.models.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import static com.skills4it.dealership.ui.Helpers.*;

public class ContractFileManager {
    private static final Path CONTRACT_PATH = Path.of("src/contracts.csv");

    public static void createSalesContract(String name, String email, Vehicle foundVehicle){
        boolean isFinancing = readBoolean("Would you like to finance your vehicle? Enter yes/no: ");
        SalesContract newSalesContract = new SalesContract(
                printDate(),
                name,
                email,
                foundVehicle,
                isFinancing);
        saveSalesContract(newSalesContract);
    }

    public static void leaseContract(String name, String email, Vehicle foundVehicle){
        LeaseContract newLeaseContract = new LeaseContract(
                printDate(),
                name,
                email,
                foundVehicle);
        saveLeaseContract(newLeaseContract);
    }

    public static void saveLeaseContract(LeaseContract contract) {
        try (FileWriter fileWriter = new FileWriter(CONTRACT_PATH.toFile(), true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println(contract);

            //printWriter.close();
            Thread.sleep(1000);
            System.out.println("New contract saved.");
        } catch (IOException e) {
            throw new IllegalStateException("Error saving contract to: " + CONTRACT_PATH, e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveSalesContract(SalesContract contract) {
        try (FileWriter fileWriter = new FileWriter(CONTRACT_PATH.toFile(), true);
             PrintWriter bufferedWriter = new PrintWriter(fileWriter)) {


            bufferedWriter.println(contract);


            //printWriter.close();

            System.out.println("New contract saved.");
        } catch (IOException e) {
            throw new IllegalStateException("Error saving contract to: " + CONTRACT_PATH, e);
        }
    }
}
