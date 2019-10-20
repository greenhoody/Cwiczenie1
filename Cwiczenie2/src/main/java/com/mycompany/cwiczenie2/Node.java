/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cwiczenie2;

/**
 *
 * @author nikt
 */
public class Node<K extends Comparable<K>, V> {

    Color color = Color.RED;
    Node parent, child1, child2;
    final K key;
    final V value;

    public Node(Node parent, K key, V value) {
        this.parent = parent;
        this.key = key;
        this.value = value;
        child1 = null;
        child2 = null;
    }

}
