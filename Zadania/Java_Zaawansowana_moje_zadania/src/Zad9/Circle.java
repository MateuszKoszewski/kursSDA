package Zad9;

import Zad10.MoveDirection;
import Zad10.iMoveable;
import Zad11.Resizable;

public class Circle implements iMoveable, Resizable {
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }
    public double getRadius() {
        return Math.sqrt(Math.pow((center.getX() - point.getX()), 2) + Math.pow(center.getY() - point.getY(), 2));
    }

    public double getPerimeter() {

        return Math.PI * 2 * getRadius();
    }


    public double getArea() {

        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public void move(MoveDirection movedirection) {
        center.setX(center.getX()+movedirection.getX());
        center.setY(center.getY()+movedirection.getY());
        point.setX(point.getX()+movedirection.getX());
        point.setY(point.getY()+movedirection.getY());
    }

    @Override
    public void resize(double resizeFactor) {
        if (resizeFactor<=0){
            System.out.println("wrong value");
        }
        else {
            point.setX(center.getX() + (point.getX()-center.getX())*resizeFactor);
            point.setY(center.getY() + (point.getY() - center.getY())*resizeFactor);
        }
    }
}
