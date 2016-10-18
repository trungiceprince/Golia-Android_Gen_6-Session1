package models;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class GameObject {

    private int x;
    private int y;
    private int width;
    private int height;
    public boolean isAlive;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        isAlive =true;
    }

    public boolean isAlive() {
        return isAlive;
    }
    public void setLive(boolean live){
        isAlive = live;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

//    public int getGameObject(){
//        return GameObject;
//    }

    public int getMiddleX() {
        return x + width / 2;
    }

    public int getMiddleY() {
        return y  + height / 2;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    private Rectangle getRec(){
        return new Rectangle(x,y,width,height);
    }
    public boolean checkCollideWith(GameObject gameObject){
        Rectangle rect1 = this.getRec();
        Rectangle rect2 = gameObject.getRec();
        return rect1.intersects(rect2);
    }
}
