package views;

import models.EnemyPlane;

import java.awt.*;

/**
 * Created by Admin on 10/11/2016.
 */
public class EnemyPlaneView {

    private Image image;

    public EnemyPlaneView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g, EnemyPlane enemyPlane){
        g.drawImage(getImage(), enemyPlane.getX(), enemyPlane.getY(),EnemyPlane.ENEMY_PLANE_WIDTH, EnemyPlane.ENEMY_PLANE_HEIGHT, null);
    }
}
