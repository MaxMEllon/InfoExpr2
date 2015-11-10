package Common;

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

    public void reverceX() { this.dx *= -1; }
    public void reverceY() { this.dy *= -1; }
}
