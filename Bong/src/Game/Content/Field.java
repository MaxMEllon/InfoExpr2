package Game.Content;

import java.awt.Graphics;
import java.util.ArrayList;
import Common.BongPanel;
import Common.Size;

public class Field extends BongPanel
{
    private static final long serialVersionUID = 6088522508841961855L;
    private ArrayList<Bar> bars = new ArrayList<Bar>();
  
    public Field(Size size, Graphics g) {
        super(size);
        this.setBounds(0, 0, size.Width(), size.Height());
    }

    public Field(int width, int height, Graphics g) {
        super(new Size(width, height));
    }
    
    public void addBar(Bar bar) {
        bars.add(bar);
        this.add(bar);
    }
   
    public void updateBars() {
        for (Bar bar: bars) {
            bar.repaint();
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        repaint();
    }
}
