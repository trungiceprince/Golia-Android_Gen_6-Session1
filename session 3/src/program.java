/**
 * Created by Admin on 10/2/2016.
 */
public class program {
    public static void main(String[] args){
        System.out.println("hello world");
        Gamewindow gamewindow = new Gamewindow();
        Thread thread =  new Thread(gamewindow);
        thread.start();

    }
}
