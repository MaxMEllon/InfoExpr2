package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;
import Common.Size;
import Game.Content.Field;
import Player.User;

public class Bong extends JApplet implements Runnable, KeyListener
{
    private static final long serialVersionUID = 6838266341443127470L;
    public static final Size size = new Size(400, 400);
    private Field field;
    private Thread thread = null;
    private User user1 = new User(1);
    private User user2 = new User(2);
    
    @Override
    public void init() {
        this.setSize(size.Width(), size.Height());
        this.field = new Field(size, this.getGraphics());
        field.addBar(user1.getBar());
        field.addBar(user2.getBar());
        this.addKeyListener(this);
        this.setContentPane(field);
        this.setFocusable(true);
    }
   
    @Override
    public void run() {
        Thread updateThread = Thread.currentThread();
        while (thread == updateThread) {
            this.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) { }
            
        }
    }

    @Override
    public void start() {
        if (thread == null) {
            thread = new Thread();
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