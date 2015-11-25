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
    private Label result;

    public Result(Player player) {
        super(new Point(0, 0), new Size(800, 400));
        String str = player.Id() == 1 ? "1P" : "2P";
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 800, 400);
        result = new Label(str + "の勝利です");
        result.setFont(new Font("Arial", Font.PLAIN, 50));
        result.setBounds(200, 10,  400, 130);
        result.setForeground(Color.YELLOW);
        result.setBackground(Color.BLACK);
        this.add(result);
    }
}
