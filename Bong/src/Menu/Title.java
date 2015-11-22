package Menu;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.*;

import javax.swing.*;

import Common.Size;
import Game.Content.Field;
import Player.User;

public class Title extends JApplet implements Runnable, KeyListener
{
    private static final long serialVersionUID = 6838266341443127470L;
    private static final int P1 = 1, P2 = 2;
    private static final int PAUSE = 80, RESTART = 82, ENTER = 10;

    public static final Size size = new Size(800, 420);
    public static boolean threadSuspended = true;
    public static boolean Start = true;
    public static boolean puress = true;
    private Field field;
    private Thread thread = null;
    private User user1 = new User(P1, 1);
    private User user2 = new User(P2, 2);
    private AudioClip Bgm;
    Button toBong;
    Boolean event;
    Label title;
    JPanel panel = new JPanel();
    
    @Override
    public void init() {
        this.setSize(size.Width(), size.Height());
        this.setFocusable(true);
        this.addKeyListener(this);
        this.Bgm = getAudioClip(getDocumentBase(), "../assets/bgm/01.mid"); // BGM追加
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread == thisThread) {
            if( puress ){
                showTitle();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("F:run Thread error");
                }
            } else {
                this.pauseIfNeeded(); // pause処理
                this.repaint();
                field.update();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("F:run Thread error");
                }
            }
        }
    }

    private void pauseIfNeeded() {
        while (threadSuspended) {
            synchronized(this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("F:run Thread error");
                }
            }
        }
    }

    @Override
    public void start() {
        this.Bgm.loop();
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
        if (! threadSuspended) {
            this.user2.onPress(e);
            this.user1.onPress(e);
        }
        this.gameStart(e);
        this.pauseAsync(e);
        repaint();
    }

    public synchronized void pauseAsync(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == PAUSE) {
            threadSuspended = true;
        } else if (key == RESTART) {
            threadSuspended = false;
            notify();
        }
    }
    public synchronized void gameStart(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == ENTER) {
            panel.setVisible(false);
            this.field = new Field(size);
            field.addBar(user1.getBar()); // 1Pbar追加
            field.addBar(user2.getBar()); // 2Pbar追加
            field.addLife(user1.id, user1.getLifePoint());  // 1PLife追加
            field.addLife(user2.id, user2.getLifePoint());  // 2PLife追加
            this.setContentPane(field);
            
            puress = false;
            threadSuspended = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
    
    public void showTitle() {
        this.setLayout(null);
        title = new Label("Bonguu!!"); 
        title.setBounds(200, 10,  400, 130);
        title.setFont(new Font("Arial", Font.PLAIN, 100));
        title.setForeground(Color.YELLOW); 
        title.setBackground(Color.BLACK);
        toBong = new Button("Game Start!!");
        toBong.setBounds(300, 200, 200 , 100);
        toBong.setBackground(Color.YELLOW);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0,  800, 400);
        panel.add(title);
        panel.add(toBong);
        this.add(panel);
    }
}
