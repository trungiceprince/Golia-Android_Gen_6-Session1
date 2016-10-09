import java.awt.*;

/**
 * Created by Admin on 10/4/2016.
 */
public class Bullet {
    public static final int BULLET_WIDTH = 13;
    public static final int BULLET_HEIGHT = 30;
    public static final double SPEED = 10;

//    public static boolean keyShotting = false;

    private int x;
    private  int y;
    private Image image;

    public Bullet(int x, int y, Image image){
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void shot(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    public  void  drawImage(Graphics g){

        g.drawImage(image,x,y,BULLET_WIDTH,BULLET_HEIGHT,null);
    }
    public void fly(){

        y -= SPEED;
    }
    public void e_fly(){
        y += 1;
    }


//    public void drawImage() {
//        drawImage();
//    }
}
