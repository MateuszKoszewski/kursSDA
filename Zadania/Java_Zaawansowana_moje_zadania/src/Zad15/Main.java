package Zad15;

public class Main {
    public static void main(String[] args) {
        System.out.println(Car.FERRARI.isPremium());
        System.out.println(Car.TOYOTA.isPremium());
        System.out.println(Car.FERRARI.isFasterThan(Car.TOYOTA));
    }
}
