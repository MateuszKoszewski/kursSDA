package Zad9;

import Zad10.MoveDirection;
import Zad10.iMoveable;

public class Point2D implements iMoveable {
    private double x;
    private double y;

    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void move(MoveDirection movedirection) {
        setX(x+movedirection.getX());
        setY(y+movedirection.getY());
    }
}
