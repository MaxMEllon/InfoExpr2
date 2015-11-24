package Player;

import java.awt.event.KeyEvent;

import Game.Content.Life;
import Game.Content.Bar.*;

public abstract class Player
{
    protected Bar bar;
    protected int direction = 0;
    protected Life life;
    protected int id;

    protected Player(int id) {
        this(id, 0);
    }

    protected Player(int id, int barId) {
        this.life = new Life(id, 100);
        bar = BarCreator.create(id, barId);
        this.id = id;
    }

    public Bar getBar() { return this.bar; }
    public int getLifePoint() { return this.life.Point(); }
    public Life getLife() { return this.life; }

    public void decreaseLife() {
        this.life.descrease();
    }

    public int Id() { return this.id; }
    public Life Life() { return this.life; }

    public abstract void moveBar();

    public abstract void execSkill();

    public abstract void onPress(KeyEvent e);
}
