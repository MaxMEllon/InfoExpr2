package Game;

import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.applet.*;
import javax.swing.*;

import Common.BongPanel;

public class Title extends BongPanel
{
    private static final long serialVersionUID = 6838266341443127470L;
    private static Label title;
    private static JPanel panel = new JPanel();

    public Title() {
        title = new Label("Bonguu!!");
        title.setBounds(200, 10, 400, 130);
        title.setFont(new Font("Arial", Font.PLAIN, 100));
        title.setForeground(Color.YELLOW);
        title.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        panel.setBounds(0, 0, 800, 400);
        panel.add(title);
        this.add(panel);
    }
}
