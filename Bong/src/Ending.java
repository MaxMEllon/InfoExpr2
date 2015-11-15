import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JApplet;

public class Ending extends JApplet implements Runnable
{
    private final int SPEED = 3;        // 流速
    private final int SPACE = 50;       // 行間
    private final int FONTSIZE = 18;    // フォントサイズ

    ArrayList<String> credit;
    int posx;   // 表示するx座標
    int posy;   // 表示するy座標
    int strw;   // 文字列の幅

    Thread th = null;
    Dimension size;
    Image back;
    Graphics buffer;

    @Override
    public void start() {
        if (th == null) {
            credit = new ArrayList<String>();
            size = getSize();
            posx = size.width;
            posy = size.height;
            back = createImage(size.width, size.height);
            buffer = back.getGraphics();
            th = new Thread(this);
            th.start();
            loadFile("LICENSE.txt");   /* TODO: 表示したいファイル名  */
        }
    }

    @Override
    public void stop() {
        th = null;
    }

    public void loadFile(String filename) {
        String path = "/.../" + filename;  /* TODO:pathを指定  */
        try {
            File file = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                credit.add(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        buffer.setColor(getBackground());
        buffer.fillRect(0, 0, size.width, size.height);
        buffer.setColor(Color.BLACK);
        FontMetrics fm = buffer.getFontMetrics();
        Font f = new Font("TimesRoman", Font.ITALIC, FONTSIZE);
        buffer.setFont(f);
        for ( int i = 0; i < credit.size(); i++ ) {
            strw = fm.stringWidth(credit.get(i));
            buffer.drawString(credit.get(i), (posx-strw)/2, posy + SPACE * i);
        }
        g.drawImage(back, 0, 0, this);
    }

    public void run() {
        Thread th2 = Thread.currentThread();
        while (th == th2) {
            posy -= SPEED;
            if (posy <= (-SPACE * credit.size())) {
                //System.out.print("stop"); /*debug*/
                stop();
            }
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {}
        }
    }
}