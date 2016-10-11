package models;

//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.MouseEvent;

/**
 * Created by apple on 10/4/16.
 */
public class Plane {
    public int x;
    public int y;

    public static final int PLANE_WIDTH = 50;
    public static final int PLANE_HEIGHT = 35;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Gettters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMiddleX() {
        return x + PLANE_WIDTH / 2;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    public void moveTo(int dx, int dy){
        this.x = dx;
        this.y = dy;
    }

//    public void mouseMoved(MouseEvent e) {
//        x = e.getX() - (PLANE_WIDTH / 2);
//        y = e.getY() - (PLANE_HEIGHT / 2);
//    }

//    public void drawImage(Graphics g) {
//        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
//    }
}
