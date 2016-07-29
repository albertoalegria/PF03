package points;

import java.util.ArrayList;

/**
 * PF02
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 27/07/16, 10:39 AM
 */
public class PointND implements Point<PointND> {

    public ArrayList<Integer> coordPosition;

    public PointND(int size) {
        coordPosition = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            coordPosition.add(0);
        }
    }

    public PointND(ArrayList<Integer> positions) {
        coordPosition = new ArrayList<>();
        coordPosition.addAll(positions);
    }

    @Override
    public void add(int scalar) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            tmp += scalar;
            coordPosition.set(i, tmp);
        }
    }

    @Override
    public void add(PointND pointND) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            int tmp2 = pointND.coordPosition.get(i);
            int n = tmp + tmp2;
            coordPosition.set(i, n);
        }
    }

    @Override
    public void sub(int scalar) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            tmp -= scalar;
            coordPosition.set(i, tmp);
        }
    }

    @Override
    public void sub(PointND pointND) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            int tmp2 = pointND.coordPosition.get(i);
            int n = tmp - tmp2;
            coordPosition.set(i, n);
        }
    }

    @Override
    public void mult(int scalar) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            tmp *= scalar;
            coordPosition.set(i, tmp);
        }
    }

    public void mult(double scalar) {
        for (int i = 0; i < coordPosition.size(); i++) {
            double tmp = coordPosition.get(i);
            tmp *= scalar;
            coordPosition.set(i, Math.round((float) tmp));
        }
    }

    @Override
    public void mult(PointND pointND) {
        for (int i = 0; i < coordPosition.size(); i++) {
            int tmp = coordPosition.get(i);
            int tmp2 = pointND.coordPosition.get(i);
            int n = tmp * tmp2;
            coordPosition.set(i, n);
        }
    }

    public int getPositionCoor(int position) {
        return coordPosition.get(position);
    }

    public double distanceTo(PointND pointND) {
        ArrayList<Double> vx = new ArrayList<>();
        ArrayList<Double> vy = new ArrayList<>();

        for (int i = 0; i < coordPosition.size(); i++) {
            double sub = coordPosition.get(i) - pointND.coordPosition.get(i);

            if (i % 2 == 0) {
                vx.add(sub);
            } else {
                vy.add(sub);
            }
        }

        double total = 0;
        double diff;

        for (int i = 0; i < coordPosition.size(); i++) {
            diff = coordPosition.get(i) - pointND.coordPosition.get(i);
            total += diff * diff;
        }
        return Math.sqrt(total);
    }

    public int getSize() {
        return coordPosition.size();
    }

    @Override
    public String toString() {
        String positions = "";
        for (Integer pos : coordPosition) {
            positions += String.valueOf(pos) + ", ";
        }
        positions = "Point" + coordPosition.size() + "D[" + positions.substring(0, positions.length() - 2) + "]";
        return positions;
    }
}