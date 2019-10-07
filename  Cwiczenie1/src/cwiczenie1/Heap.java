/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cwiczenie1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author klebowsm
 * @param <T>
 */
public class Heap<T extends Comparable<T>> implements HeapInterface<T>{
    
    public List lista = new ArrayList<T>();
    
    @Override
    public void put (T item){
     lista.add(item);   
    }
    @Override
    public T pop(){
        return (T) lista.get(0);
    }
    
    
}
