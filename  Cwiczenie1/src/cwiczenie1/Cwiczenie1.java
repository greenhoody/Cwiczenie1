/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cwiczenie1;

import java.io.PrintStream;
import java.util.Random;

/**
 *
 * @author klebowsm
 */
public class Cwiczenie1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListSorter Sorter = new ListSorter();
        double[] wektor = new double[5];
        Random numbers = new Random();
        for (int i = 0; i < 5 ; i++)
            wektor[i] = numbers.nextDouble();
        double[] wynik = new double[5];
        wynik = Sorter.sort(wektor);
        for (int i = 4; i > 0 ; i--)
            if (wynik[i] < wynik[i-1])
                System.out.printf("Źle posortowane");
        System.out.printf("Koniec");
    }
}
