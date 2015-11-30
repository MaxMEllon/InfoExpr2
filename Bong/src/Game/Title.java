package Game;

import java.awt.Graphics;

import java.awt.Image;

import Common.BongPanel;

public class Title extends BongPanel
{
    private static final long serialVersionUID = 6838266341443127470L;
    private Image image;

    public Title(Image image) {
        this.setLayout(null);
        this.image = image;
        this.setBounds(0, 0, 800, 400);
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
