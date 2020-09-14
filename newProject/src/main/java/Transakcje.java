import java.time.LocalDate;

public class Transakcje {
    private User user;
    private Car car;
    private double price;
    private LocalDate transakcionDate;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getTransakcionDate() {
        return transakcionDate;
    }

    public void setTransakcionDate(LocalDate transakcionDate) {
        this.transakcionDate = transakcionDate;
    }

    public Transakcje (User user, Car car, double price, LocalDate dateOfTransaction){
    this.user=user;
    this.car=car;
    this.price=price;
    transakcionDate=dateOfTransaction;
}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
