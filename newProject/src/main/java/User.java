import java.time.LocalDate;

public class User {

private String imie;  // nie puste
private String nazwisko;  // nie puste
private String pesel;  // 11 cyfr
    private int numberOfUser=TabliceUser.numberOfUser;
    private LocalDate dateOfBirth;
    private int rentedCars=0;

    public int getRentedCars() {
        return rentedCars;
    }

    public void setRentedCars(int rentedCars) {
        this.rentedCars = rentedCars;
    }

    public User (String name, String surname, String idNumber)   {
    imie=name;
    nazwisko=surname;
    pesel=idNumber;
    TabliceUser.numberOfUser=numberOfUser+1;
    dateOfBirth=TabliceUser.parseIntoDate(pesel);
}

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public int getNumberOfUser() {
        return numberOfUser;
    }

    public LocalDate getDateOfBirth(){
    return dateOfBirth;
}
}
