import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Admin on 10/2/2016.
 */
public class Gamewindow extends Frame implements Runnable{
    private static final int PLANE_WIDTH = 50;
    private static final int PLANE_HEIGHT = 40;
    private static final int PLANE_X = 270;
    private static final int PLANE_Y = 350;
    private static final int PLANE1_X = 30;
    private static final int PLANE1_Y = 40;
    private static final int BULLET_WIDTH = 13;

    public static final int BACKGROUND_WIDTH = 600;
    public static final int BACKGROUND_HEIGHT = 400;

    Image backgroundImage = null;
    Image backBufferImage;
    Plane plane;
    Plane plane1;
    EnemyPlane enemyPlane;

    public Gamewindow(){
        backBufferImage = new BufferedImage(BACKGROUND_WIDTH,BACKGROUND_HEIGHT,BufferedImage.TYPE_3BYTE_BGR);

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH,BACKGROUND_HEIGHT );

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(" windowClosing");
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
                System.out.println("windowActivated");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated(");

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
                plane.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                plane1.mouseMoved(e);

            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                plane1.mousePressed();

            }
        });

        try {
             backgroundImage = ImageIO.read(new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");
            plane = new Plane(PLANE_X,PLANE_Y,ImageIO.read(new File("resources/plane3.png")));
            plane1 = new Plane(PLANE1_X,PLANE1_Y,ImageIO.read(new File("resources/plane4.png")));
            Random r = new Random();
            enemyPlane = new EnemyPlane(r.nextInt(BACKGROUND_WIDTH - EnemyPlane.ENEMY_WIDTH),0,ImageIO.read(new File("resources/plane1.png")));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);

        System.out.println("Draw backgroundImage");
    }

    @Override
    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        plane.drawImage(backBufferGraphics);
        plane1.drawImage(backBufferGraphics);
        enemyPlane.drawImage(backBufferGraphics);
        enemyPlane.move();
        for(int i = 0; i < enemyPlane.getEButllet().size(); i ++){
            enemyPlane.getEButllet().get(i).drawImage(backBufferGraphics);
//            enemyPlane.update();
            enemyPlane.getEButllet().get(i).e_fly();
        }

        g.drawImage(backBufferImage,0,0,BACKGROUND_WIDTH,BACKGROUND_HEIGHT,null);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
                plane.update();
                plane1.update();
                enemyPlane.update();

                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}