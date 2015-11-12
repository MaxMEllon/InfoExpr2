package Game.Content.Bar;

import java.awt.Color;
import Common.Point;
import Game.Bong;

public class BarCreator
{
    public static Bar create(int playerId, int barId)
    {
        Bar bar;
        Color color = playerId == 1 ? Color.BLUE : Color.RED;
        Point pos = playerId == 1 ? new Point(0, Bong.size.Height() / 2)
                                  : new Point(Bong.size.Width()-10, Bong.size.Height() / 2);
        switch (barId) {
        case 0:
            bar = new Bar(color, pos);
            break;
        case 1:
            bar = new FastBar(color, pos);
            break;
        case 2:
            bar = new LongBar(color, pos);
            break;
        default:
            bar = null;
        }
        return bar;
    }
}
