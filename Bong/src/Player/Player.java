package Player;

import java.awt.event.KeyEvent;

import Game.Content.Bar;
import Game.Content.BarCreator;

public abstract class Player
{
    protected Bar bar;
    protected int direction = 0;
    protected int id;
 
    protected Player(int id) {
        // TODO: menu��barId���w�肵�čD����bar��I�ׂ�悤�ɂ���
        bar = BarCreator.create(id, 0);
        this.id = id;
    }
    
    public Bar getBar() {
        return this.bar;
    }

    public abstract void moveBar();
    
    public abstract void execSkill();
    
    public abstract void pressed(KeyEvent e);
}
