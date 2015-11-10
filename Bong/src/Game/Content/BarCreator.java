package Game.Content;

import java.awt.Color;
import Common.Point;
import Game.Bong;

public class BarCreator
{
    public static Bar create(int playerId, int barId)
    {
        Bar bar;
        Color color = playerId == 1 ? Color.BLUE : Color.RED;
        Point pos = playerId == 1 ? new Point(0, 0) : new Point(Bong.size.Width()-10, 0);
        switch (barId) {
        case 0:
            bar = new Bar(color, pos);
            break;
        case 1:
            bar = new FastBar(color, pos);
            break;
        default:
            bar = null;
        }
        return bar;
    }
}
