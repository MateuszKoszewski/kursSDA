package Sesja_SamZad2;

import java.util.Scanner;

public class Zad2 {
    public static void main(String[] args) {
takeArray();
    }

    public static void takeArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("put the size of your array");
        int size = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
                break;
            } else {
                System.out.println("put the correct size of array");
                scanner.nextLine();
            }
        }
        int[] array = new int[size];
        System.out.println("put numbers into array");
        for (int i = 0; i < array.length; ) {
            while (true) {
                if (scanner.hasNextInt()) {
                    int numberToArray = scanner.nextInt();
                    array[i] = numberToArray;
                    if (i!=array.length-1) {
                        System.out.println("put the next number");
                    }
                    scanner.nextLine();
                    i++;
                    break;
                } else {

                    System.out.println("put the correct number");
                    scanner.nextLine();
                }
            }
        }
        System.out.println("first array :");
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("sorted array: ");
        for (int j=0; j<array.length-1;j++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        for (int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
    }
}
