package controllers;

import models.EnemyPlane;
import models.GameObject;
import views.GameView;

/**
 * Created by apple on 10/9/16.
 */
public class BulletController extends SingleController {
//    public BulletController(Bullet bullet, GameView bulletView) {
//        this.bullet = bullet;
//        this.bulletView = bulletView;
//    }

    private static final int SPEED = 10;

    public BulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
    }
    @Override
    public void run() {
        gameObject.move(0, -SPEED);
        // fly
    }
    public boolean checkRemove(){
        if (gameObject.getY() < 0)
            return true;
        return false;
    }
//    public void checkPlane(){
//        if(gameObject.getY() = EnemyPlane.)
//    }
//    public void remove(){
//        if(gameObject.getY() < 100){
//            remove();
//        }

}
