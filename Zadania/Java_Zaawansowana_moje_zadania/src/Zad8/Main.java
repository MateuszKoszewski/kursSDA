package Zad8;
//Zaimplementuj interfejs
//Validator , który będzie zawierać w swojej deklaracji metodę boolean
//validate(Parcel input) input). Stwórz klasę Parcel z parametrami:
//•
//int xLength
//•
//int yLength
//•
//int zLength
//•
//float weight
//•
//boolean isExpress
//Validator powinien weryfikować czy suma wymiarów (x, y, z) nie przekracza 300, czy każdy z rozmiarów nie
//jest mniejszy niż 30, czy waga nie przekracza 30.0 dla isExpress=false lub 15.0 dla isExpress=true. W
//przypadku błędów, powinien o nich poinformować użytkownika.
public class Main {
    public static void main(String[] args) {
        Validator validator = new Validator();
        Parcel parcel = new Parcel (15,15,18,25,false);
        validator.validate(parcel);
    }
}
