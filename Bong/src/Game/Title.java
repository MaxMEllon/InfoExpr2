package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.applet.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import Common.BongPanel;

public class Title extends BongPanel
{
    private static final long serialVersionUID = 6838266341443127470L;
    private BufferedImage image;

    public Title(URL base) {
        this.setLayout(null);
        try {
            System.out.println(base);
            URL url = new URL(base + "../Bong/assets/images/logo.png");
            image = ImageIO.read(url);
        } catch (IOException ex) {
            System.out.println("cant read image file");
        }
        this.setBounds(0, 0, 800, 400);
    }

    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
    }
}
