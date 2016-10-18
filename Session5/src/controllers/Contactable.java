package controllers;

import models.GameObject;

/**
 * Created by Admin on 10/18/2016.
 */
public interface Contactable {
    GameObject getGameObject();
    void onCollide(Contactable contactable);
}
