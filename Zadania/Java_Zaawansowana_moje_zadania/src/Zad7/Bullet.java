package Zad7;

import java.util.ArrayList;
import java.util.List;

public class Bullet {
    private int bulletsSize;
    private List<String> bullets;

    public Bullet (int bulletsSize){
        this.bulletsSize=bulletsSize;
        bullets = new ArrayList<>();
    }
    public void loadBullet (String bullet){
        if (bullets.size()<bulletsSize){
            bullets.add(bullet);
        }
        else {
            System.out.println("can't load more bullets");
        }
    }
    public boolean isLoaded(){
        return bullets.size() > 0;
    }
    public void shoot(){
        if (isLoaded()){
            System.out.println("boom");
            System.out.println("you shoot bullet " + bullets.get(bullets.size()-1));
            bullets.remove(bullets.size()-1);
        }
        else {
            System.out.println("no more bullets");
        }
    }
}
