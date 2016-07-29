package folding;

import points.Point2D;
import utilities.Constants;
import utilities.Methods;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * PF03
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 29/07/16, 10:47 AM
 */
public class Protein {
    private int proteinSize;
    private int overlapPenalization;
    private int energyLevel;
    private int proteinFitness;
    private String positionsString;
    private ArrayList<AminoAcid> aminoAcidFold;
    private ArrayList<Integer> positionsList;
    private Protein bestGlobal;
    private Protein bestLocal;

    public Protein(int proteinSize) {
        this.proteinSize = proteinSize;
        positionsString = "";
        aminoAcidFold = new ArrayList<>();
        positionsList = new ArrayList<>();

        aminoAcidFold.add(0, new AminoAcid());

        generateRandomString();
        generateFolding();
        updatePositionsList();

        updateEnergyLevel();
    }

    private void updatePositionsList() {
        for (AminoAcid aminoAcid : aminoAcidFold) {
            positionsList.add(aminoAcid.getPosition().getX());
            positionsList.add(aminoAcid.getPosition().getY());
        }
    }

    private void generateRandomString() {
        for (int i = 0; i < proteinSize - 1; i++) {
            positionsString+= Methods.getRandomDirection();
        }
    }

    public void updateEnergyLevel() {
        ArrayList<AminoAcid> invalid = new ArrayList<>();

        int i = 0;
        for (AminoAcid aminoAcid : aminoAcidFold) {
            for (int j = i; j < aminoAcidFold.size() - 1; j++) {
                System.out.println(i + " " + j);
                AminoAcid aminoAcid1 = aminoAcidFold.get(j);
                if (aminoAcid.getType() == Constants.HYDROPHOBIC_TYPE) {
                    if (aminoAcid1.getType() == Constants.HYDROPHOBIC_TYPE) {
                        if (aminoAcid.isNeighbor(aminoAcid1)) {
                            //System.out.println("Neigh " + aminoAcid1.getPosition().toString() + " - " + aminoAcid.getPosition().toString());
                            if (!aminoAcid1.equals(aminoAcidFold.get(i + 1))) {
                                if (!aminoAcid.equals(aminoAcid1)) {
                                    System.out.println("Neigh " + aminoAcid1.getPosition().toString() + " - " + aminoAcid.getPosition().toString());
                                    energyLevel--;
                                }
                            }
                        }
                    }
                }
            }
            i++;
        }

        /*for (int i = 0; i < aminoAcidFold.size(); i++) {
            AminoAcid aminoAcid = aminoAcidFold.get(i);
            for (int j = i; j < aminoAcidFold.size(); j++) {
                AminoAcid aminoAcid1 = aminoAcidFold.get(j);
                if (aminoAcid.getType() == Constants.HYDROPHOBIC_TYPE) {
                    if (aminoAcid1.getType() == Constants.HYDROPHOBIC_TYPE) {
                        if (!aminoAcid1.equals(aminoAcidFold.get(i + 1))) {
                        }
                    }
                }
            }
        }*/

        /*for (AminoAcid aminoAcid : aminoAcidFold) {
            if (aminoAcid.getType() == Constants.HYDROPHOBIC_TYPE) {
                for (AminoAcid aminoAcid1 : aminoAcidFold) {
                    if (aminoAcid1.getType() == Constants.HYDROPHOBIC_TYPE) {
                        if (i >= 0 && i <= aminoAcidFold.size() - 1) {
                            if (!aminoAcid1.equals(aminoAcidFold.get(i - 1)) || !aminoAcid1.equals(aminoAcidFold.get(i + 1))) {
                                if (!aminoAcid1.equals(aminoAcid)) {
                                    energyLevel--;
                                }
                            }
                        }
                    }
                    j++;
                }
            }
            i++;
        }*/

    }

    private void generateFolding() {
        for (int i = 1; i <= positionsString.length(); i++) {

            AminoAcid prev = aminoAcidFold.get(i - 1);
            AminoAcid newAminoAcid = new AminoAcid();

            if (positionsString.charAt(i - 1) == 'N') {
                newAminoAcid = new AminoAcid(new Point2D(prev.getPosition().getX() + Constants.NORTH.getX(),
                        prev.getPosition().getY() + Constants.NORTH.getY()));
            } else if (positionsString.charAt(i - 1) == 'S') {
                newAminoAcid = new AminoAcid(new Point2D(prev.getPosition().getX() + Constants.SOUTH.getX(),
                        prev.getPosition().getY() + Constants.SOUTH.getY()));
            } else if (positionsString.charAt(i - 1) == 'E') {
                newAminoAcid = new AminoAcid(new Point2D(prev.getPosition().getX() + Constants.EAST.getX(),
                        prev.getPosition().getY() + Constants.EAST.getY()));
            } else if (positionsString.charAt(i - 1) == 'W') {
                newAminoAcid = new AminoAcid(new Point2D(prev.getPosition().getX() + Constants.WEST.getX(),
                        prev.getPosition().getY() + Constants.WEST.getY()));
            } else {
                System.out.println("fuck this shit");
            }
            if (getOverlap(newAminoAcid, i)) {
                overlapPenalization++;
            }
            aminoAcidFold.add(newAminoAcid);
        }
    }

    public boolean getOverlap(AminoAcid aminoAcid, int index) {
        boolean overlapped = false;
        for (int i = 0; i < aminoAcidFold.size(); i++) {
            AminoAcid aminoAcid1 = aminoAcidFold.get(i);
            if (index != i) {
                overlapped = aminoAcid.equals(aminoAcid1);
            }
            if (overlapped) {
                break;
            }
        }
        return overlapped;
    }

    public int getOverlapPenalization() {
        return overlapPenalization;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public ArrayList<Integer> getPositionsList() {
        return positionsList;
    }

    public void printPositionList() {
        for (Integer i : positionsList) {
            System.out.println(i);
        }
    }

    public void printRawFolding() {
        for (AminoAcid aminoAcid : aminoAcidFold) {
            System.out.println(aminoAcid.rawData());
        }
    }

    public Protein getBestGlobal() {
        return this.bestGlobal;
    }
    public Protein getBestLocal() {
        return bestLocal;
    }

    public void setBestGlobal(Protein bestGlobal) {
        this.bestGlobal = bestGlobal;
    }

    public void setBestLocal(Protein bestLocal) {
        this.bestLocal = bestLocal;
    }

    public int getProteinFitness() {
        return this.proteinFitness;
    }

    public void setProteinFitness(int proteinFitness) {
        this.proteinFitness = proteinFitness;
    }

    public double[] getXArray() {
        double[] xArray = new double[aminoAcidFold.size()];
        int i = 0;
        for (AminoAcid aminoAcid : aminoAcidFold) {
            xArray[i] = aminoAcid.getPosition().getX();
            i++;
        }
        return xArray;
    }

    public double[] getYArray() {
        double[] yArray = new double[aminoAcidFold.size()];
        int i = 0;
        for (AminoAcid aminoAcid : aminoAcidFold) {
            yArray[i] = aminoAcid.getPosition().getY();
        }
        return yArray;
    }


    public void exportData(String version) {
        ArrayList<String> info = new ArrayList<>();
        ArrayList<String> htype = new ArrayList<>();
        final String path = "/Users/alberto/javaData/fold_" + version + ".txt";
        final String path2 = "/Users/alberto/javaData/fold_h_" + version + ".txt";


        for (AminoAcid aminoAcid : aminoAcidFold) {
            info.add(aminoAcid.rawData());
            if (aminoAcid.getType()==Constants.HYDROPHOBIC_TYPE) {
                htype.add(aminoAcid.rawData());
            }
        }

        Path filePath = Paths.get(path);
        Path filePath2 = Paths.get(path2);


        try {
            Files.write(filePath, info, Charset.forName("UTF-8"));
            Files.write(filePath2, htype, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
