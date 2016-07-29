package points;

/**
 * PSOPF01
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 30/06/16, 1:39 PM
 */
public class Point3D implements Point<Point3D> {

    public int x;
    public int y;
    public int z;

    public Point3D() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void add(int scalar) {
        this.x += scalar;
        this.y += scalar;
        this.z += scalar;
    }

    @Override
    public void add(Point3D point3D) {
        this.x += point3D.x;
        this.y += point3D.y;
        this.z += point3D.z;
    }

    @Override
    public void sub(int scalar) {
        this.x -= scalar;
        this.y -= scalar;
        this.z -= scalar;
    }

    @Override
    public void sub(Point3D point3D) {
        this.x -= point3D.x;
        this.y -= point3D.y;
        this.z -= point3D.z;
    }

    @Override
    public void mult(int scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }

    @Override
    public void mult(Point3D point3D) {
        this.x *= point3D.x;
        this.y *= point3D.y;
        this.z *= point3D.z;
    }

    @Override
    public String toString() {
        return "Point3D[" + x + ", " + y + ", " + z + "]";
    }
}
