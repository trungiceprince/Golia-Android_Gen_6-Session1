package controllers;

import models.EnemyBullet;
import views.EnemyBulletView;


import java.awt.*;

/**
 * Created by Admin on 10/11/2016.
 */
public class EnemyBulletController {
    private EnemyBullet enemyBullet;
    private EnemyBulletView enemyBulletView;

    private int x;
    private int y;
    private static final int SPEED = 5;

    public EnemyBulletController(EnemyBullet enemyBullet, EnemyBulletView enemyBulletView) {
        this.enemyBullet = enemyBullet;
        this.enemyBulletView = enemyBulletView;
    }

    public void draw(Graphics g){
        enemyBulletView.draw(g,enemyBullet);
    }

    public void run(){
        enemyBullet.fly();
    }
}
