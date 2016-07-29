package utilities;

import points.Point2D;

/**
 * PF01
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 02/07/16, 4:12 AM
 */
public class Constants {

    public static final String[] POSITIONS = {"N", "S", "E", "W"};

    public static final double DEG_TO_RAD = Math.PI / 180.0;

    //Rotation values
    private static final double ROTATE_0     = 0.0;
    private static final double ROTATE_90    = 90.0;
    private static final double ROTATE_180   = 180.0;
    private static final double ROTATE_270   = 270.0;

    //Rotation Array to get a random rotation
    public static final double[] ROTATIONS = {ROTATE_0, ROTATE_90, ROTATE_180, ROTATE_270};

    //Aminoacid types
    public static final boolean POLAR_TYPE          = false;
    public static final boolean HYDROPHOBIC_TYPE    = true;

    //Types array to ger a random type
     public static final boolean[] TYPES = {POLAR_TYPE, HYDROPHOBIC_TYPE};

    public static final Point2D NORTH  = new Point2D(0, 1);
    public static final Point2D EAST   = new Point2D(1, 0);
    public static final Point2D WEST   = new Point2D(-1, 0);
    public static final Point2D SOUTH  = new Point2D(0, -1);

    public static final Point2D[] ORIENTATIONS = {NORTH, EAST, WEST, SOUTH};

    public static final int SWARM_SIZE = 40;
    public static final int PROTEIN_SIZE = 20;

    public static final double SEARCH_GAP = 1.0;
    public static final double INERTIA = 0.7;

    public static final double C_MIN = 0.0;
    public static final double C_MAX = 1.0;

    public static final int MAX_GENERATIONS = 100;
}
