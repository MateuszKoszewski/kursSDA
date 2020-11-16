package Zad6;

import java.util.Map;
import java.util.TreeMap;

//Stwórz metodę, która przyjmuje
//TreeMap i wypisuje w konsoli pierwszy i ostatni EntrySet
public class Zad6 <K,V>{
    public static void main(String[] args) {
Zad6<Object, Object> zad6 = new Zad6<>();
TreeMap<Object, Object> treemap = new TreeMap<>();
treemap.put("A","1");
treemap.put("b","2");
treemap.put("c","3");
zad6.method(treemap);
    }

    public void method (TreeMap <K,V> treemap){
        System.out.println(treemap.firstEntry());
        System.out.println(treemap.lastEntry());
    }
}
