package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Common.BongPanel;
import Common.Point;
import Game.Bong;

public class Life extends BongPanel {
    protected int life;
    private static final long serialVersionUID = 4286321766529401859L;
    private Color color = Color.ORANGE;
    protected Point pos;
    
    public Life (int playerId, int lifePoint) {
        int lifeSpace = 0;
        
        if ( lifePoint != 0 ) {
            lifeSpace = 2;
        }
        if ( playerId == 1 ) {
            pos = new Point(lifePoint * 5 + lifeSpace, 0);
        } else {
            pos = new Point(Bong.size.Width() - (lifePoint * 5 + lifeSpace), 0);
        }
    }
    public int Width() { return size.Width(); }
    public int Height() { return size.Height(); }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.setBounds(pos.X(), pos.Y(), 5, 5);
        g2.setColor(this.color);
        g2.fill3DRect(0, 0, 100, 5, false);
    }
}
