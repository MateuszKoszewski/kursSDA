package Sesja_SamZad12;


import Sesja_SamZad10.GenericProduct;
import Sesja_SamZad10.Product;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product onion = new GenericProduct(()->14.5, str ->str.isBefore(LocalDate.now()));
        Product apple = new GenericProduct(()->10.0,str ->str.isBefore(LocalDate.now()));
        Basket basket = new Basket();
        basket.add(onion, 2);
        basket.add(apple, 3);
        basket.add(onion, 5);
        basket.remove(apple,1);
basket.showProductList();
    }
}
