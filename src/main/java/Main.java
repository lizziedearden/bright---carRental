import java.util.ArrayList;

public class Main {
    public static void main(String[] arguments){
        Car car1 = new Car("Tesla", 001, 500, true);
        Car car2 = new Car("Ferrari", 002, 700, false);
        Car car3 = new Car("Mercedes", 003, 400, true);

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        System.out.println(cars.toString());
    }
}
