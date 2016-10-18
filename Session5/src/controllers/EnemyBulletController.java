package controllers;

import models.GameObject;
import views.GameView;

/**
 * Created by Admin on 10/18/2016.
 */
public class EnemyBulletController extends SingleController implements Contactable {
    private static int SPEED = 10;
    public EnemyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof PlaneController){
            ((PlaneController) contactable).getShot();
        }
    }

    @Override
    public void run() {
        gameObject.move(0, SPEED);
    }
}
