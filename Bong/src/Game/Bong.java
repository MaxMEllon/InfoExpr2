package Game;

import java.awt.Color;
import javax.swing.JApplet;
import Common.Point;
import Common.Size;
import Game.Content.Bar;
import Game.Content.Field;

public class Bong extends JApplet
{
    private static final long serialVersionUID = 6838266341443127470L;
    private Field field;
    private Size size = new Size(400, 400);
    
    @Override
    public void init() {
        this.setSize(size.Width(), size.Height());
        this.field = new Field(this.size, this.getGraphics());
        Bar bar1 = new Bar(Color.BLUE, new Size(10, 100), new Point(0, 0));
        Bar bar2 = new Bar(Color.RED, new Size(10, 100), new Point(390, 0));
        field.addBar(bar1);
        field.addBar(bar2);
        this.setContentPane(field);
    }
}