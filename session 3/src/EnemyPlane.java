import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 10/9/2016.
 */
public class EnemyPlane {
    public static final int ENEMY_WIDTH = 50;
    public static final int ENEMY_HEIGHT = 30;
    private int x;
    private  int y;
    private Image image;

    public ArrayList<Bullet> EButllet = new ArrayList<>();

    public EnemyPlane(int x, int y, Image image){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public ArrayList<Bullet> getEButllet() {
        return EButllet;
    }
    public void move(){
        y += 1;
    }
    public void addEBullet(){
        Bullet bullet = null;
        try {
            bullet = new Bullet(x + ENEMY_WIDTH/2 - Bullet.BULLET_WIDTH /2, y + ENEMY_HEIGHT, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        EButllet.add(bullet);
    }
    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, ENEMY_WIDTH, ENEMY_HEIGHT, null);
    }
//    public int n = 0;
//    public void update(){
//        try {
//            Thread.sleep(17);
////            n++;
//            addEBullet();
//            for(int i = 0; i <EButllet.size(); i++){
//                getEButllet().get(i).e_fly();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
    public void update(){
        addEBullet();
        for(int i = 0; i <EButllet.size(); i++){
            getEButllet().get(i).e_fly();
        }
    }
}
