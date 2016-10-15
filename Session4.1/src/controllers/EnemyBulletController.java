package controllers;

import models.GameObject;
import views.GameView;

/**
 * Created by Admin on 10/14/2016.
 */
public class EnemyBulletController extends SingleController {

    private static final int SPEED = 5;

    public EnemyBulletController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
    }

    public void run(){
        gameObject.move(0,SPEED);
    }
}
