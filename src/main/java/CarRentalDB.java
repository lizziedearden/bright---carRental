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