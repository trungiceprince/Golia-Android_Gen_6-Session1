package models;

/**
 * Created by Admin on 10/12/2016.
 */
public class GameObject {
    private int x;
    private int y;
    private int width;
    private int height;

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public int getMiddleX() {
        return x + width / 2;
    }

//    public int getMiddlePB(){
//        return getMiddleX() - Bullet.BULLET_WIDTH /2;
//    }



    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
