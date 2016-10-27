package controllers.Screens;

import controllers.managers.GameScreen;
import controllers.managers.ScreenManager;
import models.GameConfig;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Admin on 10/27/2016.
 */
public class GameOverScreen extends GameScreen{
    private Image backgroundImage = Utils.loadImageFromRes("over.jpg");
    public GameOverScreen(ScreenManager screenManager) {
        super(screenManager);
    }

    @Override
    public void run() {

    }

    @Override
    public void update(Graphics graphics) {
        graphics.drawImage(backgroundImage, 0 ,0 ,
                GameConfig.instance.getScreenWidth(),
                GameConfig.instance.getScreenHeight(),
                null);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
