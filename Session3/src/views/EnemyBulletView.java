package views;

import models.EnemyBullet;

import java.awt.*;

/**
 * Created by Admin on 10/11/2016.
 */
public class EnemyBulletView {
    private Image image;

    public EnemyBulletView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
    public void draw(Graphics g, EnemyBullet enemyBullet){
        g.drawImage(getImage(), enemyBullet.getX(), enemyBullet.getY(), EnemyBullet.BULLET_WIDTH, EnemyBullet.BULLET_HEIGHT, null);
    }
}
