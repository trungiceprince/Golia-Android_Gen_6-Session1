import controllers.BulletController;
import controllers.EnemyBulletController;
import controllers.EnemyPlaneController;
import controllers.PlaneController;
import models.EnemyBullet;
import models.EnemyPlane;
import models.Plane;
import utils.Utils;
import views.EnemyBulletView;
import views.EnemyPlaneView;
import views.PlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by apple on 10/2/16.
 */
public class GameWindow extends Frame implements Runnable {

    private static final int BACKGROUND_WIDTH = 600;
    private static final int BACKGROUND_HEIGHT = 400;

    Image backgroundImage = null;
    Image backBufferImage;

    PlaneController planeController;
    PlaneController planeController2;

    Vector<BulletController> bulletControllervector;
    Vector<EnemyPlaneController> enemyPlaneControllerVector;
    Vector<EnemyBulletController> enemyBulletControllerVector;

//    Vector<Bullet> bulletVector;
//    Vector<EnemyPlane> enemyPlaneVector;
//    Vector<EnemyBullet> enemyBulletVector;

    public GameWindow() {
        planeController = new PlaneController(
                new Plane(BACKGROUND_WIDTH / 2 , BACKGROUND_HEIGHT -40), // tru 40 de xuat hien may bay.
                new PlaneView(Utils.loadImageFromRes("plane3.png")));

        planeController2 = new PlaneController(
                new Plane(BACKGROUND_WIDTH / 2 , BACKGROUND_HEIGHT -10),
                new PlaneView(Utils.loadImageFromRes("plane4.png")));

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        bulletControllervector = new Vector<>();
        enemyPlaneControllerVector = new Vector<>();
        enemyBulletControllerVector = new Vector<>();
//        enemyPlaneVector = new Vector<>();
//        enemyBulletVector = new Vector<>();

//        Image enemyPlaneImage = Utils.loadImageFromRes("plane1.png");

        for(int i = 0; i < 10; i++) {
            int y = 60;
            int x = i * (EnemyPlane.ENEMY_PLANE_WIDTH + 5);
            EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                    new EnemyPlane(x,y),
                    new EnemyPlaneView(Utils.loadImageFromRes("plane1.png"))
            );
            enemyPlaneControllerVector.add(enemyPlaneController);
        }

//        try {
//            plane = new Plane(350, 250, ImageIO.read(new File("resources/plane3.png")));
////            plane2 = new Plane(450, 250,
////                    ImageIO.read(new File("resources/plane4.png")));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");
            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                 planeController2.mouseMoved(e);
            }
        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed");
                planeController.keyPressed(e);

//                if(e.getKeyCode() == KeyEvent.VK_SPACE) {
//                    Image bulletImage = Utils.loadImage("resources/bullet.png");
//                    Bullet newBullet = new Bullet(
//                            plane.getMiddleX() - Bullet.BULLET_WIDTH / 2,
//                            plane.getY() - Bullet.BULLET_HEIGHT,
//                            bulletImage);
//                    bulletVector.add(newBullet);
//                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");
                planeController.keyReleased(e);
            }
        });

        try {
            backgroundImage = ImageIO.read (
                    new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background image");
    }

    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);

        planeController.draw(backBufferGraphics);
        planeController2.draw(backBufferGraphics);
//        plane2.drawImage(backBufferGraphics);
//        for (Bullet bullet : bulletVector) {
//            bullet.drawImage(backBufferGraphics);
//        }
//        for(BulletController bulletController : bulletControllervector){
//            bulletController.draw(backBufferGraphics);
//        }

        for(EnemyPlaneController enemyPlaneController : enemyPlaneControllerVector){
            enemyPlaneController.draw(backBufferGraphics);
        }

//        for(EnemyPlane enemyPlane : enemyPlaneVector) {
//            enemyPlane.drawImage(backBufferGraphics);
//        }

//        for(models.EnemyBullet enemyBullet : enemyBulletVector) {
//            enemyBullet.drawImage(backBufferGraphics);
//        }

        g.drawImage(backBufferImage,
                0, 0,
                BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }

    int count = 0;

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(17);
                repaint();
                planeController.run();
                planeController2.run();
//                for(BulletController bulletController : bulletControllervector){
//                    bulletController.run();
//                }

                count++;
                for(EnemyPlaneController enemyPlaneController : enemyPlaneControllerVector){
                    enemyPlaneController.run();
                }
                if(count > 10){
                    count = 0;
                    for (EnemyPlaneController enemyPlaneController : enemyPlaneControllerVector) {
                        int x = enemyPlaneController.getEnemyPlane().getMiddleX() - EnemyBullet.BULLET_WIDTH / 2;
                        int y = enemyPlaneController.getEnemyPlane().getY() + EnemyBullet.BULLET_HEIGHT;
                        EnemyBulletController enemyBulletController = new EnemyBulletController(
                                new EnemyBullet(x, y),
                                new EnemyBulletView(Utils.loadImageFromRes("enemy_bullet.png")));
                        enemyPlaneController.getEnemyBulletControllerVector().add(enemyBulletController);
                    }
                }


//                for (Bullet bullet : bulletVector) {
//                    bullet.fly();
//                }
//
//                for (models.EnemyPlane enemyPlane : enemyPlaneVector) {
//                    enemyPlane.fly();
//                }
//
//                if(count >= 10) {
//                    count = 0;
//                    for (models.EnemyPlane enemyPlane : enemyPlaneVector) {
//                        models.EnemyBullet enemyBullet = new models.EnemyBullet(
//                                enemyPlane.getMiddleX(),
//                                enemyPlane.getBottom(),
//                                Utils.loadImageFromRes("enemy_bullet.png")
//                        );
//                        enemyBulletVector.add(enemyBullet);
//                    }
//                }
//
//                for(models.EnemyBullet enemyBullet : enemyBulletVector) {
//                    enemyBullet.fly();
//                }
                repaint();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
