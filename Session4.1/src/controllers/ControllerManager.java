package controllers;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Admin on 10/14/2016.
 */
public class ControllerManager extends BaseController{
    protected static Vector<SingleController> singleControllers;

    public ControllerManager() {
        this.singleControllers = new Vector<>();
    }

    public  void add(SingleController singleController){
        this.singleControllers.add(singleController);
    }
    @Override
    public void run() {
        for(SingleController singleController : singleControllers){
            singleController.run();
        }
    }

    @Override
    public void draw(Graphics g) {
        for(SingleController singleController : singleControllers){
            singleController.draw(g);
        }
    }
}
