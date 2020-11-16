package Sesja_SamZad6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Zad6 {
    public static void main(String[] args) {
List<Integer> list = new ArrayList<>(List.of(3,44,6,47,5));
        System.out.println(convertToNewList(list));
    }
    public static String convertToNewList (List<Integer> list){
        return list.stream().map(str -> str%2==0 ? "e"+str : "o"+str).collect(Collectors.joining(", "));
    }


}
