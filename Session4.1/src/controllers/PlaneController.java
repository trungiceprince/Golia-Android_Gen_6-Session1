package controllers;

import models.Bullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by asus on 10/9/2016.
 */
public class PlaneController extends SingleController {

    private int dx;
    private int dy;
    public static final int SPEED = 10;

    protected static Vector<BulletController> bulletControllers;

    public PlaneController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        bulletControllers = new Vector<>();
    }


//    public PlaneController(Plane plane, GameView planeView) {
//        this.plane = plane;
//        this.planeView = planeView;
//        bulletControllers = new Vector<>();
//    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                dx = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                dx = -SPEED;
                break;
            case KeyEvent.VK_UP:
                dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                dy = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                createBullet();

                break;

        }
    }
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            createBullet();
        }
    }
    public void keyReleased(KeyEvent e) {

        System.out.println("keyReleased");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;

        }
    }
    public void createBullet(){
        BulletController bulletController = new BulletController(
                new Bullet(gameObject.getMiddleX(),gameObject.getY()),
                new GameView(Utils.loadImageFromRes("bullet.png"))
        );
        bulletControllers.add(bulletController);
    }

//    public void  run(){
//        //update model
//        gameObject.move(dx, dy);
//        for(BulletController bulletController : bulletControllers) {
//            bulletController.run();
//        }
//    }


    @Override
    public void run() {
        gameObject.move(dx, dy);
        Vector<BulletController> bulletRemove = new Vector<>();
        for(BulletController bulletController : bulletControllers) {
            bulletController.run();
            if (bulletController.checkRemove()==true){
                bulletRemove.add(bulletController);
            }
//          bulletController.remove();

        }
        bulletControllers.removeAll(bulletRemove);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        for(BulletController bulletController : bulletControllers){
            if (bulletController.checkRemove()==false)
                 bulletController.draw(g);
        }
    }
    //    public void draw(Graphics g){
//        planeView.drawImage(g, plane);
//        for(BulletController bulletController : bulletControllers) {
//            bulletController.draw(g);
//        }
//    }

    public void mouseMoved(MouseEvent e) {
        gameObject.moveTo( e.getX() - (gameObject.getWidth() / 2), e.getY() - (gameObject.getHeight() / 2));
    }
}
