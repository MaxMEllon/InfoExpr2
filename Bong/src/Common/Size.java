package Common;

public class Size
{
    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isEqual(Size size) {
        return this.width == size.Width() && this.height == size.Height();
    }

    public int Width() { return this.width; }
    public int Height() { return this.height; }
}
