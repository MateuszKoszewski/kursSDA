package Sesja_SamZad12;

import Sesja_SamZad10.Product;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final Map<Product, Integer> list = new HashMap<>();

    public void add (Product product, Integer amount){
        if (list.containsKey(product)){
            list.put(product, list.get(product)+amount);
        }
        else{
            list.put(product, amount);
        }

    }
    public void remove (Product product, Integer amount){
        if (list.containsKey(product) && amount<list.get(product)){
            list.put(product, list.get(product)-amount);
        }
        else {
            list.remove(product);
        }
    }
    public Map<Product, Integer> getProductList (){
        return new HashMap<>(list);
    }
    public void showProductList(){
        for (Map.Entry entry : list.entrySet()){
            System.out.println(entry);
        }
    }
}