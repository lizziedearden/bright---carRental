
import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Car car1 = new Car("Tesla", 1, 500, true);
        Car car2 = new Car("Ferrari", 2, 700, false);
        Car car3 = new Car("Mercedes", 3, 400, false);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a manager or a customer? m/c");
        String managerCustomer = scanner.nextLine().toLowerCase();
        boolean customerLoop = true;
        while(customerLoop) {
            if (managerCustomer.equals("m")) {
                System.out.println("Would you like to: \n (a)See list of cars \n (b)See list of rented cars \n (c)See list of available cars \n (d)Add a car \n (e)Remove a car \n (f)Exit \n Select a/b/c/d/e/f");
                String managerAnswer = scanner.nextLine().toLowerCase();
                switch (managerAnswer) {
                    case "a" -> System.out.println(cars);
                    case "b" -> System.out.println(rentedCars(cars));
                    case "c" -> System.out.println(availableCars(cars));
                    case "d" -> {
                        System.out.println("What car would you like to add?");
                        System.out.println("Make?");
                        String newCarModel = scanner.nextLine();
                        System.out.println("ID? Give the car a three digit ID");
                        String newCarStringID = scanner.nextLine();
                        int newCarID = Integer.parseInt(newCarStringID);
                        System.out.println("Rental Price?");
                        String newCarStringPrice = scanner.nextLine();
                        double newCarPrice = Double.parseDouble(newCarStringPrice);
                        Car newCar = new Car(newCarModel, newCarID, newCarPrice, false);
                        CarRentalDB.addCar(cars, newCar);
                        System.out.println(cars);
                    }
                    case "e" -> {
                        System.out.println(availableCars(cars));
                        System.out.println("What car would you like to remove?");
                        String removeCarStringId = scanner.nextLine();
                        int removeCarId = Integer.parseInt(removeCarStringId);
                        CarRentalDB.removeCar(cars, removeCarId);
                    }
                    case "f" -> {
                        customerLoop = false;
                    }
                    default -> System.out.println("Input invalid");
                }
            } else if (managerCustomer.equals("c")) {
                System.out.println("Would you like to: \n (a)Book a car \n (b)Return a car \n (c)Exit \n Select a or b or c");
                String customerAnswer = scanner.nextLine().toLowerCase();
                switch (customerAnswer) {
                    case "a" -> {
                        System.out.println("Here is the list of available cars: \n " + availableCars(cars) + "Which car would you like to rent? Just give the ID number");
                        String stringRentCar = scanner.nextLine();
                        int rentCar = Integer.parseInt(stringRentCar);
                        CarRentalDB.bookCar(cars, rentCar);
                    }
                    case "b" -> {
                        System.out.println("Here is the list of rented cars: \n" + rentedCars(cars) + "Give the id of the car you would like to return:");
                        String stringReturnCar = scanner.nextLine();
                        int returnCar = Integer.parseInt(stringReturnCar);
                        CarRentalDB.returnCar(cars, returnCar);
                    }
                    case "c" -> {
                        customerLoop = false;
                    }
                    default -> System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Your input was invalid!");
            }
        }
    }

    public static ArrayList<Car> rentedCars(ArrayList<Car> cars) {
        ArrayList<Car> rentedCars = new ArrayList<>();
        cars.forEach(car -> {
            if (car.isRented()) {
                rentedCars.add(car);
            }

        });
        return rentedCars;
    }

    public static ArrayList<Car> availableCars(ArrayList<Car> cars) {
        ArrayList<Car> availableCars = new ArrayList<>();
        cars.forEach(car -> {
            if (!car.isRented()) {
                availableCars.add(car);
            }

        });
        return availableCars;
    }
}
