package Common;

import Common.Point;

public class Vector
{
    public int x;
    public int y;
    public int dx;
    public int dy;
    public int speed = 1;

    public Vector(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx * speed;
        this.dy = dy * speed;
    }

    public void stop() {
        this.dx = 0;
        this.dy = 0;
    }

    public void move() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public void changeSpeed(int speed) {
        this.dx = speed;
        this.dy = speed;
    }

    public boolean isEqual(Vector vec) {
        return this.x == vec.x && this.y == vec.y
            && this.dx == vec.dx && this.dy == vec.dy;
    }

    public Point getPoint() { return new Point(this.x, this.y); }

    public void setPoint(Point pos) {
        this.x = pos.X();
        this.y = pos.Y();
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void reverceX() { this.dx *= -1; }

    public void reverceY() { this.dy *= -1; }

    public void reverce() {
        this.reverceX();
        this.reverceY();
    }
}
