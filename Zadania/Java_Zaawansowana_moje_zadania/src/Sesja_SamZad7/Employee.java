package Sesja_SamZad7;

import java.util.List;

public class Employee {
    private int Id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        Id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
