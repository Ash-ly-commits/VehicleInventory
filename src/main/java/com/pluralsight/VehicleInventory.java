package com.pluralsight;
import java.util.*;

public class VehicleInventory {
    private static Scanner scanner = new Scanner(System.in);
    private static int carCount = 6;
    private static Vehicle[] car = new Vehicle[20];

    public static void main(String[] args) {
        car[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00f);
        car[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00f);
        car[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00f);
        car[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00f);
        car[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500.00f);
        car[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00f);

        System.out.println("What do you want to do?");
        System.out.println("\t1 - List all vehicles");
        System.out.println("\t2 - Search by make/model");
        System.out.println("\t3 - Search by price range");
        System.out.println("\t4 - Search by color");
        System.out.println("\t5 - Add a vehicle");
        System.out.println("\t6 - Quit");
        System.out.print("Enter your command: ");
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                listAllVehicles();
                break;
            case 3:
                findVehiclesByPrice();
                break;
            case 5:
                addAVehicle();
                break;
            case 6:
                return;
        }
    }
    public static void listAllVehicles () {
        int counter = 0;
        System.out.println("All vehicles: ");
        while (counter < carCount) {
            System.out.printf("\tVehicle %d: ID %d, %s, %s, Odometer: %d, Price: %.2f\n",
                    counter+1,car[counter].getVehicleId(),car[counter].getMakeModel(), car[counter].getColor(),
                    car[counter].getOdometerReading(), car[counter].getPrice());
            counter++;
        }
    }
    public static void findVehiclesByPrice () {
        System.out.print("Enter minimum price for vehicle: ");
        float min = scanner.nextFloat();
        System.out.print("Enter maximum price for vehicle: ");
        float max = scanner.nextFloat();
        System.out.println("Vehicles in your price range: ");
        for (int i=0;i<carCount;i++){
            if ((car[i].getPrice() > min) && (car[i].getPrice() < max)){
                System.out.printf("Vehicle ID %d, %s, %s, Odometer: %d, Price: %.2f\n",
                        car[i].getVehicleId(), car[i].getMakeModel(), car[i].getColor(),
                        car[i].getOdometerReading(), car[i].getPrice());
            }
        }
    }
    public static void addAVehicle(){
        car[carCount] = new Vehicle();
        System.out.print("\nEnter vehicle ID: ");
        car[carCount].setVehicleId(scanner.nextLong());
        scanner.nextLine();
        System.out.print("Enter vehicle make/model: ");
        car[carCount].setMakeModel(scanner.nextLine());
        System.out.print("Enter vehicle color: ");
        car[carCount].setColor(scanner.nextLine());
        System.out.print("Enter odometer reading: ");
        car[carCount].setOdometerReading(scanner.nextInt());
        System.out.print("Enter price: ");
        car[carCount].setPrice(scanner.nextFloat());
        carCount++;
    }
}