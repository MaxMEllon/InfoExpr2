package Test;

import java.lang.RuntimeException;
import Test.Tester;
import Common.Point;
import Common.Size;
import Common.Vector;

class UnitTest
{
    private static int result = 0;
    private static Tester tester;

    public static void main(String[] args) {
        tester = new Tester();
        pointTest();
        sizeTest();
        vectorTest();
        System.exit(result);
    }

    public static void pointTest() {
        tester.it("Point Test");
        Point pos1 = new Point(2, 2);
        Point pos2 = new Point(2, 2);
        result = tester.eq(pos1.isEqual(pos2));
        pos2 = new Point(2, 3);
        result = tester.notEq(pos1.isEqual(pos2));
        pos2.move(2, 2);
        result = tester.eq(pos1.isEqual(pos2));
        pos2.move(new Point(2, 3));
        result = tester.notEq(pos1.isEqual(pos2));
        tester.end();
    }

    public static void sizeTest() {
        tester.it("Size Test");
        Size size1 = new Size(20, 20);
        Size size2 = new Size(20, 20);
        result = tester.eq(size1.isEqual(size2));
        size2 = new Size(50, 50);
        result = tester.notEq(size1.isEqual(size2));
        tester.end();
    }

    public static void vectorTest() {
        tester.it("Vector Test");
        Vector vec1 = new Vector(0, 0, -1, -1);
        Vector vec2 = new Vector(0, 0, -1, -1);
        result = tester.eq(vec1.isEqual(vec2));
        vec1.move();
        result = tester.notEq(vec1.isEqual(vec2));
        vec1.changeSpeed(2);
        result = tester.eq(vec1.dx == 2 && vec1.dy == 2);
        vec1.move();
        result = tester.eq(vec1.x == 1 && vec1.y == 1);
        vec1.stop();
        result = tester.eq(vec1.dx == 0 && vec1.dy == 0);
        tester.end();
    }
}
