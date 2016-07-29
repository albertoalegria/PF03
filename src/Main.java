import folding.Protein;
import org.math.plot.Plot2DPanel;

import javax.swing.*;

/**
 * PF03
 * Created by alberto from Instituto Tecnologico de Tuxtla Gutierrez ITTG
 * At Instituto de Investigaciones en Matematicas Aplicadas y en Sistemas IIMAS
 * Mexico, DF. 29/07/16, 11:34 AM
 */
public class Main {
    public static void main(String[] args) {

        Protein protein = new Protein(8);
        protein.printRawFolding();
        protein.exportData("1");
        protein.printPositionList();
        System.out.println(protein.getOverlapPenalization() + " " + protein.getEnergyLevel());

    }
}
