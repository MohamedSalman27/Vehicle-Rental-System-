import java.util.*;

// Base class
class Vehicle {
    protected String model;
    protected String registrationNumber;
    protected double pricePerDay;

    public Vehicle(String model, String registrationNumber, double pricePerDay) {
        this.model = model;
        this.registrationNumber = registrationNumber;
        this.pricePerDay = pricePerDay;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Reg No: " + registrationNumber);
        System.out.println("Price per day: Rs. " + pricePerDay);
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public String getModel() {
        return model;
    }
}

// Car class (subclass of Vehicle)
class Car extends Vehicle {
    private int seatingCapacity;

    public Car(String model, String registrationNumber, double pricePerDay, int seatingCapacity) {
        super(model, registrationNumber, pricePerDay);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Seating Capacity: " + seatingCapacity);
    }
}

// Bike class (subclass of Vehicle)
class Bike extends Vehicle {
    private int engineCC;

    public Bike(String model, String registrationNumber, double pricePerDay, int engineCC) {
        super(model, registrationNumber, pricePerDay);
        this.engineCC = engineCC;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Engine CC: " + engineCC);
    }
}

// Customer class
class Customer {
    private String name;
    private String licenseNumber;

    public Customer(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }

    public void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("License Number: " + licenseNumber);
    }
}

// Rental class
class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDays;

    public Rental(Customer customer, Vehicle vehicle, int rentalDays) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
    }

    public void calculateBill() {
        double total = vehicle.getPricePerDay() * rentalDays;
        System.out.println("Rental Details:");
        customer.displayCustomer();
        System.out.println("Vehicle rented: " + vehicle.getModel());
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Total amount: Rs. " + total);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Sample Vehicles
        Car car1 = new Car("Honda City", "KA01AB1234", 1500, 5);
        Bike bike1 = new Bike("Royal Enfield", "KA02CD5678", 800, 350);

        System.out.println("Welcome to Vehicle Rental Service");
        System.out.println("Available vehicles: ");
        System.out.println("1. Car");
        car1.displayInfo();
        System.out.println("2. Bike");
        bike1.displayInfo();

        // Get customer details
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your license number: ");
        String license = sc.nextLine();
        Customer customer = new Customer(name, license);

        System.out.print("Choose vehicle to rent (1=Car, 2=Bike): ");
        int choice = sc.nextInt();
        System.out.print("Enter number of rental days: ");
        int days = sc.nextInt();

        Rental rental;
        if (choice == 1) {
            rental = new Rental(customer, car1, days);
        } else {
            rental = new Rental(customer, bike1, days);
        }

        rental.calculateBill();
    }
}