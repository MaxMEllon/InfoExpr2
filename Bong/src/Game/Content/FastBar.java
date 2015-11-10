package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import Common.BongPanel;
import Common.Point;
import Common.Size;
import Game.Bong;

public class FastBar extends Bar
{
    private static final long serialVersionUID = 17463287529401859L;

    public FastBar(Color color, Point pos) {
        super(color, pos);
        super.size = new Size(10, 60);
        super.speed = 60;
    }
}
