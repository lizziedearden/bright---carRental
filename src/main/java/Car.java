import java.util.Objects;

public class Car {
    private String make;
    private Long id;
    private int rentalPrice;

    public Car(String make, Long id, int rentalPrice) {
        this.make = make;
        this.id = id;
        this.rentalPrice = rentalPrice;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return rentalPrice == car.rentalPrice && make.equals(car.make) && id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, id, rentalPrice);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", id=" + id +
                ", rentalPrice=" + rentalPrice +
                '}';
    }
}
