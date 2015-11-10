package Game.Content;

import java.awt.Color;
import java.awt.Graphics;

import Common.BongPanel;
import Common.Size;
import Common.Vector;
import Game.Bong;

public class FastBall extends Ball 
{    
    private static final long serialVersionUID = -507966157766942319L;
    private static final Size size = new Size(10, 10);
    public Vector vector;
    public FastBall (){
        super();
        this.vector = new Vector(Bong.size.Width()/2, Bong.size.Height()/2,1,1);
    }
    
    public void move() {
        if (vector.x >= Bong.size.Width()) {
            vector.reverceX();
        }
        if (vector.y >= Bong.size.Height()) {
            vector.reverceY();
        }
        if (vector.x <= 0) {
            vector.reverceX();
        }
        if (vector.y <= 0) {
            vector.reverceY();
        }
        vector.x += vector.dx;
        vector.y += vector.dy;
        this.setBounds(vector.x, vector.y, size.Width(), size.Height());
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillOval(0, 0, size.Width(), size.Height());
    }
    
}
