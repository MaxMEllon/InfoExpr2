package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.*;
import java.net.URL;
import javax.swing.*;
import Common.Size;
import Game.Content.Field;
import Player.User;

public class Bong extends JApplet implements Runnable, KeyListener
{
    private static final long serialVersionUID = 6838266341443127470L;
    public static final Size size = new Size(800, 400);
    private Field field;
    private Thread thread = null;
    private User user1 = new User(1);
    private User user2 = new User(2);
    private AudioClip Bgm;

    @Override
    public void init() {
        this.setSize(size.Width(), size.Height());
        this.field = new Field(size, this.getGraphics());
        field.addBar(user1.getBar());
        field.addBar(user2.getBar());
        URL url = getDocumentBase();
        this.Bgm = getAudioClip(url, "./assets/bgm/01.mid");
        this.setContentPane(field);
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread == thisThread) {
            while ( true ) {
                this.repaint();
                field.update();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("Thread error : " + e.toString());
                }
            }
        }
    }

    @Override
    public void start() {
        this.Bgm.play();
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        thread = null;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.user2.pressed(e);
        this.user1.pressed(e);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}
