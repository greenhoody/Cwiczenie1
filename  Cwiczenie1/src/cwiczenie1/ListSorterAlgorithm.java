/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cwiczenie1;

/**
 *
 * @author klebowsm
 * @param <T>
 */
public interface ListSorterAlgorithm<T extends Comparable<T>> {
    public T[] sort(T[] unsortedVector); // zwraca wektor posortowanych liczb typu double
}
