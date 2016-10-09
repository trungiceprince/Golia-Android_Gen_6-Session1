import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Admin on 10/4/2016.
 */
public class Plane {

    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 40;

    //        Bullet bullet;    // tạo 1 mảng bullet                                  // khai bao bullet la kieu cua Bullet co dang class
    private int X;                                      // khai bao toa do x cua may bay
    private int Y;                                      // khai bao toa do y cua may bay
    private Image image;
    public  int n = 0;
    private ArrayList<Bullet> bullets = new ArrayList<>();
    // khai bao hinh anh kieu Image
    Bullet bullet;                                      // khai bao bullet la kieu cua Bullet co dang class

    public Plane(int X, int Y, Image image){
        this.X = X;
        this.Y = Y;
        this.image = image;
    }

    public int getX(){
        return X;
    }
    public  int getY(){
        return Y;
    }

    private void addBullet(){                  // hàm này tạo ra 1 new Bullet rồi add vào arraylist
        Bullet bullet = null;
        try {
            bullet = new Bullet(X + PLANE_WIDTH /2 - Bullet.BULLET_WIDTH/2, PLANE_HEIGHT, ImageIO.read(new File("resources/bullet.png")));
            bullet.shot((X + PLANE_WIDTH / 2 - bullet.BULLET_WIDTH / 2), Y);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        bullets.add(bullet); // vậy là cứ sau 1 ;ần kich chuột thì add thêm 1 viên
    }
    private ArrayList<Bullet> getBullets(){
        return bullets;
    }


    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch (e.getKeyCode()) {
         case KeyEvent.VK_RIGHT:
            X += 10;
            break;
         case KeyEvent.VK_LEFT:
            X -= 10;
            break;
         case KeyEvent.VK_UP:
            Y -= 10;
            break;
         case KeyEvent.VK_DOWN:
            Y += 10;
            break;
         case KeyEvent.VK_SPACE:
            addBullet();
            n++;
            System.out.println(n);
            break;

         }


     }
    public void mouseMoved(MouseEvent mouseEvent) {
        X  = mouseEvent.getX() - PLANE_WIDTH/2 ;
        Y  = mouseEvent.getY() - PLANE_HEIGHT/2;
    }

    public  void mousePressed(){ // thì mình tạo ra bullet ở đây
        addBullet();

    }

    public void drawImage(Graphics g){
        g.drawImage(image,X,Y,PLANE_WIDTH,PLANE_HEIGHT,null);
        if(!getBullets().isEmpty()) {
            for (int i = 0; i < getBullets().size(); i++){
                getBullets().get(i).drawImage(g);
            }
        }
    }

    public void update(){

        if(!getBullets().isEmpty()) {
            for (int i = 0; i < getBullets().size(); i++){
                getBullets().get(i).fly();
            }
        }
    }

}
