import java.time.LocalDate;

public class Transactions {
    private double price;
    private User user;
    private Car car;
    private int days;
    private LocalDate date;

    public Transactions(double price, User user, Car car, int days, LocalDate date) {
        this.price = price;
        this.user = user;
        this.car = car;
        this.days = days;
        this.date=date;
    }

    public double getPrice() {
        return price;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getDate() {
        return date;
    }
}
