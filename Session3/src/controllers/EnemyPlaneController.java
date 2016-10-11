package controllers;

import models.EnemyPlane;
import views.EnemyPlaneView;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Admin on 10/11/2016.
 */
public class EnemyPlaneController {
    private EnemyPlane enemyPlane;
    private EnemyPlaneView enemyPlaneView;
    private Vector<EnemyBulletController> enemyBulletControllerVector;



    public EnemyPlaneController(EnemyPlane enemyPlane, EnemyPlaneView enemyPlaneView) {
        this.enemyPlane = enemyPlane;
        this.enemyPlaneView = enemyPlaneView;
        enemyBulletControllerVector = new Vector<>();

    }

    public Vector<EnemyBulletController> getEnemyBulletControllerVector() {
        return enemyBulletControllerVector;
    }

    public EnemyPlane getEnemyPlane() {
        return enemyPlane;
    }

    public void run(){
        enemyPlane.fly();
        for (EnemyBulletController enemyBulletController : enemyBulletControllerVector) {
            enemyBulletController.run();
        }

    }

    public void draw(Graphics g){
        enemyPlaneView.drawImage(g,enemyPlane);
        for(EnemyBulletController enemyBulletController : enemyBulletControllerVector){
            enemyBulletController.draw(g);
        }
    }
}
