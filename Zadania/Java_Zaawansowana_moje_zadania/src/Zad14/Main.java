package Zad14;

public class Main {
    public static void main(String[] args) {

        Array array = new Array(10);
        System.out.println(array.getArray());
        System.out.println(array.getAtLeast2Values());
        array.deduplicateValues();
        System.out.println(array.getArray());
        System.out.println(array.getAtLeast2Values());

    }
}
