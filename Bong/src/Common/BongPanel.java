package Common;

import javax.swing.JPanel;

public class BongPanel extends JPanel
{
    private static final long serialVersionUID = -6626211277264484350L;

    protected Size size;
    
    public BongPanel(Size size) {
       super();
       this.size = size; 
    }
    
    public int getWidth() {
        return this.size.Width();
    }
    
    public int getHeight() {
        return this.size.Height();
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
