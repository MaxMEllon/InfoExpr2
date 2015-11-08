package Game;

import java.awt.Graphics;

import javax.swing.JApplet;

import Common.Size;
import Game.Content.Field;

public class Bong extends JApplet implements Field.Callbacks
{
    private static final long serialVersionUID = 6838266341443127470L;
    private Field field = new Field(400, 800);
    private Size size = new Size(800, 400);
    
    @Override
    public void init() {
        this.setSize(this.size.getWidth(), this.size.getHeight());
    }

    @Override
    public void paint(Graphics g) {
        this.setContentPane(field);
    }

    @Override
    public void callbackMethod() {

    }

}