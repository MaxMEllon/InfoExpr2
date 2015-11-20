package Menu;

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JApplet;

import Game.Bong;
import Common.BongPanel;
import Common.Size;

public class Menu extends JApplet implements Runnable, KeyListener
{
    private static final long serialVersionUID = 451740410712788297L;
    private Size size;
    Button toBong;
    private Thread thread = null;
    private AudioClip Bgm;
    
    public void init() {
        this.size = Bong.size;
        this.setBounds(0, 0, size.Width(), size.Height());
        toBong = new Button("Game Start!!");
        toBong.setBounds(50, 50, 10 , 50);
        add(toBong);
        
        this.setFocusable(true);
        this.addKeyListener(this);
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread == thisThread ) {
            while ( true ) {
                this.repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("F:run Thread error");
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.Width(), size.Height());
        Graphics2D ga = (Graphics2D)g;
        ga.setPaint(Color.WHITE);
        ga.setFont(new Font("TimesRoman", Font.BOLD, 14));
        ga.drawString("test", 100, 300);
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
        
    }
}
