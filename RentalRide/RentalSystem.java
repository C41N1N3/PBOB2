import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        setupInitialData(vehicleList);
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n   Vehicle Rental Management System   ");
            System.out.println("========================================");
            System.out.println("1. View Vehicle List");
            System.out.println("2. View Active Rentals");
            System.out.println("3. Add New Rental");
            System.out.println("4. Add New Vehicle to Fleet");
            System.out.print("Enter your choice (1-4, or 0 to exit): ");
            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        displayAllVehicles(vehicleList);
                        break;
                    case 2:
                        displayActiveRentals(vehicleList);
                        break;
                    case 3:
                        addRental(vehicleList, scanner);
                        break;
                    case 4:
                        addNewVehicle(vehicleList, scanner);
                        break;
                    case 0:
                        System.out.println("Thank you. Exiting application.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;            }
        }
        scanner.close();
    }

    private static void displayAllVehicles(ArrayList<Vehicle> list) {
        System.out.println("\n=== Vehicle List ===");
        for (int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);
            System.out.println("--- Vehicle Index [" + i + "] ---");
            v.displayInfo();
            if (v.isRented()) {
                System.out.println("Renter: " + v.getRenter().getName());
                System.out.println("Contact: " + v.getRenter().getContact());
            } else {
                System.out.println("Renter: - (Available)");
                System.out.println("Contact: -");
            }
            System.out.println();
        }
    }

    private static void displayActiveRentals(ArrayList<Vehicle> list) {
        System.out.println("\n=== Active Rentals List ===");
        boolean foundActiveRental = false;
        for (Vehicle v : list) {
            if (v.isRented()) {
                v.getRenter().displayInfo();
                foundActiveRental = true;
            }
        }
        if (!foundActiveRental) {
            System.out.println("No active rentals at this time.");
        }
    }

    private static void addRental(ArrayList<Vehicle> list, Scanner scanner) {
        System.out.println("\n--- Add New Rental ---");
        for (int i = 0; i < list.size(); i++) {
            Vehicle v = list.get(i);
            String status = v.isRented() ? "(Rented)" : "(AVAILABLE)";
            System.out.printf("[%d] %s %s %s\n", i, v.getBrand(), v.getModel(), status);
        }
        try {
            System.out.print("Enter the index of the vehicle to rent: ");
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index >= list.size()) {
                System.out.println("Invalid index. Returning to main menu.");
                return;
            }
            Vehicle v = list.get(index);
            if (v.isRented()) {
                System.out.println("Sorry, this vehicle is already rented by " + v.getRenter().getName() + ".");
            } else {
                System.out.print("Enter Renter's Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Contact (Phone No.): ");
                String contact = scanner.nextLine();
                System.out.print("Enter Due Date (dd-mm-yyyy): ");
                String dueDate = scanner.nextLine();
                v.setRenter(new Renter(name, contact, dueDate, v));
                System.out.println("SUCCESS! " + v.getBrand() + " " + v.getModel() + " has been rented by " + name + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for the index.");
        }
    }

    private static void addNewVehicle(ArrayList<Vehicle> list, Scanner scanner) {
        System.out.println("\n--- Add New Vehicle to Fleet ---");
        System.out.println("Select vehicle type:");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Bicycle");
        System.out.print("Enter choice: ");
        try {
            int typeChoice = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter Model: ");
            String model = scanner.nextLine();
            System.out.print("Enter Production Year: ");
            int year = Integer.parseInt(scanner.nextLine());
            switch (typeChoice) {
                case 1:
                    System.out.print("Enter Wheel Count: ");
                    int carWheels = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Color: ");
                    String carColor = scanner.nextLine();
                    System.out.print("Enter License Plate: ");
                    String carPlate = scanner.nextLine();
                    list.add(new Car(brand, model, year, carWheels, carColor, carPlate));
                    System.out.println("SUCCESS! New Car added to the fleet.");
                    break;
                case 2:
                    System.out.print("Enter Wheel Count: ");
                    int bikeWheels = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Color: ");
                    String bikeColor = scanner.nextLine();
                    System.out.print("Enter License Plate: ");
                    String bikePlate = scanner.nextLine();
                    list.add(new Motorcycle(brand, model, year, bikeWheels, bikeColor, bikePlate));
                    System.out.println("SUCCESS! New Motorcycle added to the fleet.");
                    break;
                case 3:
                    System.out.print("Enter Bicycle Type (e.g., Road, Mountain): ");
                    String bicycleType = scanner.nextLine();
                    System.out.print("Enter Color: ");
                    String bicycleColor = scanner.nextLine();
                    list.add(new Bicycle(brand, model, year, bicycleType, bicycleColor));
                    System.out.println("SUCCESS! New Bicycle added to the fleet.");
                    break;
                default:
                    System.out.println("Invalid vehicle type. Vehicle not added.");
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number for year or wheel count.");
        }
    }

    private static void setupInitialData(ArrayList<Vehicle> vehicleList) {
        vehicleList.add(new Car("Toyota", "Avanza", 2023, 4, "White", "L 1234 XY"));
        vehicleList.add(new Car("Daihatsu", "Xenia", 2022, 4, "Black", "W 5678 ZA"));
        vehicleList.add(new Car("Suzuki", "Ertiga", 2023, 4, "Grey", "S 9876 BC"));
        vehicleList.add(new Motorcycle("Vespa", "Sprint", 2023, 2, "Yellow", "L 4411 AG"));
        vehicleList.add(new Motorcycle("Suzuki", "GSX-R150", 2022, 2, "Blue", "M 2233 DE"));
        vehicleList.add(new Motorcycle("Honda", "PCX 160", 2023, 2, "White", "W 7777 KL"));
        vehicleList.add(new Bicycle("Polygon", "Siskiu D7", 2023, "Mountain", "Red"));
        vehicleList.add(new Bicycle("United", "Tricycle", 2022, "Kids", "Pink"));
        vehicleList.add(new Bicycle("Brompton", "C Line", 2024, "Folding", "Green"));
        vehicleList.get(1).setRenter(
                new Renter("Budi Santoso", "081222333444", "14-11-2025", vehicleList.get(1))
        );
        vehicleList.get(4).setRenter(
                new Renter("Citra Lestari", "085666777888", "15-11-2025", vehicleList.get(4))
        );
        vehicleList.get(6).setRenter(
                new Renter("Dewi Anggraini", "087777888999", "16-11-2025", vehicleList.get(6))
        );
    }
}

class Vehicle {
    protected String brand;
    protected String model;
    protected int productionYear;    
    private Renter renter;
    
    public Vehicle(String brand, String model, int productionYear) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.renter = null;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Production Year: " + productionYear);
    }
    
    public void setRenter(Renter renter) {
        this.renter = renter;
    }
    
    public Renter getRenter() {
        return renter;
    }
    
    public boolean isRented() {
        return renter != null;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public String getModel() {
        return model;
    }
}

class Car extends Vehicle {
    private int wheelCount;
    private String color;
    private String licensePlate;

    public Car(String brand, String model, int productionYear, int wheelCount, String color, String licensePlate) {
        super(brand, model, productionYear);
        this.wheelCount = wheelCount;
        this.color = color;
        this.licensePlate = licensePlate;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("Type: Car");
        super.displayInfo();
        System.out.println("Wheel Count: " + wheelCount);
        System.out.println("Color: " + color);
        System.out.println("License Plate: " + licensePlate);
    }
}

class Motorcycle extends Vehicle {
    private int wheelCount;
    private String color;
    private String licensePlate;
    
    public Motorcycle(String brand, String model, int productionYear, int wheelCount, String color, String licensePlate) {
        super(brand, model, productionYear);
        this.wheelCount = wheelCount;
        this.color = color;
        this.licensePlate = licensePlate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Motorcycle");
        super.displayInfo();
        System.out.println("Wheel Count: " + wheelCount);
        System.out.println("Color: " + color);
        System.out.println("License Plate: " + licensePlate);
    }
}

class Bicycle extends Vehicle {
    private String bicycleType;
    private String color;
    
    public Bicycle(String brand, String model, int productionYear, String bicycleType, String color) {
        super(brand, model, productionYear);
        this.bicycleType = bicycleType;
        this.color = color;
    }

    @Override
    public void displayInfo() {
        System.out.println("Type: Bicycle");
        super.displayInfo();
        System.out.println("Bicycle Type: " + bicycleType);
        System.out.println("Color: " + color);
    }
}

class Renter {
    private String name;
    private String contact;
    private String dueDate;
    private Vehicle rentedVehicle;
    
    public Renter(String name, String contact, String dueDate, Vehicle rentedVehicle) {
        this.name = name;
        this.contact = contact;
        this.dueDate = dueDate;
        this.rentedVehicle = rentedVehicle;
    }

    public void displayInfo() {
        System.out.println("Renter Name: " + name);
        if (rentedVehicle instanceof Car) {
            System.out.println("Vehicle Rented: Car");
        } else if (rentedVehicle instanceof Motorcycle) {
            System.out.println("Vehicle Rented: Motorcycle");
        } else if (rentedVehicle instanceof Bicycle) {
            System.out.println("Vehicle Rented: Bicycle");
        }
        System.out.println("Vehicle: " + rentedVehicle.getBrand() + " " + rentedVehicle.getModel());
        System.out.println("Due Date: " + dueDate);
        System.out.println();
    }
    
    public String getName() {
        return name;
    }
    
    public String getContact() {
        return contact;
    }
}
