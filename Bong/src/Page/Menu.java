package Page;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import Game.Bong;
import Common.BongPanel;
import Common.Size;

public class Menu extends BongPanel
{
    private Size size;

    public Menu() {
        this.size = Bong.size;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, size.Width(), size.Height());
        Graphics2D ga = (Graphics2D)g;
        ga.setPaint(Color.WHITE);
        ga.setFont(new Font("TimesRoman", Font.BOLD, 14));
        ga.drawString("test", 100, 300);
    }
}
