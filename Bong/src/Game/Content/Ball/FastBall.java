package Game.Content.Ball;

import java.awt.Color;
import Common.Vector;
import Game.Bong;

public class FastBall extends Ball
{
    private static final long serialVersionUID = -507966157766942319L;

    public FastBall() {
        super();
        super.color = Color.BLUE;
        super.vector.changeSpeed(2);
        super.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 8, 3);
    }
}
