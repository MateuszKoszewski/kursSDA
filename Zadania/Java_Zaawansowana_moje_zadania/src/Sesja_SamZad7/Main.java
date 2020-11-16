package Sesja_SamZad7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
Employee mati = new Employee(1234,"mati",2500);
Employee kamil = new Employee(1235,"kamil",2999);
Employee pawi = new Employee(1236,"pawi",2800);
List<Employee> list = new ArrayList<>();
list.add(mati);
list.add(kamil);
list.add(pawi);
        System.out.println(getEmployee(list).getName());

    }
    public static Employee getEmployee (List<Employee> list){
        Optional <Employee> variable = list.stream().filter(str->str!=null).filter(str -> str.getSalary()>=3000).findFirst();
        if (!variable.isPresent()){
            throw new RuntimeException("no Employee");
        }
        return variable.get();
    }
}
