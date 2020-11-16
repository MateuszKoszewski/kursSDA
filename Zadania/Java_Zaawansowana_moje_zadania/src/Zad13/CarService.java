package Zad13;

import Zad12.Car;
import Zad12.Engine;
import Zad12.Manufacturer;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarService <K> {
    private List<Car> list;

    public CarService(){
        list = new ArrayList<>();
    }

    public void addCar(Car car){
        list.add(car);
    }
    public void removeCar(Car car){
        list.remove(car);
    }
    public List<Car> getList(){
        return list;
    }
    public List<Car> getV12Cars(){
        return list.stream().filter(str -> str.getEngine().equals(Engine.V12)).collect(Collectors.toList());
    }
    public List<Car> getCarsProducedBefore1999(){
        return list.stream().filter(str -> str.getProductionYear()<1999).collect(Collectors.toList());
    }
    public Car getTheMostExpensiveCar(){
        return list.stream().max(Comparator.comparing(car-> car.getPrice())).get();
    }
    public Car getTheCheapestCar(){
        return list.stream().min(Comparator.comparing(car -> car.getPrice())).get();
    }
public List<Car> sortCars (Sorting sorting, MaxOrMin maxormin){
        return list.stream().sorted(function2.apply(sorting, maxormin)).collect(Collectors.toList());
}

    private BiFunction  <Sorting, MaxOrMin, Comparator<Car>> function2 = (sorting, maxOrMin) -> maxOrMin==MaxOrMin.rosnaco ? getItem(sorting) : getItem(sorting).reversed();


    public Comparator <Car> getItem (Sorting sorting){
        switch (sorting) {
            case price:
return Comparator.comparing(str -> str.getPrice());
            case name:
return Comparator.comparing(str -> str.getName());
            case productionYear:
                return Comparator.comparing(str -> str.getProductionYear());
            case model:
                return Comparator.comparing(str -> str.getModel());
            case engine:
                return Comparator.comparing(str -> str.getEngine());
        }

        return null;
}
public boolean IsCarOnTheList (Car car){
        return list.contains(car);
}
public List<Car> getListOfManufacturer(Manufacturer manufacturer){
        return list.stream().filter(str -> str.getManufacturer().equals(manufacturer)).collect(Collectors.toList());
}
public List<Car> getListOfCarsProduced (int productionYear, Conditions conditions){
        return list.stream().filter(getCondition(productionYear,conditions)).collect(Collectors.toList());
}
private int getIntFromDate (LocalDate localdate){
        return localdate.getYear();
}

private Predicate <Car> getCondition (int productionYear, Conditions conditions){
        switch (conditions){
            case lower:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())<productionYear;
            case higher:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())>productionYear;
            case lowerOrEquals:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())<=productionYear;
            case higherOrEquals:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())>=productionYear;
            case different:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())!=productionYear;
            case Equals:
                return str -> getIntFromDate(str.getManufacturer().getDateOfProduction())==productionYear;
        }
        return null;
}
}
