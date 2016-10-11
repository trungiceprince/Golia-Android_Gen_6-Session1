package controllers;

import models.Bullet;
import views.BulletView;

import java.awt.*;

/**
 * Created by Admin on 10/9/2016.
 */
public class BulletController {
    private Bullet bullet;
    private BulletView bulletView;

    private int x;
    private int y;
    private static final int SPEED = 10;

    public BulletController(Bullet bullet, BulletView bulletView) {
        this.bullet = bullet;
        this.bulletView = bulletView;
    }

    public void draw(Graphics g){
        bulletView.draw(g,bullet);
    }
    public void run(){
        bullet.fly();
    }
}
