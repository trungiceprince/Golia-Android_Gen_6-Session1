package controllers;

import models.EnemyBullet;
import models.GameConfig;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneController extends SingleController implements Contactable{

    private ControllerManager bulletControllerManager;
    private static final int SPEED = 1;
    private int count = 0;

    public EnemyPlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        bulletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletControllerManager.draw(g);
    }

    @Override
    public void run() {
        count++;
        gameObject.move(0, SPEED);
        bulletControllerManager.run();
        createBullet();
    }
    private void createBullet(){
        if(GameConfig.instance.getSeconds(count) > 0.5) {
            count = 0;
            int x = gameObject.getMiddleX() - EnemyBullet.BULLET_WIDTH / 2;
            int y = gameObject.getY() + EnemyBullet.BULLET_HEIGHT;
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(x, y),
                    new GameView(Utils.loadImageFromRes("enemy_bullet.png"))
            );
            bulletControllerManager.add(enemyBulletController);
        }
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof  BulletController){
            ((BulletController) contactable).destroy();
        }
    }
}
