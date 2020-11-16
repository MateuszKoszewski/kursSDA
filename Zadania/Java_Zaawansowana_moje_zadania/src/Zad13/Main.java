package Zad13;

import Zad12.Car;
import Zad12.Engine;
import Zad12.Manufacturer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Manufacturer bmwMan = new Manufacturer("bmw", LocalDate.of(1943,8,24),"Germany");
        Manufacturer toyotaMan = new Manufacturer("toyota", LocalDate.of(1967,4,25),"Japan");
        Manufacturer VWMan = new Manufacturer("VW",LocalDate.of(1954,3,8),"Germany");
        Manufacturer hondaMan = new Manufacturer("honda", LocalDate.of(1965,4,17),"Japan");

        Car bmw = new Car("bmw","e46",25000,2005,bmwMan, Engine.V12);
        Car toyota = new Car("toyota","corolla",23000,2008,toyotaMan,Engine.S3);
        Car seat = new Car ("seat","toledo",6000,2002,VWMan,Engine.S6);
        Car honda = new Car ("honda","civic",13000, 2007,hondaMan,Engine.V12);
        Car auris = new Car("toyota auris", "auris", 17000, 2009, toyotaMan, Engine.V6);
        CarService carService = new CarService();
        carService.addCar(bmw);
        carService.addCar(toyota);
        carService.addCar(seat);
        carService.addCar(honda);
        carService.addCar(auris);
        System.out.println(carService.getTheMostExpensiveCar().getName());
        System.out.println(carService.sortCars(Sorting.engine, MaxOrMin.malejaco));
        System.out.println(carService.getListOfManufacturer(toyotaMan));
        System.out.println(carService.getListOfCarsProduced(1954,Conditions.lowerOrEquals));
    }
}
