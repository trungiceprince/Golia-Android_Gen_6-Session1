package controllers;
import models.GameObject;

import models.EnemyPlane;
import utils.Utils;
import views.GameView;

/**
 * Created by Admin on 10/14/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager{

    public EnemyPlaneControllerManager() {
        super();

        for(int i = 0; i < 10; i++) {
            int y = 60;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneControlller = new EnemyPlaneController(
                    new EnemyPlane(x,y),
                    new GameView(Utils.loadImageFromRes("plane1.png"))
            );
            singleControllers.add(enemyPlaneControlller);
        }
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < singleControllers.size(); i++) {
            if (singleControllers.get(i).gameObject.getY() >= 400) {
                singleControllers.remove(i);
            }
            for(int j = 0 ; j < PlaneController.bulletControllers.size(); j++){
                BulletController bulletController = PlaneController.bulletControllers.get(j);
                if(bulletController.gameObject.getY() <= singleControllers.get(i).gameObject.getY() + singleControllers.get(i).gameObject.getHeight()
                        && bulletController.gameObject.getX()>= singleControllers.get(i).gameObject.getX()
                        && bulletController.gameObject.getX()<= singleControllers.get(i).gameObject.getX() +singleControllers.get(i).gameObject.getWidth()){
                    singleControllers.remove(i);
                    System.out.println("ssss");
                    PlaneController.bulletControllers.remove(j);
                }
            }
        }
    }
}
