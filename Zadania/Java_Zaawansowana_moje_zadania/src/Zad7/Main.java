package Zad7;
//Stwórz klasę imitującą magazynek do broni. Klasa powinna mieć możliwość definiowania rozmiaru
//magazynka za pomocą konstruktora. Zaimplementuj metody:
//loadBullet(String bullet)
//→ dodawanie naboju do magazynka, nie pozwala załadować więcej
//naboi niż wynosi pojemność magazynka
//isLoaded()
//→ zwraca informację o tym czy broń jest naładowana (przynajmniej jeden nabój) czy
//nie
//shot()
//→ jedno wywołanie wystrzeliwuje (wypisuje w konsoli wartość string) jeden ostatni
//załadowany nabój i przygotowuje kolejny, załadowany przed ostatnim, jeżeli nie ma więcej nabojów to
//wypisuje w konsoli “pusty magazynek”
public class Main {
    public static void main(String[] args) {
        Bullet bullet = new Bullet(6);
        bullet.shoot();
        bullet.loadBullet("pierwszy nabój");
        bullet.loadBullet("drugi nabój");
        bullet.shoot();
        bullet.shoot();
        bullet.shoot();



    }
}
