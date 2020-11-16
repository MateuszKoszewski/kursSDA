package Sesja_SamZad10;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product onion = new GenericProduct(()->14.5,str ->str.isBefore(LocalDate.now()));
        Product apple = new GenericProduct(()->10.0,str ->str.isBefore(LocalDate.now()));
        Basket basket = new Basket();
        basket.add(onion);
        basket.add(apple);
        System.out.println(basket.getProductList());
    }
}
