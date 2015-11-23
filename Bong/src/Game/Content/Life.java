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
    private static final int P1 = 1;
    private static final int P2 = 1;
    private Size size;
    private Color color;
    private Point pos;
    private int playerId;
    private int point = 100;

    public Life (int playerId, int lifePoint) {
        super();
        this.point = lifePoint;
        this.playerId = playerId;
        this.resize(new Size(point, 20));
        // playerIdとlifePointの応じて表示
        this.pos = playerId == P1 ? new Point(0, 0)
                                  : new Point(Bong.size.Width() - this.Width(), 0);
        this.color = Color.ORANGE;
    }

    public void resize(Size size) {
        super.setMySize(size);
        this.size = size;
    }

    public void descrease() {
        this.point -= 10;
        this.resize(new Size(point, this.size.Height()));
        repaint();
    }

    public int Width() { return size.Width(); }
    public int Height() { return size.Height(); }
    public int Point() { return point; }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBounds(pos.X(), pos.Y(), size.Width(), size.Height());
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.color);
        g2.fill3DRect(pos.X(), pos.Y(), size.Width(), size.Height(), false);
    }
}
