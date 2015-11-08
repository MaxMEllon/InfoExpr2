package Game.Content;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

import Common.Size;

public class Field extends JPanel
{
    private static final long serialVersionUID = 6088522508841961855L;
    private Size size;
    public Image FieldImage;
   
    public Field(Size size) {
        FieldImage = this.createImage(this.size);
    }

    public Field(int width, int height) {
        size = new Size(width, height);
        FieldImage = this.createImage(this.size);
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(this.FieldImage, 0, 0, this);
    }
    
    public void addBar(Bar bar) {
    }
    
    public int getWidth() {
        return this.size.getWidth();
    }
    
    public int getHeight() {
        return this.size.getHeight();
    }

    private Image createImage(Size size) {
        return this.createImage(size.getHeight(), size.getHeight());
    }
    //--- コールバックの処理

    public void callbackMethod() {
        _callbacks.callbackMethod();
    }

    //--- コールバックメソッドの定義

    public interface Callbacks {
        public void callbackMethod();
    }

    private Callbacks _callbacks;

    public void setCallbacks(Callbacks callbacks) {
        _callbacks = callbacks;
    }
}
