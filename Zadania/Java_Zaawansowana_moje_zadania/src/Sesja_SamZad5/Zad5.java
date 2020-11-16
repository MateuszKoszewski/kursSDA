package Sesja_SamZad5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zad5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Mati","agu","kamil","pawi","apu"));
        System.out.println(sortList(list));
    }
    public static List<String> sortList (List<String> list){
        return list.stream().filter(str->str.charAt(0)=='a').filter(str -> str.length()==3).collect(Collectors.toList());
    }
}
