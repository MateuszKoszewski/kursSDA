import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserRental {
    private List<User> availableUsers;
    private int maxUserAge;
    private int minUserAge;

    public UserRental() {
        availableUsers = new ArrayList<>();
        maxUserAge = 80;
        minUserAge = 18;
    }

    public void addUser() {
        System.out.println("Specify name of the user");
        String name = StaticMethods.StringIsNotBlank();
        System.out.println("Specify last name of the user");
        String lastName = StaticMethods.StringIsNotBlank();
        System.out.println("Specify ID number of the user");
        String ID = IDNumberValidation();
        if (ID != null) {
            User newUser = new User(name, lastName, ID);
            if (availableUsers.contains(newUser)) {
                System.out.println("User already exists");
            }  else {
                availableUsers.add(newUser);
            }
        }
    }

    private String IDNumberValidation() {
        Scanner scanner = new Scanner(System.in);
        String pesel = "";
        while (true) {
            pesel = scanner.nextLine();
            Pattern compile = Pattern.compile("^\\d{11}$");
            Matcher matcher = compile.matcher(pesel);
            if (matcher.find()) {
                pesel = matcher.group(0);
                if (Integer.parseInt(pesel.substring(2,4)) >12){
                    System.out.println("wrong month number");
                    break;
                }
                else if (Integer.parseInt(pesel.substring(4,6))>31){
                    System.out.println("wrong day number");
                    break;
                }
                int userAge = LocalDate.now().getYear() - StaticMethods.parseIntoDate(pesel).getYear();
                if (userAge >= minUserAge && userAge <= maxUserAge) {
                    return pesel;
                } else if (userAge > 100) {
                    System.out.println("Are you sure? invalid year of birth");
                } else {
                    System.out.println("User is too young or too old to rent a car");
                    break;
                }
            } else {
                System.out.println("put the correct number");
            }
        }
        return null;
    }

    public void setUserAgeMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean enter = false;
        while (!enter) {
            System.out.println("The minimum user age is " + minUserAge + " and maximum user age is " + maxUserAge +
                    "\n1. Set minimum User age " +
                    "\n2. Set maximum User age" +
                    "\n3. Check how many users don't match new requirments" +
                    "\n4. Go to previous menu");
            if (scanner.hasNextInt()) {
                int chooice = scanner.nextInt();
                if (chooice >= 1 && chooice <= 4) {
                    switch (chooice) {
                        case 1:
                            System.out.println("put the minimum age you want to set");
                            int minAge = (int) StaticMethods.checkConditions(minimumAge -> minimumAge > 0 && minimumAge < maxUserAge, "put the correct age", "invalid value");
                            setMinUserAge(minAge);
                            System.out.println("minimum age of user is set to " + minAge);

                            break;
                        case 2:
                            System.out.println("put the maximum age you want to set");
                            int maxAge = (int) StaticMethods.checkConditions(maximumAge -> maximumAge > 0 && maximumAge > minUserAge, "put the correct age", "invalid value");
                            setMaxUserAge(maxAge);
                            System.out.println("maximum age of user is set to " + maxAge);
                            break;
                        case 3:
                            StaticMethods.printList(checkListByNewAge());
                            System.out.println("Do you want to remove these users from the list? yes or no ?");
                            removeOrNot();
                        case 4:
                            enter = true;
                            break;
                    }
                } else {
                    System.out.println("choose option from the list");
                    scanner.nextLine();
                }
            } else {
                System.out.println("put the correct value");
                scanner.nextLine();
            }
        }

    }

    private List<User> checkListByNewAge() {
        return availableUsers.stream().filter(user -> user.getAge() < minUserAge || user.getAge() > maxUserAge).collect(Collectors.toList());
    }

    private void setMaxUserAge(int maxUserAge) {
        this.maxUserAge = maxUserAge;
    }

    private void setMinUserAge(int minUserAge) {
        this.minUserAge = minUserAge;
    }

    public int getMaxUserAge() {
        return maxUserAge;
    }

    public int getMinUserAge() {
        return minUserAge;
    }

    public List<User> getAvailableUsers() {
        return availableUsers;
    }

    private void removeOrNot() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String chooice = scanner.nextLine();
            if (chooice.toLowerCase().equals("yes") || chooice.toLowerCase().equals("y")) {
                for (int i = 0; i < checkListByNewAge().size(); i++) {
                    if (availableUsers.contains(checkListByNewAge().get(i))) {
                        availableUsers.remove(i);
                    }
                }
                break;

            } else if (chooice.toLowerCase().equals("no") || chooice.toLowerCase().equals("n")) {
                break;
            } else {
                System.out.println("put the correct value");
            }
        }
    }
    public void showListOfUsers (){
        StaticMethods.printList(availableUsers);
        System.out.println();
        sortingUsers();

    }
    private void showSortingOptions(){
        System.out.println("Sort By" +
                "\n1. Name" +
                "\n2. Last name" +
                "\n3. Age" +
                "\n4. Number of rented cars");
    }
    private Comparator<User> chooseSortingOption() {
        int chooice = (int) StaticMethods.checkConditions(choose -> choose > 0 && choose <= 4, "choose option from the list", "put the correct value");
        switch (chooice) {
            case 1:
                return Comparator.comparing(User::getName);
            case 2:
                return Comparator.comparing(User::getLast_name);
            case 3:
                return Comparator.comparing(User::getAge);
            case 4:
                return Comparator.comparing(user -> user.getRentedCars().size());
            default:
                return null;
        }
    }
    private void sortingUsers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to sort this list ? yes/no");
        System.out.println();
        while (true) {
            String agreedOrNot = scanner.nextLine();
            if (agreedOrNot.toLowerCase().equals("yes") || agreedOrNot.toLowerCase().equals("y")) {
                showSortingOptions();
                Comparator<User> choosedComparator = chooseSortingOption();
                System.out.println("How do you want to sort?" +
                        "\n1. ascending" +
                        "\n2. descending");
                int wayOfSorting = (int) StaticMethods.checkConditions(value -> value > 0 && value <= 2, "choose option from the list", "put the correct value");
                Comparator<User> toSort = (Comparator<User>) StaticMethods.function.apply(wayOfSorting, choosedComparator);
                List<User> sortedList = availableUsers.stream().sorted(toSort).collect(Collectors.toList());
                StaticMethods.printList(sortedList);
                break;
            } else if (agreedOrNot.toLowerCase().equals("no") || agreedOrNot.toLowerCase().equals("n")) {
                break;
            } else {
                System.out.println("put the correct value");
            }

        }
    }
}
