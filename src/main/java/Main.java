
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Car car1 = new Car("Tesla", 1, 500, true);
        Car car2 = new Car("Ferrari", 2, 700, false);
        Car car3 = new Car("Mercedes", 3, 400, true);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you a manager or a customer? m/c");
        String managerCustomer = scanner.nextLine().toLowerCase();
        if(managerCustomer.equals("m")){
            System.out.println("Would you like to: \n (a)See list of cars \n (b)See list of rented cars \n (c)See list of available cars \n (d)Add a car \n (e)Remove a car \n Select a/b/c/d/e");
            String managerAnswer = scanner.nextLine().toLowerCase();
            switch (managerAnswer) {
                case "a":
                    System.out.println(cars.toString());
                    break;
                case "b":
                    System.out.println(rentedCars(cars));
                    break;
                case "c":
                    System.out.println(availableCars(cars));
                    break;
                case "d":
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
                    break;
                case "e":
                    break;
                default:
                    System.out.println("Input invalid");
                    break;
            }
        } else if(managerCustomer.equals("c")){
            System.out.println("Would you like to: \n (a)Book a car \n (b)Return a car \n Select a or b");
            String customerAnswer = scanner.nextLine().toLowerCase();
            switch(customerAnswer){
                case "a":
                    System.out.println("Here is the list of available cars: \n " + availableCars(cars) + "Which car would you like to rent? Just give the ID number");
                    String stringRentCar = scanner.nextLine();
                    int rentCar = Integer.parseInt(stringRentCar);
                    break;
                case "b":
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        } else {
            System.out.println("Your input was invalid!");
        }





//        Car car4 = new Car("BMW", 004, 600, false);
//        CarRentalDB.addCar(cars, car4);
//        System.out.println(cars);
//
//        Car car5 = new Car("Honda", 005, 300, true);
//        CarRentalDB.addCar(cars, car5);
//        System.out.println(cars);
//
//        CarRentalDB.removeCar(cars, car5);
//        System.out.println(cars);

    }

    public static ArrayList<Car> rentedCars(ArrayList<Car> cars) {
        ArrayList<Car> rentedCars = new ArrayList<>();
        cars.forEach(car -> {
            if (car.isRented() == true) {
                rentedCars.add(car);
            }

        });
        return rentedCars;
    }

    public static ArrayList<Car> availableCars(ArrayList<Car> cars) {
        ArrayList<Car> availableCars = new ArrayList<>();
        cars.forEach(car -> {
            if (car.isRented() == false) {
                availableCars.add(car);
            }

        });
        return availableCars;
    }
}
