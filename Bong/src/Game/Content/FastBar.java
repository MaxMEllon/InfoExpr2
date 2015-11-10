package Game.Content;

public class FastBar extends Bar
{
    private static final long serialVersionUID = 17463287529401859L;

    public FastBar(Color color, Point pos) {
        super(color, pos);
        this.size = new Size(10, 60);
        this.speed = 60
    }
}