package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.sun.javafx.scene.paint.GradientUtils.Point;

import Common.BongPanel;
import Common.Size;

public class Life extends BongPanel {
    protected int life;
    protected Point postion;
    private static final long serialVersionUID = 4286321766529401859L;
    public Life (int life){
        super();
        this.life = life;
    }
    public int Width() { return size.Width(); }
    public int Height() { return size.Height(); }
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        this.setBounds(0, 0, 5, 5);
        g2.setColor(Color.red);
        g2.fill3DRect(0, 0, 100, 5, false);
    }
}
