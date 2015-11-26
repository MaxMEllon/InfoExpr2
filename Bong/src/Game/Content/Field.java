package Game.Content;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.lang.Math;

import Common.BongPanel;
import Common.Point;
import Common.Size;
import Common.Vector;
import Game.Bong;
import Game.Result;
import Game.Content.Ball.Ball;
import Game.Content.Ball.BallCreator;
import Game.Content.Bar.Bar;
import Game.Content.Item.ItemCreator;
import Game.Content.Item.Item;
import Player.Player;
import Player.User;

public class Field extends BongPanel
{
    private static final long serialVersionUID = 6088522508841961855L;
    private static Color backGroundColor = Color.BLACK;
    private static int CHANGE_BALL_TIMING = 1;
    private static int CREATE_ITEM_TIMING = 1;

    private int boundCounter = 0;
    private ArrayList<Bar> bars = new ArrayList<Bar>();
    private ArrayList<Life> lifes = new ArrayList<Life>();
    private ArrayList<Player> players = new ArrayList<Player>();
    private AudioClip se01, se02;
    private Ball ball = BallCreator.create(0);
    private Item item;

    public Field(Size size) {
        super(new Point(0, 0), size);
        this.setBounds(0, 0, size.Width(), size.Height());
        this.add(ball);
        se01 = Applet.newAudioClip(getClass().getClassLoader().getResource("effect/01.wav"));  // BallとBarが接触した時の音
        se02 = Applet.newAudioClip(getClass().getClassLoader().getResource("effect/02.wav"));  // Ballと壁が接触した時の音
    }

    public Field(int width, int height) {
        this(new Size(width, height));
    }

    public void addPlayer(User p) {
        this.addBar(p.getBar());
        this.addLife(p.getLife());
        this.players.add(p);
    }

    private void addBar(Bar bar) {
        bars.add(bar);
        this.add(bar);
    }

    private void addLife(Life life) {
        lifes.add(life);
        this.add(life);
    }

    public void update() {
        // ballと1P barの当たり判定
        if (ball.vector.x <= bars.get(0).Width() + 3
            && ball.vector.y >= bars.get(0).Y() - 5
            && ball.vector.y <= bars.get(0).Y() + bars.get(0).Height() + 5) {
            boundBall();
            se01.play();
            System.out.println("bound 1p");
        }
        // ball と2P barの当たり判定
        if (ball.vector.x >= Bong.size.Width() - bars.get(1).Width() + 3
            && ball.vector.y >= bars.get(1).Y() - 5
            && ball.vector.y <= bars.get(1).Y() + bars.get(1).Height() + 5) {
            boundBall();
            se01.play();
            System.out.println("bound 2p");
        }
        if (ball.vector.x >= Bong.size.Width()) {  //右壁での反射
            ball.vector.reverceX();
            ball.vector.x = Bong.size.Width() - (ball.Width() + 1);
            se02.play();
            System.out.println("descrease life 2p");
            players.get(1).decreaseLife();
        }
        if (ball.vector.y >= Bong.size.Height()) {  // 下壁での反射
            ball.vector.reverceY();
            ball.vector.y = Bong.size.Height() - (ball.Height() + 1);
            se02.play();
        }
        if (ball.vector.x <= 0) {  // 左壁での反射
            ball.vector.reverceX();
            ball.vector.x = ball.Width() - 5;
            se02.play();
            System.out.println("descrease life 1p");
            players.get(0).decreaseLife();
        }
        if (ball.vector.y <= 20) {  // 上壁での反射
            ball.vector.reverceY();
            ball.vector.y = ball.Height() + 1;
            se02.play();
        }
        ball.move();
    }

    public boolean showResultIfNeededAndJudgeGameEnd() {
        if (players.get(0).Life().Point() <= 0) {
            this.removeAll();
            this.add(new Result(players.get(1)));
            return true;
        }
        if (players.get(1).Life().Point() <= 0) {
            this.removeAll();
            this.add(new Result(players.get(0)));
            return true;
        }
        return false;
    }

    private void boundBall() {
        if (boundCounter == CHANGE_BALL_TIMING) { changeBallByRandom(); }
        // if (boundCounter == CREATE_ITEM_TIMING) { createItemByRandom(); }
        ball.vector.reverce();
        ball.vector.x += 5 * ball.vector.dx;
        ball.vector.y += 5 * ball.vector.dy;
        boundCounter++;
    }

    public void swapBar() {
        Bar tmp = bars.get(0);
        bars.set(0, bars.get(1));
        bars.set(1, tmp);
    }

    private void changeBall(int ballId) {
        Vector vec = ball.vector;
        this.remove(ball);
        ball = BallCreator.create(ballId);
        ball.vector.setPoint(vec.getPoint());
        this.add(ball);
        boundCounter = 0;
    }

    private void changeBallByRandom() {
        this.changeBall((int)(Math.random() * BallCreator.BALL_TYPE));
    }

    private void createItemByRandom() {
        Vector vec = item.vector;
        item = ItemCreator.create((int) (Math.random() * ItemCreator.ITEM_TIPE));
        item.vector.setPoint(vec.getPoint());
        this.add(item);
    }

    public static Color getBackGroundColor() { return backGroundColor; }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(backGroundColor);
        g2.fillRect(0, 0, size.Width(), size.Height());
        g2.setColor(Color.green);
        g2.drawLine((int)size.Width()/2, 0, (int)size.Width()/2, size.Height());
        g2.drawLine(0, 20, size.Width(), 20); }
}
