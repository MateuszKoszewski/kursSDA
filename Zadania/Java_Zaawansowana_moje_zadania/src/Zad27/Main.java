package Zad27;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Joiner joiner = new Joiner("-");
        System.out.println(joiner.join(List.of(1,2,3,4,5)));

    }
}
