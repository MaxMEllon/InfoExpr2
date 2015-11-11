package Game.Content.Bar;

import java.awt.Color;
import Common.Point;
import Common.Size;

public class LongBar extends Bar
{
    private static final long serialVersionUID = 174632143523L;

    public LongBar(Color color, Point pos) {
        super(color, pos);
        super.size = new Size(10, 140);
        super.resize(super.size);
        super.speed = 15;
    }
}
