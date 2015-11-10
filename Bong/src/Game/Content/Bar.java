package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import Common.BongPanel;
import Common.Point;
import Common.Size;
import Game.Bong;

public class Bar extends BongPanel
{
    private static final long serialVersionUID = 4286321766529401859L;

    protected Size size;
    protected Color color;
    protected Point postion;
    protected int speed = 30;

    public Bar(Color color, Point pos) {
        super(new Size(10, 100));
        this.color = color;
        this.postion = pos;
    }

    public void resize(Size size) {
        super.setMySize(size);
        this.size = size;
    }

    public void move(int direction) {
        int y = this.postion.Y() + direction * speed;
        if (y <= 0) { y = 0; }
        if (y + size.Height() >= Bong.size.Height()) { y = Bong.size.Height() - size.Height(); }
        this.postion.move(this.postion.X(), y);
    }

    public int X() { return postion.X(); }
    public int Y() { return postion.Y(); }
    public int Width() { return size.Width(); }
    public int Height() { return size.Height(); }

    @Override
    public void paintComponent(Graphics g) {
        this.setBounds(postion.X(), postion.Y(), size.Width(), size.Height());
        g.setColor(this.color);
        g.fillRect(0, 0, size.Width(), size.Height());
    }
}
