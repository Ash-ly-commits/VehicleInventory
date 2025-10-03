package com.pluralsight;
import java.util.*;

public class VehicleInventory {
    // Members of the class
    private static final Scanner scanner = new Scanner(System.in); // Scanner for user input
    private static int carCount = 6; // Keeps track of Vehicles logged in array
    private static final Vehicle[] car = new Vehicle[20]; // Creates Vehicle array with 20 spots

    public static void main(String[] args) {
        // Preloading the array with 6 vehicles
        car[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00f);
        car[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00f);
        car[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00f);
        car[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00f);
        car[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500.00f);
        car[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00f);

        // Creating a loop with a menu within
        int command = 0;
        while(!(command == 6)) {
            System.out.print("What do you want to do?\n\t1 - List all vehicles\n\t2 - Search by make/model" +
                    "\n\t3 - Search by price range\n\t4 - Search by color\n\t5 - Add a vehicle\n\t6 - Quit" +
                    "\nEnter your command: "); // Menu displayed to user
            command = scanner.nextInt(); // Saves their response
            switch (command) { // Uses saved response to pick a case
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
                    System.out.println("Exiting...");
                    break;
            }
        }
    }

    // Loop that lists all vehicles and their details in a specific format
    public static void listAllVehicles () {
        int counter = 0;
        System.out.println("\nAll vehicles: ");
        while (counter < carCount) { // Condition ensures it's not displaying a Vehicle with empty members
            System.out.printf("\tVehicle %d: ID %d, %s, %s, Odometer: %d, Price: %.2f\n",
                    counter+1,car[counter].getVehicleId(),car[counter].getMakeModel(), car[counter].getColor(),
                    car[counter].getOdometerReading(), car[counter].getPrice());
            counter++;
        }
    }

    /* Takes in price range from user and then uses loop to checks every object in array for prices within
    user's range */
    public static void findVehiclesByPrice () {
        System.out.print("Enter minimum price for vehicle: ");
        float min = scanner.nextFloat();
        System.out.print("Enter maximum price for vehicle: ");
        float max = scanner.nextFloat();
        System.out.println("Vehicles in your price range: ");
        for (int i=0;i<carCount;i++){ // Loop that goes through every vehicle saved
            if ((car[i].getPrice() >= min) && (car[i].getPrice() <= max)){ // Checks vehicle price is in range
                System.out.printf("Vehicle ID %d, %s, %s, Odometer: %d, Price: %.2f\n",
                        car[i].getVehicleId(), car[i].getMakeModel(), car[i].getColor(),
                        car[i].getOdometerReading(), car[i].getPrice());
            }
        }
    }

    // Adds new Vehicle object, sets object members to user's choice, and increases vehicle count
    public static void addAVehicle(){
        car[carCount] = new Vehicle(); // New vehicle object to store user's input
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
        carCount++; // Keeps track of new vehicle being added to the array
    }
}