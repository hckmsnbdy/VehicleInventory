package com.pluralsight;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20];
        int numberOfvehicle = 0;

        vehicles[0] = new Vehicle(101121L, "Ford Explorer", 45000, "Red",    13500f);
        vehicles[1] = new Vehicle(101122L, "Toyota Camry",   60000, "Blue",   11000f);
        vehicles[2] = new Vehicle(101123L, "Chevrolet Malibu", 50000, "Black",  9700f);
        vehicles[3] = new Vehicle(101124L, "Honda Civic",     70000, "White",   7500f);
        vehicles[4] = new Vehicle(101125L, "Subaru Outback",  55000, "Green",  14500f);
        vehicles[5] = new Vehicle(101126L, "Jeep Wrangler",   30000, "Yellow", 16000f);

        int numberOfVehicles = 6;

        Scanner scan = new Scanner(System.in);
        boolean programRunning = true;
       while (programRunning) {System.out.println("\nWhat do you want to do?");
           System.out.println("1 - List all vehicles");
           System.out.println("2 - Search by make/model");
           System.out.println("3 - Search by price range");
           System.out.println("4 - Search by color");
           System.out.println("5 - Add a vehicle");
           System.out.println("6 - Quit");
           System.out.print("Enter your command: ");

           int command = scan.nextInt();
           scan.nextLine();
           switch (command) {
               case 1:
                   listAllVehicles(vehicles, numberOfVehicles);
                   break;
               case 2:
                   searchByMakeModel(vehicles, numberOfVehicles, scan);
                   break;
               case 3:
                   searchByPriceRange(vehicles, numberOfVehicles, scan);
                   break;
               case 4:
                   searchByColor(vehicles, numberOfVehicles, scan);
                   break;
               case 5:
                   numberOfVehicles = addVehicle(vehicles, numberOfVehicles, scan);
                   break;
               case 6:
                   return;
           }
       }

    }

    public static void listAllVehicles(Vehicle[] vehicles, int count) {
        //
        for (int i = 0; i < count; i++) {
            System.out.println(vehicles[i]);
        }
    }

    public static int addVehicle(Vehicle[] vehicles, int count, Scanner scanner) {
        if (count >= vehicles.length) {
            System.out.println("Inventory is full!");
            return count;
        }

        System.out.print("Enter vehicle ID (long): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading (int): ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price (float): ");
        float price = scanner.nextFloat();
        scanner.nextLine();

        vehicles[count] = new Vehicle(id, makeModel, odometer, color, price);
        System.out.println("Vehicle added successfully.");
        return count + 1;
    }
    public static void searchByMakeModel(Vehicle[] vehicles, int count, Scanner scanner) {
        System.out.print("Enter make/model to search: ");
        String query = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < count; i++) {
            // Ignore Case
            if (vehicles[i].getMakeModel().equalsIgnoreCase(query)) {
                System.out.println(vehicles[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicle found with that make/model.");
        }
    }
    public static void searchByPriceRange(Vehicle[] vehicles, int count, Scanner scanner) {
        System.out.print("Enter MIN price: ");
        float min = scanner.nextFloat();

        System.out.print("Enter MAX price: ");
        float max = scanner.nextFloat();
        scanner.nextLine();


        if (min > max) {
            float temp = min;
            min = max;
            max = temp;
        }

        boolean found = false;
        for (int i = 0; i < count; i++) {
            float p = vehicles[i].getPrice();
            if (p >= min && p <= max) {
                System.out.println(vehicles[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicle found in that price range.");
        }
    }

    public static void searchByColor(Vehicle[] vehicles, int count, Scanner scanner) {
        System.out.print("Enter color to search: ");
        String colorQ = scanner.nextLine().trim();

        boolean found = false;
        for (int i = 0; i < count; i++) {

            if (vehicles[i].getColor().equalsIgnoreCase(colorQ)) {
                System.out.println(vehicles[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No vehicle found with that color.");
        }
    }

}
