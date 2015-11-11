package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Common.BongPanel;
import Common.Size;
import Game.Bong;

public class Field extends BongPanel
{
    private static final long serialVersionUID = 6088522508841961855L;
    private ArrayList<Bar> bars = new ArrayList<Bar>();
    private Ball ball = BallCreator.create(0);

    public Field(Size size, Graphics g) {
        super(size);
        this.setBounds(0, 0, size.Width(), size.Height());
        this.add(ball);
    }

    public Field(int width, int height, Graphics g) {
        super(new Size(width, height));
        this.add(ball);
    }

    public void addBar(Bar bar) {
        bars.add(bar);
        this.add(bar);
    }

    public void update() {
        if (ball.vector.x <= bars.get(0).Width()
            && ball.vector.y >= bars.get(0).Y()
            && ball.vector.y <= bars.get(0).Y() + bars.get(0).Height()) {
            ball.vector.reverceX();
            ball.vector.reverceY();
        }
        if (ball.vector.x >= Bong.size.Width() - bars.get(1).Width()
            && ball.vector.y >= bars.get(1).Y()
            && ball.vector.y <= bars.get(1).Y() + bars.get(1).Height()) {
            ball.vector.reverceX();
            ball.vector.reverceY();
        }
        ball.move();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, size.Width(), size.Height());
        g.setColor(Color.green);
        g.drawLine((int)size.Width()/2, 0, (int)size.Width()/2, size.Height());
    }
}
