/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cwiczenie1;

import java.lang.Double;
import java.util.ArrayList;

/**
 *
 * @author klebowsm
 */
public class ListSorter implements ListSorterAlgorithm {

    public Heap<Double> kopiec = new Heap<>();
    ArrayList<Double> lista = new ArrayList<>();

    @Override
    public double[] sort(double[] unsortedVector) { 
        kopiec.clean();
        double[] sortedVector = new double[unsortedVector.length];
        Double[] comparableVector = new Double[unsortedVector.length];
        for (int i = 0; i < unsortedVector.length; i++) {
            comparableVector[i] = unsortedVector[i];
        }
        lista = kopiec.sort(comparableVector);
        for (int a = 0; a < unsortedVector.length; a++) {
            sortedVector[a] = lista.get(a);
        }
        return sortedVector;
    }

}
