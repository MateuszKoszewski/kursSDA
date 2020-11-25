import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StaticMethods {


    public static String StringIsNotBlank() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            if (string.isBlank()) {
                System.out.println("you haven't written anything");

            } else {
                return string;
            }
        }
    }

    public static double checkConditions(Predicate<Double> predicate, String answer1, String answer2) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                if (predicate.test(value)) {
                    return value;
                } else {
                    System.out.println(answer1);
                    scanner.nextLine();
                }
            } else {
                System.out.println(answer2);
                scanner.nextLine();
            }
        }

    }
    public static LocalDate parseIntoDate (String ID){
        String date = ID.substring(0,6);
        LocalDate formatedDate;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        if (Integer.parseInt(date.substring(0,2))<LocalDate.now().getYear()-2000){
            formatedDate = LocalDate.parse(date,formatter);
        }
        else{
            String newDate = "19"+date;
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyyMMdd");
            formatedDate = LocalDate.parse(newDate,formatter2);
        }
        return formatedDate;
    }
    public static <E> void printList(List<E> list){
        for (int i=0;i<list.size();i++){
            System.out.println(i+1 + ". " + list.get(i));
        }
    }
    public static final BiFunction<Integer, Comparator<?>, Comparator<?>> function = (integer, comparator) -> integer == 1 ? comparator : comparator.reversed();
}