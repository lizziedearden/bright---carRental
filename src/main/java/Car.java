import java.util.Objects;

public class Car {
    private String make;
    private Long id;

    public Car(String make, Long id) {
        this.make = make;
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return make.equals(car.make) && id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, id);
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", id=" + id +
                '}';
    }
}
