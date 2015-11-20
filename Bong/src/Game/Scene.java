package Game;

import Menu.Menu;
import javax.swing.JApplet;

public class Scene extends JApplet
{
    private static final long serialVersionUID = 4496375549150456421L;
    public Menu menu;
    public Bong bong;
    
    public void init() {
        setLayout(null);
        menu = new Menu();
        bong = new Bong();
        bong.run();
    }
    
    public void start() {}
}
