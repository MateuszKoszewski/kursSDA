package Zad3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
Map<String, Integer> mapa = new HashMap<>();
mapa.put("mati",1);
mapa.put("kamil",2);
mapa.put("aga",3);
method(mapa);

    }
    //SPOSÓB 1
//    public static void method (Map<String, Integer> map){
//        List<String> list = new ArrayList<>();
//      for (Map.Entry entry : map.entrySet()){
//          list.add("Klucz: " + entry.getKey() + ", " + entry.getValue());
//      }
//        for (int i=0; i<list.size()-1; i++){
//            list.set(i, list.get(i) +",");
//            System.out.println(list.get(i));
//        }
//        list.set(list.size()-1, list.get(list.size()-1)+".");
//        System.out.println(list.get(list.size()-1));
//    }

    // SPOSÓB 2
//    public static void method (Map<String, Integer> map){
//        List <String> list = map.entrySet().stream().map(str -> "Klucz: " + str.getKey() + ", Wartość: " + str.getValue()).collect(Collectors.toList());
//        for (int i=0; i<list.size(); i++){
//            if (i==list.size()-1) {
//                System.out.println(list.get(i) + ".");
//            }
//            else {
//                System.out.println(list.get(i) + ",");
//            }
//        }
//    }

    // SPOSÓB 3
// metoda reduce - pierwszy output to wartość początkowa - dlatego pierwszym outputem jest pusty string.
    public static void method (Map<String, Integer> map){
        var string = map.entrySet().stream()
                .map(element -> String.format("Klucz: %s, Wartość: %d", element.getKey(), element.getValue()))
                .reduce("", (output, next) -> output.isEmpty() ? next : String.format("%s,\n%s", output, next)) + ".";
        System.out.println(string);

    }
}
