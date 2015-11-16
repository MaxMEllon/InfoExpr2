package Game.Content.Item;

import java.awt.Color;

import Common.BongPanel;
import Common.Size;
import Common.Vector;
import Common.Point;
import Game.Bong;

public class Item extends BongPanel
{
    private static final long serialVersionUID = 4732112007873606103L;
    private static final Size size = new Size (30, 30);
    protected Color color = Color.yellow;
    public Vector vector;
    protected Point position;
    
    public Item()
    {
        super(size);
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2, 0, 1);
    }
    
    public void move()
    {
        if (vector.y >= Bong.size.Height()) {
            vector.reverceY();
            vector.y = Bong.size.Height() - (size.Height() + 1);
        }
        if (vector.y <= 0) {
            vector.reverceY();
            vector.y = size.Height() + 1;
        }
        vector.move();
    }
    
    public void Banish()
    {
        
        
    }
    
}
