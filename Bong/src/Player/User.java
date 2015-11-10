package Player;

import java.awt.event.KeyEvent;

public class User extends Player
{
    private static final int UP_1P = 87;    // W
    private static final int DOWN_1P = 83;  // S
    private static final int UP_2P = 38;    // UP
    private static final int DOWN_2P = 40;  // DOWN

    private final int up;
    private final int down;

    public User(int id) {
        super(id);
        up = id == 1 ? UP_1P : UP_2P;
        down = id == 1 ? DOWN_1P : DOWN_2P;
    }

    @Override
    public void moveBar() {
        bar.move(direction);
    }

    @Override
    public void execSkill() {
    }

    public void pressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println(key);
        if (key == up) {
            this.direction = -1;
            this.moveBar();
        } else if (key == down) {
            this.direction = 1;
            this.moveBar();
        }
    }
}
