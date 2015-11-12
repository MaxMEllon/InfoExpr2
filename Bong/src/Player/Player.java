package Player;

import java.awt.event.KeyEvent;
import Game.Content.Bar.*;

public abstract class Player
{
    protected Bar bar;
    protected int direction = 0;
    protected int id;

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

    public abstract void moveBar();

    public abstract void execSkill();

    public abstract void pressed(KeyEvent e);
}
