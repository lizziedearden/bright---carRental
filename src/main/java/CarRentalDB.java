import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRentalDB {
    private List<Car> cars;

    public CarRentalDB(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRentalDB that = (CarRentalDB) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    @Override
    public String toString() {
        return "CarRentalDB{" +
                "cars=" + cars +
                '}';
    }

    public void addCar(ArrayList<Car> cars, Car car) {
        cars.add(car);
    }

    public void removeCar(ArrayList<Car> cars, int removeCarId) {
        for (Car c : cars) {
            if (removeCarId == c.getId() && c.isRented() == false) {
                cars.remove(c);
                System.out.println("The car with the id " + c.getId() + " has been removed.");
            } else if (removeCarId == c.getId() && c.isRented() == true) {
                throw new IllegalArgumentException("This car is rented out so cannot be removed from the list!");
            }
//            else {
//                throw new IllegalArgumentException("This car does not exist!");
//            }
        }
    }

    public void bookCar(ArrayList<Car> cars, int rentCar) {
        for (Car c : cars) {
            try {
                if (rentCar == c.getId()) {
                    c.setRented(true);
                    System.out.println("You have rented a car: ID = " + rentCar);
                    return;
                }

            } catch (Exception e) {
                System.out.println("Error :((");
            }
        }
        System.out.println("The car ID you gave us does not exist!");
    }

    public void returnCar(ArrayList<Car> cars, int returnCar) {
        for (Car c : cars) {
            try {
                if (returnCar == c.getId()) {
                    c.setRented(false);
                    System.out.println("You have returned a car: ID = " + returnCar);
                    return;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Error :(");
            }
        }
        System.out.println("The car ID you gave us does not exist!");
    }
}
