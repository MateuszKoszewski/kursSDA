package Sesja_samZad8;

import Sesja_SamZad7.Employee;

import java.util.*;
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
        System.out.println(sortList(list));
    }

    public static List<Employee> sortList (List<Employee> list){
        return list.stream().sorted(Comparator.comparing(str -> str.getName())).collect(Collectors.toList());
    }

}