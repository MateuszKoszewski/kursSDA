import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarRental myRental = new CarRental();
        UserRental myUserRental = new UserRental();
        System.out.println("Welcome to car rental. ");
        Scanner scanner = new Scanner(System.in);
        String tekstMenu =
                "1. List available cars" +
                "\n2. Edit rental price" +
                "\n3. Add new car" +
                "\n4. List of users" +
                "\n5. Add user" +
                "\n6. User menu" +
                "\n7. Rent a car" +
                "\n8. List all rented cars" +
                "\n9. Return a car" +
                "\n10. Display monthly report" +
                "\n11. Display yearly report" +
                "\n12. Display all transactions" +
                "\n13. Exit" +
                "\nChoose your option";
        boolean exit = false;

        while (!exit) {
            System.out.println(tekstMenu);
            if (scanner.hasNextInt()) {
                int chooice = scanner.nextInt();
                if (chooice > 0 && chooice <= 13) {
                    switch (chooice) {
                        case 1:
                            System.out.println("you choosed 1. List available cars");
                            myRental.showListOfCars();
                            break;
                        case 2:
                            System.out.println("you choosed 2. Edit rental price");
                            myRental.editRentalPrice();
                            break;
                        case 3:
                            System.out.println("you choosed 3. Add new car");
                            myRental.addNewCar();
                            break;
                        case 4:
                            System.out.println("you choosed 4. List of users ");
                            myUserRental.showListOfUsers();
                            break;
                        case 5:
                            System.out.println("you choosed 5. Add user");
                            myUserRental.addUser();
                            break;
                        case 6:
                            System.out.println("you choosed 6. User menu");
                            myUserRental.setUserAgeMenu();
                            break;
                        case 7:
                            System.out.println("you choosed 7. Rent car");
                            myRental.rentACar(myUserRental);
                            break;
                        case 8:
                            System.out.println("you choosed 8. List all rented cars");
                            myRental.listAllRentedCars();
                            break;
                        case 9:
                            System.out.println("you choosed 9. Return a car");
                            myRental.returnACar();
                            break;
                        case 10:
                            System.out.println("you choosed 10. Display monthly report");
                            myRental.displayMonthlyReport();
                            break;
                        case 11:
                            System.out.println("you choosed 11. Display yearly report");
                            myRental.displayYearlyReport();
                            break;
                        case 12:
                            System.out.println("you choosed 12. Display all transactions");
                            myRental.displayAllTransactions();
                            break;
                        case 13:
                            System.out.println("you choosed 13. Exit");
                            exit = true;
                            break;
                    }
                } else {
                    System.out.println("put the number from the list");
                    scanner.nextLine();
                }
            } else {
                System.out.println("you must put the number");
                scanner.nextLine();
            }
        }
    }

}