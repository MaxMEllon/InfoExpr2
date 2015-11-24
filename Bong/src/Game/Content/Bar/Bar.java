package Game.Content.Bar;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Common.BongPanel;
import Common.Point;
import Common.Size;
import Game.Bong;

public class Bar extends BongPanel
{
    private static final long serialVersionUID = 4286321766529401859L;

    protected Size size;
    protected Size arcSize;
    protected Color color;
    protected Point position;
    protected int speed = 30;
    private AudioClip se03;

    public Bar(Color color, Point pos) {
        super();
        this.resize(new Size(10, 100));
        this.arcSize = new Size(5, 20);
        this.color = color;
        this.position = pos;
        se03 = Applet.newAudioClip(getClass().getClassLoader().getResource("effect/03.wav"));  // Barが移動した時の音
    }

    public void resize(Size size) {
        super.setMySize(size);
        this.size = size;
    }

    public void move(int direction) {
        int y = this.position.Y() + direction * speed;
        if (y <= 20) { y = 20; }
        if (y + size.Height() >= Bong.size.Height()) { y = Bong.size.Height() - size.Height(); }
        this.position.move(this.position.X(), y);
        se03.play();
    }

    public int X() { return position.X(); }
    public int Y() { return position.Y(); }
    public int Width() { return size.Width(); }
    public int Height() { return size.Height(); }

    @Override
    public void paintComponent(Graphics g) {
        this.setBounds(position.X(), position.Y(), size.Width(), size.Height());
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.fill3DRect(0, 0, size.Width(), size.Height(), false);
    }
}
