package Game.Content.Ball;

import java.awt.Color;
import java.awt.Graphics;
import Common.BongPanel;
import Common.Size;
import Common.Vector;
import Game.Bong;
import Game.Content.Field;

public class Ball extends BongPanel
{
    private static final long serialVersionUID = -507966157766942319L;
    private static final Size size = new Size(20, 20);
    protected Color color = Color.GREEN;

    public Vector vector;

    public Ball() {
        super(size);
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 2, 2);
    }

    public void move() {
        if (vector.x >= Bong.size.Width()) {  //右壁での反射
            vector.reverceX();
            vector.x = Bong.size.Width() - (size.Width() + 1);
        }
        if (vector.y >= Bong.size.Height()) {  // 下壁での反射
            vector.reverceY();
            vector.y = Bong.size.Height() - (size.Height() + 1);
        }
        if (vector.x <= 0) {  // 左壁での反射
            vector.reverceX();
            vector.x = size.Width() + 1;
        }
        if (vector.y <= 20) {  // 上壁での反射
            vector.reverceY();
            vector.y = size.Height() + 1;
        }
        vector.move();
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }

    public boolean isEqual(Ball ball) {
        return this.color == ball.color && this.vector == ball.vector;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Field.getBackGroundColor());
        g.fillRect(0, 0, size.Width(), size.Height());
        g.setColor(this.color);
        g.fillOval(0, 0, size.Width(), size.Height());
    }
}
