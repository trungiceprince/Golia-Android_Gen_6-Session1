import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 10/2/2016.
 */
public class Gamewindow extends Frame {
    Image backgroundImage = null;
    Image playPlane = null;
    Image playPlane1 = null;
    private int planeX = 270;
    private int planeY = 350;
    private int planx = 30;
    private int plany = 40;

    public Gamewindow(){
        this.setVisible(true);
        this.setSize(600, 400);


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
                switch(e.getKeyCode()){
                    case KeyEvent.VK_RIGHT:
                        System.out.println(" key right");
                        planeX += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println(" key left");
                        planeX -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        System.out.println(" key up");
                        planeY -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println(" key down");
                        planeY += 10;
                        repaint();
                        break;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased");

            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                planx  = e.getX() - 15;
                plany  = e.getY() - 10;
                repaint();

            }
        });

        try {
             backgroundImage = ImageIO.read(new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");
            playPlane = ImageIO.read(new File("resources/plane3.png"));
            playPlane1 = ImageIO.read(new File("resources/plane4.png"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g.drawImage(playPlane, planeX,planeY,50,40,null);
        g.drawImage(playPlane1, planx, plany, 50,40,null);
        System.out.println("Draw backgroundImage");
    }
}
