
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] arguments) {
        Car car1 = new Car("Tesla", 001, 500, true);
        Car car2 = new Car("Ferrari", 002, 700, false);
        Car car3 = new Car("Mercedes", 003, 400, true);

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
                default:
                    System.out.println("Input invalid");
                    break;
            }
        } else if(managerCustomer.equals("c")){
            System.out.println("customer");
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
