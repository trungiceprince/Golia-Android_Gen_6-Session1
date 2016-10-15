package controllers;

import models.EnemyBullet;
import models.EnemyPlane;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Admin on 10/14/2016.
 */
public class EnemyPlaneController extends SingleController {
    private Vector<EnemyBulletController> enemyBulletControllers;
    public static final int CD = 50;
    private int count = 50;

    private static final int SPEED = 2;

    public EnemyPlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        enemyBulletControllers = new Vector<>();
    }

    @Override
    public void draw(Graphics g) {
         super.draw(g);
        for(int i = 0; i < enemyBulletControllers.size() ; i++){
            enemyBulletControllers.get(i).draw(g);
        }
//        for(EnemyBulletController enemyBulletController : enemyBulletControllers){
//            enemyBulletController.draw(g);
//        }
    }
    public void createEnemyBullet(){
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new EnemyPlane(
                        gameObject.getMiddleX() - EnemyBullet.BULLET_WIDTH / 2,
                        gameObject.getHeight() + gameObject.getY()
                ),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png"))
        );
        enemyBulletControllers.add(enemyBulletController);

    }

    @Override
    public void run() {
//        for (int i = 0 ; i < singleControllers.size(); i++) {
//            if (singleControllers.get(i).gameObject.getY() >= 300) {
//                singleControllers.remove(i);
//            }
//            for(int j = 0 ; j < PlaneController.bulletControllers.size(); j++){
//                BulletController bulletController = PlaneController.bulletControllers.get(j);
//                if(bulletController.gameObject.getY() <= singleControllers.get(i).gameObject.getY() + singleControllers.get(i).gameObject.getHeight()
//                        && bulletController.gameObject.getX()>= singleControllers.get(i).gameObject.getX()
//                        && bulletController.gameObject.getX()<= singleControllers.get(i).gameObject.getX() +singleControllers.get(i).gameObject.getWidth()){
//                    singleControllers.remove(i);
//                    PlaneController.bulletControllers.remove(j);
//                }
//            }
//        }
//        super.run();
        if (count >= CD) {
            count = 0;
            createEnemyBullet();
        }
        count++;
        for(EnemyBulletController enemyBulletController : enemyBulletControllers){
            enemyBulletController.run();
        }
        gameObject.move(0,SPEED);
    }
}
