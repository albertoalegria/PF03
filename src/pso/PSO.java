package pso;

import folding.Protein;
import utilities.Constants;

import java.util.ArrayList;
import java.util.Vector;

/**
 * PF03
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 29/07/16, 2:06 PM
 */
public class PSO {
    private ArrayList<Protein> proteinSwarm;
    private int swarmSize;
    private int proteinLength;
    private Protein bestGlobal;

    public PSO() {
        this.swarmSize = Constants.SWARM_SIZE;
        this.proteinLength = Constants.PROTEIN_SIZE;

        proteinSwarm = new ArrayList<>();

        generateSwarm();
    }

    private void generateSwarm() {
        for (int i = 0; i < swarmSize; i++) {
            proteinSwarm.add(new Protein(proteinLength));
        }
    }

    public void searchBestLocal() {
        for (Protein protein : proteinSwarm) {
            ArrayList<Protein> neighbors = new ArrayList<>();
            for (Protein protein1 : proteinSwarm) {
                int tmpFitness = 0;
                if (protein.getProteinFitness() > protein1.getProteinFitness()) {
                    tmpFitness = protein.getProteinFitness() - protein1.getProteinFitness();
                } else {
                    tmpFitness = protein1.getProteinFitness() - protein.getProteinFitness();
                }

                if (tmpFitness > 0 && tmpFitness < 5) {

                }
            }
        }
    }

    public void searchBestGlobal() {
        Protein bestGlobal = getBestProteinFromArray(proteinSwarm);
        this.bestGlobal = bestGlobal;

        for (Protein protein : proteinSwarm) {
            protein.setBestGlobal(bestGlobal);
        }
    }

    private Protein getBestProteinFromArray(ArrayList<Protein> searchSpace) {
        int bestFitness = 2;

        Protein best = new Protein(proteinLength);

        for (Protein protein : searchSpace) {
            int tmpFitness = 0;
            int overlap = protein.getOverlapPenalization();
            if (overlap == 0) {
                tmpFitness = protein.getEnergyLevel();
            } else {
                tmpFitness = overlap;
            }
            if (tmpFitness < bestFitness) {
                bestFitness = tmpFitness;
                best = protein;
                protein.setProteinFitness(tmpFitness);
            }

        }

        return best;/*Tmp*/
    }

}



























