package views;
import models.Bullet;
import java.awt.*;

/**
 * Created by Admin on 10/10/2016.
 */
public class BulletView {

//    private Image image;

    public BulletView(Image image) {
        this.image = image;
    }

    private Image image;

    public Image getImage() {
        return image;
    }

    public void draw(Graphics g, Bullet bullet) {
        g.drawImage(image,bullet.getX(),bullet.getY(),bullet.BULLET_WIDTH,bullet.BULLET_HEIGHT,null);
    }
}
