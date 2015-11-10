package Game.Content.Ball;

import Common.Vector;
import Game.Bong;

public class FastBall extends Ball
{
    private static final long serialVersionUID = -507966157766942319L;

    public FastBall() {
        super();
        super.changeSpeed(2);
        super.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 5, 2);
    }
}
