package Game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.applet.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Common.Size;
import Game.Content.Field;
import Player.User;

public class Bong extends JApplet implements Runnable, KeyListener
{
    private static final long serialVersionUID = 6838266341443127470L;
    private static final int P1 = 1, P2 = 2;
    private static final int PAUSE = 80, RESTART = 82, ENTER = 10, ESCAPE = 27;

    public static final Size size = new Size(800, 400);
    public static boolean threadSuspended = true;
    public static boolean titleFlag = true;
    public static boolean endFlag = false;
    public static boolean pauseFlag = false;
    private Field field;
    private AudioClip Bgm;
    private Thread thread = null;
    private User user1 = new User(P1, 1);
    private User user2 = new User(P2, 2);
    public Pause pause;

    @Override
    public void init() {
        this.setSize(size.Width(), size.Height());
        this.setFocusable(true);
        this.addKeyListener(this);
        this.Bgm = getAudioClip(getDocumentBase(), "../Bong/assets/bgm/01.mid"); // BGM追加
    }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread == thisThread) {
            if(titleFlag) {
                Graphics g = this.getGraphics();
                try {
                    g.drawImage(ImageIO.read(new URL(getCodeBase() + "../Bong/assets/images/logo.png")), 0, 0, null);
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("F:run Thread error");
                }
            } else {
                this.pauseIfNeeded(); // pause処理
                this.repaint();
                if (field.showResultIfNeededAndJudgeGameEnd()){
                    endFlag = true;
                    thread = null;
                } else {
                    field.update();
                }
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
        this.backToTitle(e);
        repaint();
    }

    public synchronized void pauseAsync(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == PAUSE) {
            threadSuspended = true;
            if (pauseFlag == false) {
                this.pause = new Pause();
                this.add(this.pause);
                pauseFlag = true;
            }
        } else if (key == RESTART) {
            threadSuspended = false;
            if (pauseFlag == true) {
                this.remove(pause);
                pauseFlag = false;
            }
            notify();
        }
    }

    public synchronized void gameStart(KeyEvent e) {
        int key = e.getKeyCode();
        if (! titleFlag || key != ENTER) { return; }
        try {
            System.out.println("gameStart");
            this.field = new Field(size);
            field.addPlayer(user1);
            field.addPlayer(user2);
            this.setContentPane(field);
            titleFlag = false;
            threadSuspended = false;
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            System.out.println("F:run Thread error");
        }
    }
    
    public synchronized void backToTitle(KeyEvent e) {
        int key = e.getKeyCode();
        if (! endFlag || key != ESCAPE) { return; }
        if (field.result != null) { this.remove(field.result); }
        titleFlag = true;
        endFlag = false;
        user1 = new User(P1, 1);
        user2 = new User(P2, 2);
        start();
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }
}
