package controllers;

import models.GameObject;
import views.GameView;

import java.awt.*;

/**
 * Created by Admin on 10/12/2016.
 */
public class SingleController extends BaseController {
    protected GameView gameView;
    protected GameObject gameObject;

    public SingleController(GameObject gameObject, GameView gameView) {
        this.gameView = gameView;
        this.gameObject = gameObject;
    }

    public void draw(Graphics g){
        gameView.drawImage(g,gameObject);
    }
    public void run(){
    }
}
