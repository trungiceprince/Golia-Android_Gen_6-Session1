package views;

import models.Plane;

import java.awt.*;

//import static models.Plane.PLANE_HEIGHT;
//import static models.Plane.PLANE_WIDTH;

/**
 * Created by Admin on 10/9/2016.
 */
public class PlaneView {

    private Image image;

    public PlaneView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g, Plane plane) {
        g.drawImage(getImage(), plane.getX(), plane.getY(), plane.PLANE_WIDTH, plane.PLANE_HEIGHT, null);
    }

}
