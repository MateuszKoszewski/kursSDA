import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String last_name;
    private String ID;
private LocalDate dateOfBirth;
private int age;
private List<Car> rentedCars;

User(String name, String last_name, String ID){
    this.name = name;
    this.last_name = last_name;
    this.ID=ID;
    this.age = LocalDate.now().getYear()-StaticMethods.parseIntoDate(ID).getYear();
    rentedCars=new ArrayList<>();
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(ID, user.ID);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, last_name, ID, dateOfBirth, rentedCars);
    }

    @Override
    public String toString() {
        return name + " " + last_name + ", " + "ID: " + ID + ", Date of birth: " + StaticMethods.parseIntoDate(ID) + ". Cars rented so far: " + rentedCars.size();
    }

    public String getID() {
        return ID;
    }

    public int getAge() {
        return age;
    }

    public List<Car> getRentedCars() {
        return rentedCars;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
