package points;

/**
 * PSOPF01
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 30/06/16, 1:39 PM
 */


public class Point2D implements Point<Point2D> {

    private int x;
    private int y;

    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void add(int scalar) {
        this.x += scalar;
        this.y += scalar;
    }

    @Override
    public void add(Point2D point2D) {
        this.x += point2D.x;
        this.y += point2D.y;
    }

    @Override
    public void sub(int scalar) {
        this.x -= scalar;
        this.y -= scalar;
    }

    @Override
    public void sub(Point2D point2D) {
        this.x -= point2D.x;
        this.y -= point2D.y;
    }

    @Override
    public void mult(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }

    @Override
    public void mult(Point2D point2D) {
        this.x *= point2D.x;
        this.y *= point2D.y;
    }

    @Override
    public String toString() {
        return "Point2D[" + x + ", " + y + "]";
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Point2D point2D) {
        return this.x == point2D.getX() && this.y == point2D.getY();
    }

    public boolean inRange(Point2D point2D, int range) {
        int x1 = x + range;
        int x2 = x - range;

        int y1 = y + range;
        int y2 = y - range;

        return (point2D.getX() <= x1 && point2D.getX() >= x2) && (point2D.getY() <= y1 && point2D.getY() >= y2);
    }
}
