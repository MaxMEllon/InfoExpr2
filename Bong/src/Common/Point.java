package Common;

public class Point
{
    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int X() { return x; }
    public int Y() { return y; }

    public void move(Point pos) {
        this.x = pos.x;
        this.y = pos.y;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEqual(Point pos) {
        return this.x == pos.x && this.y == pos.y;
    }
}
