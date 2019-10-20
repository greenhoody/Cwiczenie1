/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cwiczenie2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author nikt
 */
public class Cwiczenie2 {

    public static void main(String[] args) {
        int noNodes = 1000000;
        long[] insertionTimes = new long[noNodes];
        long[] fetchTime = new long[noNodes];
        long previousTime, currentTime;

        Map<Integer, Integer> Tree = new Map<>();
        Random random = new Random(1);
        Integer[] archive = new Integer[noNodes];
        for (int i = 0; i < noNodes; i++) {
            archive[i] = random.nextInt();
            previousTime = System.nanoTime();
            Tree.setValue(archive[i], archive[i]);
            currentTime = System.nanoTime();
            insertionTimes[i] = currentTime - previousTime;
        }

        for (int i = 0; i < noNodes; i++) {
            previousTime = System.nanoTime();
            Tree.getValue(archive[i]);
            currentTime = System.nanoTime();
            fetchTime[i] = currentTime - previousTime;
        }
        Tree.actualizeRoot(Tree.root);
        colorTest(Tree.root);
        
        
        try{
            BufferedWriter writerResults = new BufferedWriter(new FileWriter("output.txt"));
            int noMean = 200;
            for(int i = 0; i < noNodes; i += noMean){
                    long meanOfInsertion;
                    long sumOfInsertion = 0;
                    long meanOfFetch;
                    long sumOfFetch = 0;
                    for (int a = 0 ; a < noMean; a ++){
                      sumOfInsertion += insertionTimes[i + a];  
                      sumOfFetch += fetchTime[i + a];
                    }
                    meanOfInsertion = sumOfInsertion/noMean;
                    meanOfFetch = sumOfFetch/noMean;
                    
                    writerResults.write(String.valueOf(i + 1) + "\t" + String.valueOf(meanOfInsertion) + "\t" + String.valueOf(meanOfFetch));
                    writerResults.newLine();
                
            }

            writerResults.close();
        } catch(IOException ex){
            System.out.println("ERROR: Could not write to file");
        }

    }

    public static void colorTest(Node test) {
        if (test.child1 == null && test.child2 == null) {
            return;
        } else if (test.color == Color.RED) {
            if (test.child1 != null && test.child1.color == Color.RED) {
                System.out.printf("To drzewo ma dziecko i rodzica czerwonego");
                return;
            } else if (test.child2 != null && test.child2.color == Color.RED) {
                System.out.printf("To drzewo ma dziecko i rodzica czerwonego");
                return;
            }

        }
        if (test.child1 != null) {
            colorTest(test.child1);
        } else if (test.child2 != null) {
            colorTest(test.child2);
        }
    }

}
