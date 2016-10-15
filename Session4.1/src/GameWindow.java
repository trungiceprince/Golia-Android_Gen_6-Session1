import controllers.*;
import models.EnemyPlane;
import models.Plane;
import utils.Utils;
import views.GameView;

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
//    EnemyPlaneControllerManager enemyPlaneControllerManager;
//    Vector<BulletController> bulletControllerVector;
//    Vector<Bullet> bulletVector;
//    Vector<models.EnemyPlane> enemyPlaneVector;
//    Vector<models.EnemyBullet> enemyBulletVector;

    Vector<BaseController> controllers;

    public GameWindow() {
        controllers = new Vector<>();
//        controllers.add(PlaneController);
//        controllers.add(PlaneController);

        planeController = new PlaneController(
                new Plane(BACKGROUND_WIDTH  / 2, BACKGROUND_HEIGHT - Plane.PLANE_HEIGHT),
                new GameView(Utils.loadImageFromRes("plane3.png"))
        );
        planeController2 = new PlaneController(
                new Plane(BACKGROUND_WIDTH  / 2, BACKGROUND_HEIGHT - Plane.PLANE_HEIGHT),
                new GameView(Utils.loadImageFromRes("plane4.png"))
        );
        controllers.add(planeController);
        controllers.add(planeController2);
        controllers.add(new EnemyPlaneControllerManager());

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,
                BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);
//        bulletControllerVector = new Vector<>();
//        bulletVector = new Vector<>();
//        enemyPlaneVector = new Vector<>();
//        enemyBulletVector = new Vector<>();

//        Image enemyPlaneImage = Utils.loadImageFromRes("plane1.png");



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
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                planeController2.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
//                    models.Bullet newBullet = new models.Bullet(
//                            plane.getMiddleX() - models.Bullet.BULLET_WIDTH / 2,
//                            plane.getY() - models.Bullet.BULLET_HEIGHT,
//                            bulletImage);
//                    bulletVector.add(newBullet);
//                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                planeController.keyReleased(e);
                System.out.println("keyReleased");
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


        for(BaseController singleController : controllers){
            singleController.draw(backBufferGraphics);
        }
//        plane2.drawImage(backBufferGraphics);
//        for (Bullet bullet : bulletVector) {
//            bullet.drawImage(backBufferGraphics);
//        }


//        for(EnemyPlane enemyPlane : enemyPlaneVector) {
//            enemyPlane.drawImage(backBufferGraphics);
//        }
//
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
                for(BaseController basecontroller : controllers){
                    basecontroller.run();
                }
//                planeController.run();
                count++;

//                for (models.Bullet bullet : bulletVector) {
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

//                for(models.EnemyBullet enemyBullet : enemyBulletVector) {
//                    enemyBullet.fly();
//                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
