package Common;

public class Vector
{
    public int x;
    public int y;
    public int dx;
    public int dy;
    
    public Vector(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    
    public void reverceX() { this.dx *= -1; }
    public void reverceY() { this.dy *= -1; }
}