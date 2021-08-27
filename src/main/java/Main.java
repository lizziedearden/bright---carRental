import java.sql.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arguments) {
        Car car1 = new Car("Tesla", 001, 500, true);
        Car car2 = new Car("Ferrari", 002, 700, false);
        Car car3 = new Car("Mercedes", 003, 400, true);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        System.out.println(cars.toString());
        System.out.println(rentedCars(cars));
        System.out.println(availableCars(cars));

        Car car4 = new Car("BMW", 004, 600, false);
        .m=nameOfMethod()
        cars = cars.add
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
