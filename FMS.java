package Lab_5;

import java.util.ArrayList;

class Driver {
    //Objects
    private String driverID;
    private String name;
    private String licenseType;

    // Constructor
    Driver(String driverID, String name, String licenseType) {
        this.driverID = driverID;
        this.name = name;
        this.licenseType = licenseType;
    }

    //Method
    void displayDriverDetails() {
        System.out.println("Driver ID: " + driverID);
        System.out.println("Name: " + name);
        System.out.println("License Type: " + licenseType);
    }
}

class Vehicle {
    //Objects
    private String vehicleID;
    private String vehicleType;
    private String registrationNumber;
    private Driver driver;  // Composition
    private static int totalVehicles = 0;

    // Constructor
    Vehicle(String vehicleID, String vehicleType, String registrationNumber, Driver driver) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.driver = driver;
        totalVehicles++;
    }

    //Methods
    void displayVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleID);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Driver Details:");
        driver.displayDriverDetails();
    }

    String getVehicleID() {
        return vehicleID;
    }

    static int getTotalVehicles() {
        return totalVehicles;
    }
}

class Fleet {
    //Object
    private ArrayList<Vehicle> vehicles;

    //Constructor
    Fleet() {
        vehicles = new ArrayList<>();
    }

    //Methods
    void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        System.out.println("Vehicle added to fleet.");
    }

    void removeVehicle(String vehicleID) {
        boolean removed = false;

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getVehicleID().equals(vehicleID)) {
                vehicles.remove(i);
                removed = true;
                System.out.println("Vehicle removed from fleet.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Vehicle not found.");
        }
    }

    void displayFleetDetails() {
        if (vehicles.isEmpty()) {
            System.out.println("Fleet is empty.");
            return;
        }

        System.out.println("\nFleet Details:");
        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();
        }

        System.out.println("\nTotal Vehicles Created: " + Vehicle.getTotalVehicles());
    }
}


public class FleetManagementSystem {
    public static void main(String[] args) {

        Driver d1 = new Driver("P1", "Lewis Hamilton", "F1");
        Driver d2 = new Driver("P2", "Keanu Reaves", "P1");
        Driver d3 = new Driver("P3", "Akshat", "N/A");

        Vehicle v1 = new Vehicle("Ferrari", "F1", "N/A", d1);
        Vehicle v2 = new Vehicle("BMV", "BMW M4", "JW", d2);
        Vehicle v3 = new Vehicle("Jesko Absolute", "Koenigsegg", "OUTTA MY WAY", d3);

        Fleet fleet = new Fleet();

        fleet.addVehicle(v1);
        fleet.addVehicle(v2);
        fleet.addVehicle(v3);

        fleet.removeVehicle("BMV");

        fleet.displayFleetDetails();
    }
}
