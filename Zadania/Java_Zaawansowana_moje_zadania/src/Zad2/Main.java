package Zad2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        List<String> sorted = list.stream().sorted(Comparator.comparing((str1 -> str1.toString().toLowerCase())).reversed()).collect(Collectors.toList());
        System.out.println(sorted);
    }
}
