package Zad1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//Stwórz metodę, która jako parametr przyjmuje listę stringów, następnie zwraca tą listę posortowaną
//alfabetycznie od Z do A.
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ala");
        list.add("ma");
        list.add("kota");
        list.add("a");
        list.add("koty");
        list.add("maja");
        list.add("Ale");

        List<String> sorted = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sorted);
    }
}
