package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Label;
import java.awt.Font;
import java.applet.*;
import javax.swing.*;
import Common.BongPanel;
import Common.Point;
import Common.Size;
import Player.Player;
import Game.Bong;

public class Result extends BongPanel
{
    private Label title;

    public Result(Player player) {
        super(new Point(0, 0), new Size(800, 400));
        String str = player.Id() == 1 ? "1P" : "2P";
        this.setBackground(Color.BLACK);
        this.setBounds(0, 0, 800, 400);
        title = new Label(str + "の勝利です");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setBounds(200, 10,  400, 130);
        title.setForeground(Color.YELLOW);
        title.setBackground(Color.BLACK);
        this.add(title);
    }
}
