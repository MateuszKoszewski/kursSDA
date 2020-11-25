import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CarRental {
    private final List<Car> availableCars;
    private final List<Transactions> transactions;
    private List<Transactions> rentedCars;

    public CarRental() {
        this.availableCars = new ArrayList<>();
        availableCars.add(new Car("Toyota", "Corolla", 2005, 140, 220000));
        availableCars.add(new Car("Honda", "Civic", 2007, 110, 205670));
        transactions = new ArrayList<>();
       rentedCars = new ArrayList<>();
    }

    public void showListOfCars() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < availableCars.size(); i++) {
            System.out.println(i + 1 + ". " + availableCars.get(i));
        }
        System.out.println();
        sortingCars();
    }

    public void editRentalPrice() {
        System.out.println("which car price would you like to change");
        showListOfCars();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice > 0 && choice <= availableCars.size()) {
                    System.out.println("set your price for " + availableCars.get(choice - 1).getBrand() + " " + availableCars.get(choice - 1).getModel());
                    availableCars.get(choice - 1).setPrice(validatePrice());
                    break;
                } else {
                    System.out.println("choose the car from the list");
                }

            } else {
                System.out.println("put the number of car from the list above");
                scanner.nextLine();
            }
        }
    }

    public void addNewCar() {
        System.out.println("Specify Brand of the car");
        String brand = StaticMethods.StringIsNotBlank();
        System.out.println("Specify Model of the car");
        String model = StaticMethods.StringIsNotBlank();
        System.out.println("Specify Production year of the car");
        int productionYear = validateProductionYear();
        System.out.println("Specify Price of the car");
        double price = validatePrice();
        System.out.println("Specify Course of the car");
        int course = validateCourse();
        Car newCar = new Car(brand, model, productionYear, price, course);
        if (!availableCars.contains(newCar)) {
            availableCars.add(newCar);
        } else {
            System.out.println("car already exists");
        }
    }

    private double validatePrice() {
        return StaticMethods.checkConditions(price -> price > 0, "price must be > 0", "put the correct price");
    }


    private int validateProductionYear() {
        return (int) StaticMethods.checkConditions(productionYear -> productionYear > 1950 && productionYear <= 2020, "production year must be greater than 1950 and less than 2020", "put the correct production year");
    }


    private int validateCourse() {
        return (int) StaticMethods.checkConditions(course -> course > 0 && course < 350000, "Too high course to add the Car", "put the correct course");
    }

    public void rentACar(UserRental userRental) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("select User");
        StaticMethods.printList(userRental.getAvailableUsers());
        int choiceOfUser = (int) StaticMethods.checkConditions(variable -> variable > 0 && variable <= userRental.getAvailableUsers().size(), "Choose user from the list", "put the correct value");
        User choosedUser = userRental.getAvailableUsers().get(choiceOfUser - 1);

        System.out.println("select Car");
        StaticMethods.printList(availableCars);
        int choiceOfCar = (int) StaticMethods.checkConditions(variable -> variable > 0 && variable <= availableCars.size(), "Choose car from the list", "put the correct value");
        Car rentedCar = availableCars.get(choiceOfCar - 1);

        System.out.println("your choice is " + availableCars.get(choiceOfCar - 1).getBrand());
        System.out.println("for how many days?");
        int choiceOfDays = (int) StaticMethods.checkConditions((variable -> variable > 0), "number of days must be >0", "put the correct value");
        double price = choiceOfDays * rentedCar.getPrice();
        System.out.println("The rent will cost " + price + ". Are you sure? yes/no");
        String agreedOrNot = scanner.nextLine();
        if (agreedOrNot.toLowerCase().equals("yes") || agreedOrNot.toLowerCase().equals("y")) {
            choosedUser.getRentedCars().add(rentedCar);
            transactions.add(new Transactions(price, choosedUser, rentedCar, choiceOfDays, LocalDate.now()));
            rentedCars.add(new Transactions(price, choosedUser, rentedCar, choiceOfDays, LocalDate.now()));
            availableCars.remove(rentedCar);
        } else if (agreedOrNot.toLowerCase().equals("no") || agreedOrNot.toLowerCase().equals("n")) {

        } else {
            System.out.println("you must enter yes or no");
        }

    }

    public void listAllRentedCars() {
        showCarsToReturn(rentedCars);
    }

    private void showSortingOptions() {
        System.out.println("Sort by" +
                "\n1. Brand" +
                "\n2. Model" +
                "\n3. Production Year" +
                "\n4. Price" +
                "\n5. Mileage");
    }

    private Comparator<Car> chooseSortingOption() {
        int chooice = (int) StaticMethods.checkConditions(choose -> choose > 0 && choose <= 5, "choose option from the list", "put the correct value");
        switch (chooice) {
            case 1:
                return Comparator.comparing(Car::getBrand);
            case 2:
                return Comparator.comparing(Car::getModel);
            case 3:
                return Comparator.comparing(Car::getProductionYear);
            case 4:
                return Comparator.comparing(Car::getPrice);
            case 5:
                return Comparator.comparing(Car::getCourse);
            default:
                return null;
        }
    }

    private void sortingCars() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to sort this list ? yes/no");
        System.out.println();
        while (true) {
            String agreedOrNot = scanner.nextLine();
            if (agreedOrNot.toLowerCase().equals("yes") || agreedOrNot.toLowerCase().equals("y")) {
                showSortingOptions();
                Comparator<Car> choosedComparator = chooseSortingOption();
                System.out.println("How do you want to sort?" +
                        "\n1. ascending" +
                        "\n2. descending");
                int wayOfSorting = (int) StaticMethods.checkConditions(value -> value > 0 && value <= 2, "choose option from the list", "put the correct value");
                Comparator<Car> toSort = (Comparator<Car>) StaticMethods.function.apply(wayOfSorting, choosedComparator);
                List<Car> sortedList = availableCars.stream().sorted(toSort).collect(Collectors.toList());
                StaticMethods.printList(sortedList);
                break;
            } else if (agreedOrNot.toLowerCase().equals("no") || agreedOrNot.toLowerCase().equals("n")) {
                break;
            } else {
                System.out.println("put the correct value");
            }

        }
    }
    public void returnACar (){
        System.out.println("Which car would you like to return?");
        System.out.println();
listAllRentedCars();
int chooice = (int)StaticMethods.checkConditions(choose -> choose>0 && choose<=rentedCars.size(),"choose the option from the list", "put the correct value");
Car returnedCar = rentedCars.get(chooice-1).getCar();
availableCars.add(returnedCar);
User choosedUser = rentedCars.get(chooice-1).getUser();
choosedUser.getRentedCars().remove(returnedCar);
Transactions transactionToRemove = rentedCars.stream().filter(transactions -> transactions.getCar().equals(returnedCar)).findFirst().orElseThrow(()-> new NullPointerException("Couldn't find car that you returned"));
rentedCars.remove(transactionToRemove);
    }
    public void displayAllTransactions(){
showCarsToReturn(transactions);

    }
    private void showCarsToReturn(List<Transactions> list){
        String format = "%d. %s %s - %s %s, time of rental: %d days, price: %.2f";
        for (int i = 0; i < list.size(); i++) {
            String positionInList = String.format(format, i + 1, list.get(i).getUser().getName(), list.get(i).getUser().getLast_name(), list.get(i).getCar().getBrand(), list.get(i).getCar().getModel(), list.get(i).getDays(), list.get(i).getPrice());
            System.out.println(positionInList);
        }
    }
    public void displayMonthlyReport(){
        System.out.println("enter number of month");
        int month = (int)StaticMethods.checkConditions(months -> months>0 && months<=12, "put the correct number of month","you must put the number");
        System.out.println("Here is monthly report for " + chooseMonth(month));
        countMonthlyReport(month);
    }

    public void displayYearlyReport(){
        System.out.println("Here is Yearly Report for " + LocalDate.now().getYear());
        for (int i=1; i<=12; i++){
            countMonthlyReport(i);
        }
    }
    private String chooseMonth(int month){
        switch(month){
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
                return "bad month";
        }
    }
    private void countMonthlyReport(int month){
        String choosedMonth = chooseMonth(month);
        List <Transactions> listInChoosedMonth = transactions.stream().filter(transaction -> transaction.getDate().getMonth().getValue()==month).collect(Collectors.toList());
//        double value = listInChoosedMonth.stream().reduce(0,(input, output) -> output.getPrice() + input.getPrice());
        double summary = listInChoosedMonth.stream().mapToDouble(Transactions::getPrice).sum();
        System.out.println("Earnings for " + choosedMonth + ": " + "Total number of rentals: " + listInChoosedMonth.size() + ". Income: " + summary);
    }
}


