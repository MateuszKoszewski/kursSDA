package Sesja_SamZad4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zad4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("mati","agu","kamil"));
        System.out.println(convertToUpperLetters(list));
    }
    public static List<String> convertToUpperLetters(List<String> list){
       return list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
    }
}
