package Game;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import Common.BongPanel;
import Common.Point;
import Common.Size;
import Player.Player;

public class Result extends BongPanel
{
    private static final long serialVersionUID = -4579739331077591851L;
    private Label winner, msg;

    public Result(Player player) {
        super(new Point(0, 0), new Size(800, 400));
        String str = player.Id() == 1 ? "1P" : "2P";
        String str2 = "Push ESC key!";
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 800, 400);
        winner = new Label("Winner " + str);
        winner.setFont(new Font("Arial", Font.PLAIN, 40));
        winner.setBounds(300, 80, 200, 100);
        winner.setForeground(Color.YELLOW);
        winner.setBackground(Color.BLACK);
        msg = new Label(str2);
        msg.setFont(new Font("Arial", Font.PLAIN, 30));
        msg.setBounds(290, 180, 250, 100);
        msg.setForeground(Color.WHITE);
        msg.setBackground(Color.BLACK);
        this.add(winner);
        this.add(msg);
    }
}
