package Zad9;
//Stwórz klasę
//Point 2 D posiadającą pola double x , double y , gettery, settery oraz konstruktor. Następnie
//stwórz klasę Circle , która będzie miała
//Circle
//(Point 2 D center , Point 2 D point)
//Pierwszy parametr określa środek koła, drugi jest dowolnym punktem na okręgu. Na podstawie tych
//punktów, klasa Circle ma określać:
//•
//promień okręgu przy wywołaniu metody double getRadius
//•
//obwód okręgu przy wywołaniu metody double getPerimeter
//•
//pole okręgu przy wywołaniu metody double getArea
//•
//•*(trudniejsze) trzy punkty na okręgu co 90 stopni od punktu podanego przy wywołaniu metody
//List<Point 2 D> getSlicePoints
public class Main {
    public static void main(String[] args) {
        Point2D pierwszy = new Point2D(2,1);
        Point2D drugi = new Point2D(3,4);
        Circle circle = new Circle(pierwszy,drugi);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());
        circle.resize(0.1);
        System.out.println(circle.getRadius());
        System.out.println(circle.getArea());

    }
}
