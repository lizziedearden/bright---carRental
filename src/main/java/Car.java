import java.util.Objects;

public class Car {
    private String make;
    private int id;
    private double rentalPrice;
    private boolean rented;

    public Car(String make, int id, double rentalPrice, boolean rented) {
        this.make = make;
        this.id = id;
        this.rentalPrice = rentalPrice;
        this.rented = rented;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.rentalPrice, rentalPrice) == 0 && rented == car.rented && Objects.equals(make, car.make) && Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, id, rentalPrice, rented);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", id=" + id +
                ", rentalPrice=" + rentalPrice +
                ", rented=" + rented +
                '}';
    }
}
