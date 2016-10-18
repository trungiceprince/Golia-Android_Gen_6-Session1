package models;

/**
 * Created by Admin on 10/17/2016.
 */
public class GameConfig {
    private static final int DEFAULT_DELAY = 17;
    private static final int DEFAULT_WIDTH = 800 ;
    private static final int DEFAULT_HEIGHT = 600 ;


    private int threadDelayInMiliSeconds = 17;
    private int screenWidth;
    private int screenHeight;

    public double getSeconds(int count){
        return threadDelayInMiliSeconds * count / 1000;
    }

    public GameConfig(int threadDelayInMiliSeconds, int screenWidth, int screenHeight) {
        this.threadDelayInMiliSeconds = threadDelayInMiliSeconds;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    public int getThreadDelayInMiliSeconds() {
        return threadDelayInMiliSeconds;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setThreadDelayInMiliSeconds(int threadDelayInMiliSeconds) {
        this.threadDelayInMiliSeconds = threadDelayInMiliSeconds;
    }

    public boolean yOutsideScreen(int y){
        return (y < 0 || y > screenHeight);
    }
    public boolean yOutsideScreen(GameObject gameObject){
        return yOutsideScreen(gameObject.getY());
    }

    public static final GameConfig instance =  new GameConfig(
            DEFAULT_DELAY,
            DEFAULT_WIDTH,
            DEFAULT_HEIGHT
    );
}
