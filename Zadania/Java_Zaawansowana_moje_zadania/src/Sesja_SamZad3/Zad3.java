package Sesja_SamZad3;

import java.util.ArrayList;
import java.util.List;

public class Zad3 {
    public static void main(String[] args) {
List<Integer> list = new ArrayList<>(List.of(5,34,26,16));
        System.out.println(takeAverage(list));
    }
    public static double takeAverage(List<Integer> list){
        return (double)list.stream().reduce(0,(input,output)-> input+output)/list.size();
    }
    //drugi sposób
//    public static double takeAverage(List<Integer> list){
//        return list.stream().mapToInt(i->i).average().getAsDouble();
//    }
}
