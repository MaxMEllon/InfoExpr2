package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import Common.BongPanel;
import Common.Size;
import Common.Vector;
import Game.Bong;

public class Ball extends BongPanel
{
    private static final long serialVersionUID = -507966157766942319L;
    private static final Size size = new Size(10, 10);

    public Vector vector;
    
    public Ball() {
        super(size);
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 20, 20);
    }

    public void move() {
        if (vector.x >= Bong.size.Width()) {
            vector.dx *= -1;
        }
        if (vector.y >= Bong.size.Height()) {
            vector.dy *= -1;
        }
        if (vector.x <= 0) {
            vector.dx *= -1;
        }
        if (vector.y <= 0) {
            vector.dy *= -1;
        }
        vector.x += vector.dx;
        vector.y += vector.dy;
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, size.Width(), size.Height());
    }
}
