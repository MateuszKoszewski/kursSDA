import java.time.LocalDate;

public class Car {
    private String marka;
    private String model;
    private int przebieg;
    private LocalDate RokProdukcji;
    private double cenaZaDzien;
    private int numberOfCar= TabliceSamochody.numberOfCarsToRent;
    private User user;
    private int rentTime;
    private double biezacaCena;

    public double getBiezacaCena() {
        return biezacaCena;
    }

    public void setBiezacaCena(double biezacaCena) {
        this.biezacaCena = biezacaCena;
    }

    public User getUser() {
        return user;
    }

    public int getRentTime() {
        return rentTime;
    }

    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car (String marka, String model, int przebieg, LocalDate RokProdukcji, double cenaZaDzien){
        this.marka=marka;
        this.model=model;
        this.przebieg=przebieg;
        this.RokProdukcji=RokProdukcji;
        this.cenaZaDzien=cenaZaDzien;
        TabliceSamochody.numberOfCarsToRent++;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public double getCenaZaDzien() {
        return cenaZaDzien;
    }

    public LocalDate getRokProdukcji(){
        return RokProdukcji;
    }
public void setCenaZaDzien (double nowaCena){
        this.cenaZaDzien=nowaCena;
}
}
