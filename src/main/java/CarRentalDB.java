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

    public static void addCar(ArrayList<Car> cars, Car car) {
        cars.add(car);
    }

    public static void removeCar(ArrayList<Car> cars, int removeCarId) {
        for (Car c : cars) {
            if (removeCarId == c.getId()) {
                cars.remove(c);
                System.out.println("The car with the id " + c.getId() + " has been removed.");
            } else if (c.isRented()) {
                throw new IllegalArgumentException("This car is rented out so cannot be removed from the list!");
            } else {
                throw new IllegalArgumentException("This car does not exist!");
            }
        }
    }

    public static void bookCar(ArrayList<Car> cars, int rentCar) {
        try {
            for (Car c : cars) {
                if (rentCar == c.getId()) {
                    c.setRented(true);
                    System.out.println("You have rented a car: ID = " + rentCar);
                }
            }
        } catch (Exception e) {
            System.out.println("The car ID you gave us does not exist!");
        }
    }

    public static void returnCar(ArrayList<Car> cars, int returnCar) {
        try {
            for (Car c : cars) {
                if (returnCar == c.getId()) {
                    c.setRented(false);
                    System.out.println("You have returned a car: ID = " + returnCar);

                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("A car with that Id does not exist.");
        }
    }
}



//Add methods for returning a car-switch the boolean type to true
//ternary
//set the boolean to not current value

// add and remove car methods-general

//Friday Team Project
//Implement a car rental management system cli program.
//
//CAR MANAGEMENT
//- The user should be able to add new cars including daily price for renting
//- The user should be able to remove cars if not being rented

//
//RENTAL
//- The user should be able to book a car
//- The user should be able to return a car
//4 Things to take into consideration:
//Create a class called CarRentalDB:
//- You should have one property that can store a list of cars with corresponding details
//- Create a public method for adding a car to the list
//- Create a public method for deleting a car from the list if car exists// Try Catch
//- think about other methods that your application needs

//IO package