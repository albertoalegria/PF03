package folding;

import points.Point2D;
import utilities.Methods;

/**
 * PF03
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 28/07/16, 9:38 PM
 */

public class AminoAcid {
    private Point2D amPosition;
    private boolean amType;

    public AminoAcid() {
        amPosition = new Point2D();
        amType = Methods.getRandomType();
    }

    public AminoAcid(Point2D amPosition) {
        this.amPosition = amPosition;
        amType = Methods.getRandomType();
    }

    public void setPosition(Point2D amPosition) {
        this.amPosition = amPosition;
    }

    public boolean getType() {
        return amType;
    }

    public Point2D getPosition() {
        return amPosition;
    }

    public boolean inRange(AminoAcid aminoAcid, int range) {
        return this.amPosition.inRange(aminoAcid.getPosition(), range);
    }

    public boolean isNeighbor(AminoAcid neighbor) {
        int x = neighbor.getPosition().getX();
        int x1 = neighbor.getPosition().getX() + 1;
        int x2 = neighbor.getPosition().getX() - 1;

        int y = neighbor.getPosition().getY();
        int y1 = neighbor.getPosition().getY() + 1;
        int y2 = neighbor.getPosition().getY() - 1;

        int px = amPosition.getX();
        int py = amPosition.getY();

        return ((x == px) && (y1 == py)) || ((x2 == px) && (y == py)) || ((x == px) && (y2 == py)) || ((x1 == px) && (y == py));
    }

    public String rawData() {
        return amPosition.getX() + " " + amPosition.getY();
    }

    public boolean equals(AminoAcid aminoAcid) {
        return amPosition.equals(aminoAcid.getPosition());
    }
}
