package Sesja_SamZad10;

import java.time.LocalDate;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenericProduct implements Product{
    private Supplier<Double> supplier;
    private Function<LocalDate,Boolean> function;

    public GenericProduct(Supplier<Double> supplier, Function<LocalDate, Boolean> function) {
        this.supplier = supplier;
        this.function = function;
    }

    @Override
    public double getPrice() {
        return supplier.get();
    }

    @Override
    public boolean isAvailable(LocalDate date) {
        return function.apply(date);
    }

    @Override
    public String toString() {
        return "GenericProduct{" +
                "supplier=" + supplier.get() +
                ", function=" + function.apply(LocalDate.of(2020,12,26)) +
                '}';
    }
}

