import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car firstCar = new Car ("Opel","Corsa",120000, TabliceSamochody.parseDate("2010-04-13"),80);
        TabliceSamochody.addCarToArray(firstCar);
        Car secondCar = new Car ("Skoda","Fabia",220000, TabliceSamochody.parseDate("2011-07-22"), 200);
        TabliceSamochody.addCarToArray(secondCar);
        menu();
    }
    public static void menu(){
        Scanner scanner = new Scanner(System.in);
        String tekstMenu = "Welcome to car rental. " +
                "\n1. List available cars" +
                "\n2. Edit rental price" +
                "\n3. Add new car" +
                "\n4. List active users" +
                "\n5. Add user" +
                "\n6. Activate a user" +
                "\n7. Rent a car" +
                "\n8. List all rented cars" +
                "\n9. Return a car" +
                "\n10. Display monthly report" +
                "\n11. Display yearly report" +
                "\n12. Display all transactions" +
                "\n13. Exit" +
                "\nChoose your option";
        boolean exit = false;
while (!exit){
        System.out.println(tekstMenu);
       int chooice = scanner.nextInt();
       switch (chooice) {
           case 1:
               if (TabliceSamochody.numberOfCarsToRent == 0) {
                   System.out.println("there is no more cars to rent");
               } else {
                   TabliceSamochody.ListofAvailableCars();
               }
               break;
           case 2:
               TabliceSamochody.editRentalPrice();
               break;
           case 3:
               TabliceSamochody.addCarToArray();
               break;
           case 4:
               if (TabliceUser.numberOfActivatedUsers==0){
                   System.out.println("there are not any activated users");
                   break;
               }
               TabliceUser.listOfActivatedUsers();
               break;
           case 5:
               TabliceUser.addUserToArray();
               break;
           case 6:
               TabliceUser.listOfAddedUsers();
               if (TabliceUser.numberOfUser > 0) {
                   TabliceUser.addTotablicaAktywnych();
               }
               break;
           case 7:
               if (TabliceUser.numberOfActivatedUsers == 0) {
                   System.out.println("there are not any activated users");
               }
               if (TabliceSamochody.numberOfCarsToRent == 0) {
                       System.out.println("there are not any cars to rent");
                   }
                 if (TabliceSamochody.numberOfCarsToRent>0 && TabliceUser.numberOfActivatedUsers>0){
                     TabliceSamochody.rentACar();
                 }
               break;
           case 8:
               if(TabliceSamochody.numberOfRentedCars>0) {
                   TabliceSamochody.listAllRentedCars();
               }
               else {
                   System.out.println("there are not any rented cars");
               }
               break;
           case 9:
               if (TabliceSamochody.numberOfRentedCars==0){
                   System.out.println("there are not any cars to return");
               }
               else {
                   TabliceSamochody.returnACar();
               }
               break;
           case 10:
               TabliceSamochody.displayMonthlyReport();
               break;
           case 11:
               TabliceSamochody.printYearlyRaport();
               break;
           case 12:
               if (TabliceSamochody.transakcje[0]==null){
                   System.out.println("there are not any transactions yet");
               }
               else {
                   TabliceSamochody.transakcionsList();
               }
               break;
           case 13:
               System.out.println("wybrałeś 13");
               exit=true;
               break;
           default:
               System.out.println("podałeś złą liczbę");
       }

    }
}
}
