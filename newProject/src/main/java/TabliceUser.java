import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TabliceUser {
    public static int numberOfUser=0;
    public static int numberOfActivatedUsers = 0;
    public static User[] tablicauser= new User[100];
    public static User[] tablicaUserAktywni = new User[100];


    public static User addUser (){
        System.out.println("Add details for new user");
        System.out.println("Enter name:");
        String userName = TabliceSamochody.tryOneMoreTime();
        System.out.println("Enter last name:");
        String userSurname = TabliceSamochody.tryOneMoreTime();
        System.out.println("Enter pesel");
        String pesel =checkPesel();
        return new User(userName,userSurname,pesel);
    }
    public static void addUserToArray(){
        tablicauser[numberOfUser]=addUser();
    }
    public static String checkPesel(){
        Scanner scannerPesel = new Scanner(System.in);
        String pesel="";
        while(true){
        pesel = scannerPesel.nextLine();
        Pattern compile = Pattern.compile("^\\d{11}$");
        Matcher matcher = compile.matcher(pesel);
        if (matcher.find()){
            pesel=matcher.group(0);
            break;
        }
            System.out.println("enter the correct number");
    }
        return pesel;
}
public static void listOfAddedUsers () {
    if (numberOfUser == 0) {
        System.out.println("no added users yet or all users are activated");
    } else {
        for (int i = 0; i < tablicauser.length; i++) {
            if (tablicauser[i] != null) {
                String format = "%d: %s %s. Pesel:%s, birth date: %s. Cars rented so far: %d";
                String wypelniony = String.format(format, i+1, tablicauser[i].getImie(), tablicauser[i].getNazwisko(), tablicauser[i].getPesel(), tablicauser[i].getDateOfBirth().toString(), tablicauser[i].getRentedCars());
                System.out.println(wypelniony);
            }
        }
        System.out.println("Select user to activate");
    }
}
    public static LocalDate parseIntoDate (String pesel){
        String number = pesel;
        String date = number.substring(0,6);
        LocalDate dataSformatowana;
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyMMdd");
        if ((int)number.charAt(0)<51){
            dataSformatowana = LocalDate.parse(date,formater);
        }
        else{
            String nowaData = "19"+date;
            DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("yyyyMMdd");
            dataSformatowana = LocalDate.parse(nowaData,formater2);
        }
        return dataSformatowana;

    }
    public static void addTotablicaAktywnych(){
        Scanner scannerAktywni = new Scanner(System.in);
        int choice = scannerAktywni.nextInt();
        while(!(choice<=TabliceUser.numberOfUser)||choice<1){
            System.out.println("select user from the list");
            choice=scannerAktywni.nextInt();
        }
        for (int i=0; i<tablicaUserAktywni.length;i++){

            if(tablicaUserAktywni[i]==null){
                tablicaUserAktywni[i]=tablicauser[choice-1];
                break;
            }
        }
        User user = tablicauser[choice-1];
        System.out.println(user.getImie() + " " + user.getNazwisko() + " has been activated");
        tablicauser[choice-1]=null;
        numberOfUser--;
        makeTidyArray(tablicauser);
        numberOfActivatedUsers++;
    }
    public static void listOfActivatedUsers(){
        for (int i = 0; i < tablicaUserAktywni.length; i++) {
            if (tablicaUserAktywni[i] != null) {
                String format = "%d: %s %s. Pesel:%s, birth date: %s. Cars rented so far: %d";
                String wypelniony = String.format(format, i+1, tablicaUserAktywni[i].getImie(), tablicaUserAktywni[i].getNazwisko(), tablicaUserAktywni[i].getPesel(), tablicaUserAktywni[i].getDateOfBirth().toString(), tablicaUserAktywni[i].getRentedCars());
                System.out.println(wypelniony);
            }
        }
    }
    public static void makeTidyArray(User[] user){
        for (int i=0; i<user.length-1;i++){
            if (user[i] == null && user[i+1] !=null){
                user[i]=user[i+1];
                user[i+1]=null;
            }
        }
    }

}
