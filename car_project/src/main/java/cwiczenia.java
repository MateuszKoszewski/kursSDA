import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class cwiczenia {
    public static  void main(String[] args) {
        String age = "1560";
        System.out.println(age.substring(0,2));
        String date = "891225";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        LocalDate formatedDate;
        formatedDate = LocalDate.parse(date, formatter);
        System.out.println(formatedDate);
        LocalDate date2 = StaticMethods.parseIntoDate("2011240");
        System.out.println(date2);
        System.out.println(date2.getMonth().getValue());
        List <String> list = new ArrayList<>();
List<Car> carList = new ArrayList<>();
        carList.add(new Car("Toyota", "Corolla", 2005, 140, 220000));
        carList.add(new Car("Honda", "Civic", 2007, 110, 205670));
        try {
            Files.writeString(Paths.get("baza.txt"), "", StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Blad");
        }
        for (int i=0; i<carList.size(); i++){
            list.add(carList.get(i).toString());
        }

//try {
//    Files.write(Paths.get("baza.txt"), list.stream().map(car -> car.), StandardCharsets.UTF_16, StandardOpenOption.APPEND);
//}
//catch (IOException e){
//
//}
List<String> stringListofCars = null;
try {
    stringListofCars = Files.readAllLines(Paths.get("baza.txt"), StandardCharsets.UTF_16);

}
catch (IOException e){
    e.printStackTrace();
    System.out.println("nie ma takiego pliku");
}
        System.out.println(stringListofCars);
        assert stringListofCars != null;
        String [] car = stringListofCars.get(0).split(" ");
       carList.add(new Car(car[0], car[1], Integer.parseInt(car[2]), Double.parseDouble(car[3]), Integer.parseInt(car[4])));



//for (int i=0; i<stringListofCars.size();i++){
//    List<String> car = stringListofCars.get(i).split(" ")
//}

//        try {
//            Files.writeString(Paths.get("baza.txt"), date + "\n", StandardOpenOption.APPEND);
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Blad");
//        }


//      double price = StaticMethods.checkConditions2(str -> str>0, "invalid value","put the correct value");
//        System.out.println(price);
    }


}
