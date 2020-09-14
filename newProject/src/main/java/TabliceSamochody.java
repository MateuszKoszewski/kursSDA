import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabliceSamochody {
    public static Car[] tablicaSamochodow = new Car[100];
    public static Car[] rentedCars = new Car[100];
    public static int numberOfCarsToRent = 0;
    public static int numberOfRentedCars=0;
    public static Transakcje [] transakcje = new Transakcje[200];

    public static void addCarToArray() {
        for (int i=0; i<tablicaSamochodow.length;i++){
            if (tablicaSamochodow[i]==null){
                tablicaSamochodow[i]=addCar();
                break;
            }
        }
    }

    public static void addCarToArray(Car car) {
        for (int i=0; i<tablicaSamochodow.length;i++){
            if (tablicaSamochodow[i]==null){
                tablicaSamochodow[i]=car;
                break;
            }
        }
    }

    public static void ListofAvailableCars() {
        for (int i = 0; i < tablicaSamochodow.length; i++) {
            if (tablicaSamochodow[i] != null) {
                String data = tablicaSamochodow[i].getRokProdukcji().toString();
                String format = "%d: %s - %s. Mileage: %d, year of production: %s, price per day: %s ";
                String wypelniony = String.format(format, i+1, tablicaSamochodow[i].getMarka(), tablicaSamochodow[i].getModel(), tablicaSamochodow[i].getPrzebieg(), data, tablicaSamochodow[i].getCenaZaDzien());
                System.out.println(wypelniony);
            }
        }
    }

    public static Car addCar() {
        Scanner scannerCar = new Scanner(System.in);
        System.out.println("Specify data for new car:" +
                "\n Specify brand:");
        String brand = TabliceSamochody.tryOneMoreTime();
        System.out.println("Specify model:");
        String model = TabliceSamochody.tryOneMoreTime();
        System.out.println("Specify mileage:");
        int mileage = tryEnterMileage();
        System.out.println("Specify year of production (in format yyyy-mm-dd):");
        String yearOfProduction = tryEnterDate();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formatedDate = LocalDate.parse(yearOfProduction, formater);
        System.out.println("Specify Price per day:");
        double pricePerDay = TabliceSamochody.tryEnterPrice();
        System.out.println("the car is added");
        return new Car(brand, model, mileage, formatedDate, pricePerDay);
    }

    public static void editRentalPrice() {
        Scanner scannerPrice = new Scanner(System.in);
        System.out.println("Which car would you like to edit price for? Cars in our rental:");
        TabliceSamochody.ListofAvailableCars();
        int choice=selectCarPrice();
        System.out.println("Enter price");
        double newPrice = tryEnterPrice();
        TabliceSamochody.tablicaSamochodow[choice-1].setCenaZaDzien(newPrice);
    }

    public static LocalDate parseDate(String date) {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(date, formater);
    }

    public static String tryOneMoreTime() {
        Scanner oneMoreTime = new Scanner(System.in);
        String string = oneMoreTime.nextLine();
        while (string.isBlank()) {
            System.out.println("Try one more time");
            string = oneMoreTime.nextLine();
        }
        return string;
    }
    public static int tryEnterMileage(){
        Scanner mustBeInt = new Scanner(System.in);
        String przebieg = mustBeInt.nextLine();
        while (true){
            Pattern compile = Pattern.compile("^\\d{1,6}$");
            Matcher matcher = compile.matcher(przebieg);
                if (matcher.find() && Integer.parseInt(matcher.group(0))>=0){
                    przebieg = matcher.group(0);
                    break;
                }
            System.out.println("enter the correct mileage");
                przebieg = mustBeInt.nextLine();
        }
        return Integer.parseInt(przebieg);
    }
    public static String tryEnterDate(){
        Scanner dateScanner = new Scanner(System.in);
        String newDate = dateScanner.nextLine();
        while (true){
            Pattern compile = Pattern.compile("^19[6-9]\\d-0\\d-[0-3]\\d$");
            Matcher matcher = compile.matcher(newDate);
            Pattern compile2 = Pattern.compile("^19[6-9]\\d-1[1-2]-[0-3]\\d$");
            Pattern compile3 = Pattern.compile("^20[0-2]\\d-0\\d-[0-3]\\d$");
            Pattern compile4 = Pattern.compile("^20[0-2]\\d-1[1-2]-[0-3]\\d$");
            Matcher matcher2 = compile2.matcher(newDate);
            Matcher matcher3 = compile3.matcher(newDate);
            Matcher matcher4 = compile4.matcher(newDate);
            if (matcher.find()){
                newDate=matcher.group(0);
                break;
            }
            if (matcher2.find()){
                newDate=matcher2.group(0);
                break;
            }
            if (matcher3.find()){
                newDate=matcher3.group(0);
                break;
            }
            if (matcher4.find()){
                newDate=matcher4.group(0);
                break;
            }
            System.out.println("enter the correct date");
            newDate=dateScanner.nextLine();
        }
        return newDate;
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
        System.out.println("Enter the correct price");
    }
    return Double.parseDouble(price);
}
public static void rentACar(){
        Scanner scannerToRent = new Scanner(System.in);
        TabliceUser.listOfActivatedUsers();
    System.out.println("select user");
    int selectUser = scannerToRent.nextInt();

    while (!(selectUser<=TabliceUser.numberOfActivatedUsers) || selectUser<=0){
        System.out.println("select user from the list");
        selectUser=scannerToRent.nextInt();
    }
    User user = TabliceUser.tablicaUserAktywni[selectUser-1];

    System.out.println("Available cars in our rental");
    ListofAvailableCars();

    int selectCar = scannerToRent.nextInt();
    while (!(selectCar<=numberOfCarsToRent)||selectCar<=0){
        System.out.println("select the car from the list");
        selectCar=scannerToRent.nextInt();
    }
    System.out.println("yout choice is " + tablicaSamochodow[selectCar-1].getMarka());
    Car car = tablicaSamochodow[selectCar-1];
    System.out.println("for how many days?");
    int duration = scannerToRent.nextInt();
    while (duration<0){
        System.out.println("put the correct amounth of days");
        duration=scannerToRent.nextInt();
    }
    double price = 0;
    if (user.getRentedCars()>=100 || isMoreThanForty(user)) {
        price = duration * car.getCenaZaDzien() * 0.9;
    }
    else {
        price = duration*car.getCenaZaDzien();
    }
    car.setBiezacaCena(price);
    System.out.println("Rent will cost " + price + ". Are you sure ? [yes/no]");
    String acceptOrNot = scannerToRent.nextLine().toLowerCase();
    while (!(acceptOrNot.equals("yes")||acceptOrNot.equals("no"))){
        System.out.println("you must enter yes or no");
        acceptOrNot=scannerToRent.nextLine();
    }
    if (acceptOrNot.equals("yes")){
        numberOfRentedCars++;
        car.setRentTime(duration);
     for (int i=0;i<rentedCars.length;i++){
         if (rentedCars[i]==null){
             rentedCars[i]=car;
             break;
         }
     }
     car.setUser(user);
        user.setRentedCars(user.getRentedCars()+1);
        tablicaSamochodow[selectCar-1]=null;
        makeTidyArray(tablicaSamochodow);
        numberOfCarsToRent--;

        for (int i=0;i<transakcje.length;i++){
            if (transakcje[i]==null){
                transakcje[i]=new Transakcje(user, car, price, LocalDate.now());
                break;
            }
        }
    }
}
public static void makeTidyArray(Car[] car){
    for (int i=0; i<tablicaSamochodow.length-1;i++){
        if (car[i] == null && car[i+1] !=null){
            car[i]=car[i+1];
            car[i+1]=null;
        }
    }
}
public static void listAllRentedCars(){
    for (int i = 0; i < rentedCars.length; i++) {
        if (rentedCars[i] != null) {
            String format = "%d. %s %s - %s %s, czas najmu: %d dni, cena: %.2f";
            String wypelniony = String.format(format, i+1, rentedCars[i].getUser().getImie(), rentedCars[i].getUser().getNazwisko(), rentedCars[i].getMarka(), rentedCars[i].getModel(), rentedCars[i].getRentTime(), rentedCars[i].getRentTime()*rentedCars[i].getBiezacaCena());
            System.out.println(wypelniony);
        }
    }
}
public static void returnACar(){
     listAllRentedCars();
    System.out.println("Which car would you like to return?");
    Scanner scannerReturn = new Scanner(System.in);
    System.out.println("select car");
    int selectCar = scannerReturn.nextInt();
    while (!(selectCar<=numberOfRentedCars || selectCar<=0)){
        System.out.println("select car from the list");
        selectCar=scannerReturn.nextInt();
    }
    Car car = rentedCars[selectCar-1];
    rentedCars[selectCar-1]=null;
    for(int i=0; i<=numberOfCarsToRent;i++){
        if (tablicaSamochodow[i]==null){
            tablicaSamochodow[i]=car;
            break;
        }
    }
    makeTidyArray(rentedCars);
    numberOfRentedCars--;
    numberOfCarsToRent++;
}
public static boolean isMoreThanForty (User user){
LocalDate start = user.getDateOfBirth();
LocalDate end = LocalDate.now().minusYears(40);
    return start.isBefore(end);
}
public static void transakcionsList (){
    for (int i = 0; i < transakcje.length; i++) {
        if (transakcje[i] != null) {
            String format = "%d. %s %s - %s %s, czas najmu: %d dni, cena: %.2f";
            String wypelniony = String.format(format, i, transakcje[i].getUser().getImie(), transakcje[i].getUser().getNazwisko(), transakcje[i].getCar().getMarka(), transakcje[i].getCar().getModel(), transakcje[i].getCar().getRentTime(), transakcje[i].getPrice());
            System.out.println(wypelniony);
        }
    }
}
public static void displayMonthlyReport(){
    System.out.println("choose a month - enter number of month");
        Scanner scannerMonth = new Scanner(System.in);
        String month = scannerMonth.nextLine();
    Pattern compile = Pattern.compile("^1[0-2]$");
    Matcher matcher = compile.matcher(month);
    Pattern compile2 = Pattern.compile("^[1-9]$");
    Matcher matcher2 = compile2.matcher(month);
    while (!(matcher.find() || matcher2.find())) {

        System.out.println("you entered wrong number of month");
        month = scannerMonth.nextLine();
        compile = Pattern.compile("^1[0-2]$");
        matcher = compile.matcher(month);
        compile2 = Pattern.compile("^[1-9]$");
        matcher2 = compile2.matcher(month);
    }
int integerMonth = Integer.parseInt(month);
    System.out.println("here is montly report for " + chooseMonth(integerMonth));
    System.out.println(printRaport(integerMonth));
}
public static String chooseMonth(int number){
        switch (number){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "-1";
        }
}
public static String printRaport (int month){
        double income=0;
        int totalNumberOfRentals=0;
    for (int i=0; i<transakcje.length;i++) {
        if (transakcje[i] != null) {
            if (transakcje[i].getTransakcionDate().getMonth().toString().equals(chooseMonth(month).toUpperCase())) {
                totalNumberOfRentals++;
                income = income + transakcje[i].getPrice();
            }
        }
    }
    return "Earnings for " + chooseMonth(month) + ":   Total number of rentals:    " + totalNumberOfRentals + ". Income: " + income;
}
public static void printYearlyRaport(){
        for (int i=1;i<=12;i++){
            System.out.println(printRaport(i));
        }
    }
    public static int selectCarPrice (){
        Scanner selectCarPrice = new Scanner(System.in);
        String selectCar ="";
        while (true) {
            selectCar = selectCarPrice.nextLine();
            Pattern compile = Pattern.compile("^[0-9]$");
            Matcher matcher = compile.matcher(selectCar);
            Pattern compile2 = Pattern.compile("^[0-9][0-9]$");
            Matcher matcher2 = compile2.matcher(selectCar);
            if (matcher.find()) {
                selectCar=matcher.group(0);
                if (Integer.parseInt(selectCar)>0 && Integer.parseInt(selectCar)<=numberOfCarsToRent) {
                    break;
                }
            }
            if (matcher2.find()) {
                selectCar = matcher2.group(0);
                if (Integer.parseInt(selectCar) > 0 && Integer.parseInt(selectCar) <= numberOfCarsToRent) {
                    break;
                }
            }
            System.out.println("select the correct car");
        }
        return Integer.parseInt(selectCar);
    }
}
