package Zad15;

public enum Car {
    FERRARI(890000,700,380),
    PORSCHE(500000, 560, 340),
    MERCEDES(650000, 620, 360),
    BMW(480000, 380, 320),
    OPEL(220000, 330, 300),
    FIAT(140000, 160, 250),
    TOYOTA(230000, 250, 280);

    private double price;
    private int power;
    private Integer maxSpeed;

    Car (double price, int power, Integer maxSpeed){
     this.price = price;
     this.power=power;
     this.maxSpeed=maxSpeed;
    }
    boolean isPremium(){
        return this == FERRARI || this == PORSCHE || this == MERCEDES || this == BMW;
    }
    boolean isRegular(){
        return !isPremium();
    }
    boolean isFasterThan(Car car){
        return this.maxSpeed.compareTo(car.maxSpeed)>0;
    }
}
