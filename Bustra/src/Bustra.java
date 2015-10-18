import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JApplet;

import static java.awt.Color.*;
import static java.awt.event.KeyEvent.*;

public class Bustra extends JApplet implements KeyListener
{
    // バージョン番号
    private static final long serialVersionUID = 1L;
    private final static int R = 40, E = 2;
    private final static int COLS = 6, ROWS = 5;
    private Color[][] state;
    private final static Color VIOLET = new Color(0x8a, 0x2b, 0xe2);
    private Color[] colors = {RED, BLUE, GREEN, YELLOW, VIOLET, MAGENTA};
    private boolean toggle = false;

    private int x = 0, y = 0;
    @Override
    public void init()
    {
        int i, j;
        state = new Color[COLS][ROWS];
        for ( i = 0; i < COLS; i++ ) {
            Color[] row = state[i];
            for ( j = 0; j < ROWS; j++ ) {
                row[j] = colors[(int)(Math.random()*6)];
            }
        }
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g)
    {
        for ( int i = 0; i < COLS; i++ ) {
            Color[] row = state[i];
            for ( int j = 0; j < ROWS; j++) {
                if ( x == i && y == j ) {
                    if ( toggle ) {
                        g.setColor(BLACK);
                    } else {
                        g.setColor(LIGHT_GRAY);
                    }
                }  else {
                    g.setColor(WHITE);
                }
                g.fillOval(i*R, j*R, R, R);
                Color c = row[j];
                g.setColor(c);
                g.fillOval(i*R+E, j*R+E, R-2*E, R-2*E);
            }
        }
        g.setColor(BLACK);
        g.drawString("←, ↑, ↓, →: move position", 20, ROWS*R + 25);
        g.drawString("<SPACE>: toggle exchange",  20, ROWS*R + 40);
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch ( key ) {
        case VK_SPACE: 
            toggle = !toggle;
            if ( ! toggle ) {
                // パズル判定処理
            }
            break;
        case VK_LEFT:  
            if ( x > 0 ) {
                x--;
                if ( toggle ) {
                    Color tmp = state[x+1][y];
                    state[x+1][y] = state[x][y];
                    state[x][y] = tmp;
                }
            }
            break;
        case VK_UP:   
            if ( y > 0 ) {
                y--; 
                if ( toggle ) {
                    Color tmp = state[x][y+1];
                    state[x][y+1] = state[x][y];
                    state[x][y] = tmp;
                }
            }
            break;
        case VK_DOWN:  
            if ( y < ROWS-1 ) {
                y++; 
                if ( toggle ) {
                    Color tmp = state[x][y-1];
                    state[x][y-1] = state[x][y];
                    state[x][y] = tmp;
                }
            }
            break;
        case VK_RIGHT: 
            if ( x < COLS-1 ) {
                x++;
                if (toggle) {
                    Color tmp = state[x-1][y];
                    state[x-1][y] = state[x][y];
                    state[x][y] = tmp;
                }
            }
            break;
        default: 
            break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}