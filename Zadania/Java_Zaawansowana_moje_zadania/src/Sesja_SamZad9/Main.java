package Sesja_SamZad9;

import Sesja_SamZad7.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Employee mati = new Employee(1234,"mati",2500);
        Employee kamil = new Employee(1235,"kamil",3999);
        Employee pawi = new Employee(1236,"pawi",2800);
        List<Employee> list = new ArrayList<>();
        list.add(mati);
        list.add(kamil);
        list.add(pawi);
        System.out.println("getMaxSalary(list) = " + getMaxSalary(list));
    }
    //SPOSÓB 1
//public static double getMaxSalary (List<Employee> list){
//        return list.stream().sorted(Comparator.comparing(str -> str.getSalary())).collect(Collectors.toList()).get(list.size()-1).getSalary();
//}
//     SPOSÓB 2
public static double getMaxSalary (List<Employee> list){
    return list.stream().map(str -> str.getSalary()).max(Comparator.naturalOrder()).orElseThrow(()->new RuntimeException("no epmloyee"));
}

    // SPOSÓB 3
//    public static double getMaxSalary (List<Employee> list){
//        return list.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList()).get(0).getSalary();
//    }
    // SPOSÓB 4
//    public static double getMaxSalary (List<Employee> list){
//        return list.stream().sorted(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return (int)o2.getSalary()-(int)o1.getSalary();
//            }
//        }).collect(Collectors.toList()).get(0).getSalary();
//    }

}