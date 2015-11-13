package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.lang.Math;
import Common.BongPanel;
import Common.Size;
import Common.Vector;
import Game.Bong;
import Game.Content.Ball.Ball;
import Game.Content.Ball.BallCreator;
import Game.Content.Bar.Bar;

public class Field extends BongPanel
{
    private static final long serialVersionUID = 6088522508841961855L;
    private static Color backGroundColor = Color.BLACK;
    private static int CHANGE_BALL_TIMING = 3;

    private int boundCounter = 0;
    private ArrayList<Bar> bars = new ArrayList<Bar>();
    private Ball ball;
    private ArrayList<Ball> balls = new ArrayList<Ball>();

    public Field(Size size) {
        super(size);
        createBalls();
        this.setBounds(0, 0, size.Width(), size.Height());
        this.add(ball);
    }

    public Field(int width, int height) {
        super(new Size(width, height));
        createBalls();
        this.add(ball);
    }

    private void createBalls() {
        for (int k = 0; k < BallCreator.BALL_TYPE; k++) {
            balls.add(BallCreator.create(k));
        }
        ball = balls.get(0);
    }

    public void addBar(Bar bar) {
        bars.add(bar);
        this.add(bar);
    }

    public void update() {
        if (ball.vector.x <= bars.get(0).Width() + 3
            && ball.vector.y >= bars.get(0).Y() - 10
            && ball.vector.y <= bars.get(0).Y() + bars.get(0).Height() + 10) {
            boundBall();
        }
        if (ball.vector.x >= Bong.size.Width() - bars.get(1).Width() + 3
            && ball.vector.y >= bars.get(1).Y() - 10
            && ball.vector.y <= bars.get(1).Y() + bars.get(1).Height() + 10) {
            boundBall();
        }
        ball.move();
    }

    private void boundBall()
    {
        // if (boundCounter == CHANGE_BALL_TIMING) { changeBallByRandom(); }
        ball.vector.reverceX();
        ball.vector.reverceY();
        boundCounter++;
    }

    private void changeBallByRandom() {
        Vector vec = ball.vector;
        ball = balls.get((int) (Math.random() * BallCreator.BALL_TYPE));
        ball.vector = vec;
        boundCounter = 0;
    }

    public static Color getBackGroundColor() { return backGroundColor; }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backGroundColor);
        g.fillRect(0, 0, size.Width(), size.Height());
        g.setColor(Color.green);
        g.drawLine((int)size.Width()/2, 0, (int)size.Width()/2, size.Height());
    }
}
