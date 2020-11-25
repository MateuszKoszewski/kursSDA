import java.time.LocalDate;
import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private int productionYear;
    private double price;
    private int course;

    public Car(String brand, String model, int productionYear, double price, int course) {
        this.brand = brand;
        this.model = model;
        this.productionYear = productionYear;
        this.price = price;
        this.course = course;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getCourse() {
        return course;
    }

    public int getProductionYear() {
        return productionYear;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + productionYear + " " + price + " " + course;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionYear == car.productionYear &&
                Double.compare(car.price, price) == 0 &&
                course == car.course &&
                Objects.equals(brand.toLowerCase(), car.brand.toLowerCase()) &&
                Objects.equals(model.toLowerCase(), car.model.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, price, course);
    }
}
