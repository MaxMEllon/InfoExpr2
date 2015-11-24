package Common;

public class Area {
    public Point pos;
    public Size size;

    public Area(Point pos, Size size) {
        this.pos = pos;
        this.size = size;
    }

    public boolean isEqual(Area area) {
        return this.pos.isEqual(area.pos)
               && this.size.isEqual(area.size);
    }
}
