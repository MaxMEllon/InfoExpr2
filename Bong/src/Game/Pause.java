package Game;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import Common.BongPanel;

public class Pause extends BongPanel
{
    private static final long serialVersionUID = -4579739331077591851L;
    private Label msg1, msg2;

    public Pause() {
        String str1 = "Pause";
        String str2 = "Push R key to restart!";
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 800, 400);
        msg1 = new Label(str1);
        msg1.setFont(new Font("Arial", Font.PLAIN, 50));
        msg1.setBounds(320, 80, 150, 100);
        msg1.setForeground(Color.WHITE);
        msg1.setBackground(Color.BLACK);
        msg2 = new Label(str2);
        msg2.setFont(new Font("Arial", Font.PLAIN, 30));
        msg2.setBounds(250, 180, 300, 100);
        msg2.setForeground(Color.WHITE);
        msg2.setBackground(Color.BLACK);
        this.add(msg1);
        this.add(msg2);
    }
}
