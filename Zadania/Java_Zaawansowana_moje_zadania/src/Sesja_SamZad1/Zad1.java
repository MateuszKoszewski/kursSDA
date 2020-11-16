package Sesja_SamZad1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zad1 {
    public static void main(String[] args) {
        reverseNumber();
    }

    public static void reverseNumber() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        int number=0;
        while (exit) {
            System.out.println("put number");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                exit = false;
            } else {
                System.out.println("put the correct number");
                scanner.nextLine();
            }
        }
        // 1 SPOSÓB:
String numberToString = Integer.toString(number);
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(numberToString);
        System.out.println(stringbuilder.reverse());

    }
}
