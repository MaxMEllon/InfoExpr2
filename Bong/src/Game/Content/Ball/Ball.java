package Game.Content.Ball;

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
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 1, 1);
    }

    public void move() {
        if (0 <= vector.x || vector.x >= Bong.size.Width()) { vector.reverceX(); }
        if (0 <= vector.y || vector.y >= Bong.size.Height()) { vector.reverceY(); }
        vector.x += vector.dx;
        vector.y += vector.dy;
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }

    public void changeSpeed(int speed) {
        this.vector.dx = speed;
        this.vector.dy = speed;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, size.Width(), size.Height());
    }
}
