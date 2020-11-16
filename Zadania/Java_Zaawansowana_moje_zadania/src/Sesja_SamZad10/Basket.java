package Sesja_SamZad10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {
    private final List<Product> list = new ArrayList<>();

    public void add (Product product){
        list.add(product);
    }
    public void remove (Product product){
        list.remove(product);
    }
    public List<Product> getProductList (){
        return new ArrayList<>(list);
    }
}
