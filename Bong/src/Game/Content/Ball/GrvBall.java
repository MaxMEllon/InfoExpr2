package Game.Content.Ball;

import Common.Size;
import Common.Vector;
import Game.Bong;

public class GrvBall extends Ball 
{
    private static final long serialVersionUID = -507966157766942319L;
    private static final Size size = new Size(10, 10);
    public GrvBall() {
        super();
        super.changeSpeed(2);
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 7, 1);
    }
    public void move() {
        if (vector.x >= Bong.size.Width()) {
            
            vector.reverceX();
            
        }
        if (vector.y >= Bong.size.Height()) {
            changeSpeedY(vector.dy-1);
            vector.reverceY();
        }
        if (vector.x <= 0) {
            vector.reverceX();
        }
        if (vector.y <= 0) {
            changeSpeedY(vector.dy);
            vector.reverceY();
        }
        vector.x += vector.dx;
        vector.y += vector.dy;
        changeSpeedY(vector.dy+1);
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }
    public void changeSpeedY(int speed) {
        this.vector.dy = speed;
    }

}
