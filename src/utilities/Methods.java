package utilities;

import points.Point2D;

import java.util.Random;

/**
 * PF01
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 02/07/16, 4:24 AM
 */


public class Methods {
    public static double getRandomRotation() {
        return Constants.ROTATIONS[getRandomInt(0, 3)];
    }

    public static Point2D getRandomOrientation() {
        return Constants.ORIENTATIONS[getRandomInt(0, 3)];
    }

    public static boolean getRandomType() {
        return Constants.TYPES[getRandomInt(0, 1)];
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getRandomDoubleAsInt(double min, double max) {
        return Math.round((float) getRandomDouble(min, max));
    }

    public static double getRandomDouble(double min, double max) {
        return min + (max - min) * new Random().nextDouble();
    }

    public static String getRandomDirection() {
        return Constants.POSITIONS[getRandomInt(0, 3)];
    }
}
