package Player;

import java.awt.event.KeyEvent;

import Game.Content.Life;
import Game.Content.Bar.*;

public abstract class Player
{
    protected Bar bar;
    
    protected int direction = 0;
    public int id;
    protected int lifePoint = 5;
    protected Life life;
    protected Player(int id) {
        this(id, 0);
    }

    protected Player(int id, int barId) {
        bar = BarCreator.create(id, barId);
        this.id = id;
    }

    public Bar getBar() {
        return this.bar;
    }
    
    public int getLifePoint() {
        return this.lifePoint;
    }
    
    public void decreaseLifePoint() {
        this.lifePoint--;
    };

    public abstract void moveBar();

    public abstract void execSkill();

    public abstract void onPress(KeyEvent e);
}
