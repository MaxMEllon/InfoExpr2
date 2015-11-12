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
    private static final int P1 = 1, P2 = 2;

    public static final Size size = new Size(800, 400);
    public static boolean threadSuspended = false;
    public static final int PAUSE = 80;
    public static final int RESTART = 82;
    private Field field;
    private Thread thread = null;
    private User user1 = new User(P1, 1);
    private User user2 = new User(P2, 2);
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
                while (threadSuspended) { // PAUSE
                    synchronized(this) {
                        try {
                            wait();
                        } catch (InterruptedException e) { }
                    }
                }
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
        this.execPause(e);
        repaint();
    }
    
    public synchronized void execPause(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        if (key == PAUSE) {
        	threadSuspended = true;
        } else if (key == RESTART) {
        	threadSuspended = false;
        	notify();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}
