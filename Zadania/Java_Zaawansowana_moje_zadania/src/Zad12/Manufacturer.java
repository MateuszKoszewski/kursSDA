package Zad12;

import java.time.LocalDate;
import java.util.Objects;

public class Manufacturer {
    private String name;
    private LocalDate dateOfProduction;
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Manufacturer(String name, LocalDate dateOfProduction, String country) {
        this.name = name;
        this.dateOfProduction = dateOfProduction;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(dateOfProduction, that.dateOfProduction) &&
                Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateOfProduction, country);
    }
}
