package Sesja_SamZad10;

import java.time.LocalDate;

public interface Product {
    double getPrice();
    boolean isAvailable(LocalDate date);
}
