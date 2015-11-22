package Common;

import javax.swing.JPanel;

import Game.Content.Ball.Ball;
import Common.Area;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.*;

public class BongPanel extends JPanel
{
    private static final long serialVersionUID = -6626211277264484350L;

    protected Point point;
    protected Size size;

    public BongPanel() {
        super();
        this.point = new Point(-1, -1);
        this.size = new Size(-1, -1);
    }

    public BongPanel(Size size) {
        this();
        this.size = size;
    }
    
    public BongPanel(Point point, Size size) {
        this(size);
        this.point = point;
    }

    public void setMySize(Size size) {
        super.setSize(new Dimension(size.Width(), size.Height()));
        this.size = size;
    }

    public int getWidth() {
        return this.size.Width();
    }

    public int getHeight() {
        return this.size.Height();
    }

    public boolean isHit(Ball b) {
        Rectangle objRec = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle ballRec = new Rectangle(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        return ballRec.intersects(objRec);
    }
    
    public Area getArea() {
        return new Area(this.point, this.size);
    }
    
    public void callbackMethod() {
        _callbacks.callbackMethod();
    }

    public interface Callbacks {
        public void callbackMethod();
    }

    private Callbacks _callbacks;

    public void setCallbacks(Callbacks callbacks) {
        _callbacks = callbacks;
    }
}
