package Game.Content;

import java.awt.Color;
import java.awt.Graphics;

import Common.BongPanel;
import Common.Point;
import Common.Size;

public class Bar extends BongPanel
{
    private static final long serialVersionUID = 4286321766529401859L;
   
    private Color color;
    private Point postion;
    
    public Bar(Color color, Size size, Point pos) {
        super(size);
        this.color = color;
        this.postion = pos;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.setBounds(postion.X(), postion.Y(), size.Width(), size.Height());
        g.setColor(this.color);
        g.fillRect(0, 0, this.size.Width(), this.size.Height());
    }
}
