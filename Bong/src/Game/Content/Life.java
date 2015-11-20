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
        
        if ( lifePoint != 1 ) {
            lifeSpace = 5;
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
        super.paintComponent(g);
        this.setBounds(pos.X(), pos.Y(), size.Width(), size.Height());
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.fill3DRect(pos.X(), pos.Y(), size.Width(), size.Height(), false);
    }
}
