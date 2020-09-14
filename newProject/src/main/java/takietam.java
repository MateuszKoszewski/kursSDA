import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class takietam {
    public static void main(String[] args) {
        double rounded = Precision.round(1.2222234,3, BigDecimal.ROUND_HALF_UP);
        System.out.println("rounded = " + rounded);
//        System.out.println(Double.MAX_VALUE);
//        Scanner scanner = new Scanner(System.in);
//        if (scanner.hasNextInt()) {
//            System.out.println("działa");
//        } else {
//            System.out.println("nie działa");
//        }
//        scanner.nextLine();
//        System.out.println("wpisz przebieg");
//        while (!scanner.hasNextInt()) {
//            System.out.println("wpisz jeszcze raz");
//            scanner.nextLine();
//        }
//        int liczba = scanner.nextInt();
//        System.out.println(liczba);
//        changeDate("021124");
        LocalDate date = TabliceUser.parseIntoDate("30112400593");
        String da = (date.getMonth().toString());
        date = null;
        System.out.println(date);
//        System.out.println("wpisz cene");
//        System.out.println(tryEnterPrice());

    }

    public static double tryEnterPrice() {
        Scanner enterPrice = new Scanner(System.in);
        String price ="";
        while (true) {
            price = enterPrice.nextLine();
            Pattern compile = Pattern.compile("(^\\d{1,50}\\.\\d{1,50}$)");
            Matcher matcher = compile.matcher(price);
            Pattern compile2 = Pattern.compile("^\\d{1,50}$");
            Matcher matcher2 = compile2.matcher(price);
            if (matcher.find()) {
                price=matcher.group(0);
                break;
            }
            if (matcher2.find()) {
                price=matcher2.group(0);
                break;
            }
            System.out.println("wpisz poprawną cenę");
        }
        return Double.parseDouble(price);
    }
    public static void changeDate (String number){
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate dataSformatowana = LocalDate.parse(number,formater);
        System.out.println(dataSformatowana);
    }
}
//,(^\d{1,50}\.\d{1,50}$)