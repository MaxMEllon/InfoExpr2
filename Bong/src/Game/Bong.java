package Game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;

public class Bong extends JApplet implements Runnable, KeyListener {
    private Thread thread = null;
    private double x, dx, y, dy;
    private int xSize, ySize;
    private double paddleXL, paddleYL, paddleXR, paddleYR;
    private double paddleSize;
    private String message;
    private Font font;
    
    private Image img;
    private Graphics offg;
    private int width, height;
    
    @Override
    public void init() {
        Dimension size = getSize();
        width = size.width; height = size.height;
        xSize = width; ySize = height-80;
        paddleSize = 20;
        message = "Game started!";
        font = new Font("Monospaced", Font.PLAIN, 12);
        setFocusable(true);
        addKeyListener(this);
        
        img  = createImage(width, height);
        offg = img.getGraphics();
    }

    private void initialize() {
        x = 100; y = 100;
        dx = 3.2; dy = 2.0;
        paddleYL = paddleYR = ySize/2;
        paddleXL = 30; paddleXR = xSize-30;
    }

    @Override
    public void paint(Graphics g) {
        // �S�̂��w�i�F�œh���Ԃ��B
        offg.clearRect(0, 0, width, height); 
        
        offg.setColor(Color.BLACK);
        offg.drawRect(0, 0, xSize-1, ySize-1);
        offg.setColor(Color.MAGENTA.darker());
        offg.fillOval((int)(x-3), (int)(y-3), 6, 6);
        
        offg.setColor(Color.RED);
        offg.fillRect((int)(paddleXL-2), (int)(paddleYL-paddleSize/2), 4, (int)paddleSize);
        offg.setColor(Color.BLUE);
        offg.fillRect((int)(paddleXR-2), (int)(paddleYR-paddleSize/2), 4, (int)paddleSize);

        offg.setFont(font);
        offg.setColor(Color.GREEN.darker());
        offg.drawString(message, 5, ySize+12);
        offg.setColor(Color.RED.darker());
        offg.drawString("Left:  Z(D), W(U)", 5, ySize+24);
        offg.setColor(Color.BLUE.darker());
        offg.drawString("Right: M(D), I(U)", 5, ySize+36);  
        
        g.drawImage(img, 0, 0, this);
    }

    public void run() {
        Thread thisThread = Thread.currentThread();
        while (thread==thisThread) {
            initialize();
            requestFocus();
            while (true) {
                x += dx;  y += dy;
                if (dx<0 && (x-paddleXL)*(x-dx-paddleXL)<=0) {
                    double rY = y+dy*(paddleXL-x)/dx;
                    if ((rY-paddleYL+paddleSize/2)*(rY-paddleYL-paddleSize/2)<=0) {
                        x = 2*paddleXL-x;
                        dx *= -1;
                        message = "";
                    }
                }
                if (x<0) {
                    x = -x;
                    dx*=-1;
                    message = "R won!";
                }
                if (dx>0 && (x-paddleXR)*(x-dx-paddleXR)<=0) {
                    double rY = y+dy*(paddleXR-x)/dx;
                    if ((rY-paddleYR+paddleSize/2)*(rY-paddleYR-paddleSize/2)<=0) {
                        x = 2*paddleXR-x;
                        dx *= -1;
                        message = "";
                    }
                }
                if (x>xSize) {
                    x = 2*xSize - x;
                    dx*=-1;
                    message = "L won!";
                }
                if (y<0) {
                    y = -y;
                    dy*=-1;
                }
                if (y>ySize) {
                    y = 2*ySize - y;
                    dy*=-1;
                }
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                }
            }
        }   
    }

    @Override
    public void start() {
        if (thread==null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void stop() {
        thread = null;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
        case 'W':  paddleYL -= 10; break;
        case 'Z':  paddleYL += 10; break;
        case 'I':  paddleYR -= 10; break;
        case 'M':  paddleYR += 10; break;
        }
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}