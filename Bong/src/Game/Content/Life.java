package Game.Content;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import Common.BongPanel;
import Common.Point;
import Common.Size;
import Game.Bong;

public class Life extends BongPanel {
    private static final long serialVersionUID = 4286321766529401859L;
    protected Size size;
    protected Size arcSize;
    protected Color color;
    protected Point pos;
    
    public Life (int playerId, int lifePoint) {
        super();
        this.resize(new Size(lifePoint,20));
        this.arcSize = new Size(lifePoint,5);
        // playerIdとlifePointの応じて表示
        this.pos = playerId == 1 ? new Point(0, 0)
                : new Point(Bong.size.Width() - this.Width(), 0);
        this.color = Color.ORANGE;
    }
    
    public void resize(Size size) {
        super.setMySize(size);
        this.size = size;
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
