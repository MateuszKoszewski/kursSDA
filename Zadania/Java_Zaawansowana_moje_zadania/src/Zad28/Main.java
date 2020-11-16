package Zad28;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Character> list= new ArrayList<>(List.of('a','b','c','d','e','f','g'));
        ArrayTask array = new ArrayTask(list);
        System.out.println(array.getEveryNthElement(2, 3));
        System.out.println(array.getIndex(0));
        System.out.println(array.getSkip(3));
        System.out.println(array.skip(4));
    }
}
