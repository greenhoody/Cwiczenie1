/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cwiczenie1;

import java.util.ArrayList;

/**
 *
 * @author klebowsm
 * @param <T>
 */
public class Heap<T extends Comparable<T>> implements HeapInterface<T> {

    private ArrayList<T> lista = new ArrayList<>();
    private ArrayList<T> sortedList = new ArrayList<>();

    @Override
    public void put(T item) {
        lista.add(item);      
    }

    @Override
    public T pop() {
        T temporar = lista.get(0);
        lista.remove(0);
        return temporar;
    }

    private void makeHeap(int index) {
        int parentsIndex = (int)(index / 2);
        if (0 < lista.get(index).compareTo(lista.get(parentsIndex))) {
            T temp = lista.get((int)(index / 2));
            lista.set( parentsIndex , lista.get(index));
            lista.set(index, temp);
            makeHeap( parentsIndex );
        }
    }

    public ArrayList<T> sort(T[] unsortedVector) {
        for (T unsortedElement : unsortedVector) {
            put(unsortedElement);
        }
        while (!lista.isEmpty()){ 
         for (int i = 0; i < lista.size(); i++){
            makeHeap(i); 
            }
        sortedList.add(0, pop()); 
        
        }
        return sortedList;
    }
    
    public void clean(){
        lista.removeAll(lista);
    }
    
}
