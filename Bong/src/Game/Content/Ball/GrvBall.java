package Game.Content.Ball;

import java.awt.Color;
import Common.Size;
import Common.Vector;
import Game.Bong;

public class GrvBall extends Ball
{
    private static final long serialVersionUID = -507966157766942319L;
    private static final Size size = new Size(10, 10);
    public GrvBall() {
        super();
        super.color = Color.WHITE;
        super.vector.changeSpeed(2);
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 4, -2);
    }
    public void move() {
        if (vector.x >= Bong.size.Width()) {
            vector.reverceX();
            vector.x = Bong.size.Width() - (size.Width()+1);
        }
        if (vector.y >= Bong.size.Height()) {
            vector.y = Bong.size.Height();
            if (vector.dy >= -2) { changeSpeedY(vector.dy-1); }
            vector.reverceY();
            vector.y = Bong.size.Height() - (size.Height()+1);
        }
        if (vector.x <= 0) {
            vector.reverceX();
            vector.x = size.Width()+1;
        }
        if (vector.y <= 0) {
            vector.y = 0;
            if (vector.dy <= 2) { changeSpeedY(vector.dy+1); }
            vector.reverceY();
            vector.y = size.Height()+1;
        }
        vector.x += vector.dx;
        vector.y += vector.dy;
        changeSpeedY(vector.dy+vector.dx/Math.abs(vector.dx));
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }
    public void changeSpeedY(int speed) {
        this.vector.dy = speed;
    }

}
