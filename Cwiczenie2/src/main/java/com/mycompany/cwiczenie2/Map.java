/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cwiczenie2;

/**
 *
 * @author nikt
 * @param <K>
 * @param <V>
 */
public class Map<K extends Comparable<K>, V> implements MapInterface<K, V> {

    public Node<K, V> root = null;

    @Override
    public void setValue(K key, V value) {

        if (root == null) {
            root = new Node<>(null, key, value);
            checkParentColor(root);
            return;
        }

        if (getValue(key) != null) {
            return;
        }

        Node<K, V> temp = root;

        while (true) {

            if (temp.key.compareTo(key) > 0 && temp.child1 != null) {
                temp = temp.child1;
            } else if (temp.key.compareTo(key) > 0 && temp.child1 == null) {
                temp.child1 = new Node<>(temp, key, value);
                checkParentColor(temp.child1);
                actualizeRoot(root);
                break;
            } else if (temp.child2 != null) {
                temp = temp.child2;
            } else {
                temp.child2 = new Node<>(temp, key, value);
                checkParentColor(temp.child2);
                actualizeRoot(root);
                break;
            }
        }

    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public V getValue(K key) {
        return findValue(root, key);

    }

    private V findValue(Node node, K key) {
        while (node != null && key.compareTo((K) node.key) != 0) {
            if (node.key.compareTo(key) < 0) {
                return findValue(node.child2, key);
            } else if (node.key.compareTo(key) > 0) {
                return findValue(node.child1, key);
            }
        }
        if (node == null) {
            return null;
        }
        return (V) node.value;
    }

    private void checkParentColor(Node node) {

        if (node.parent == null && node.color == Color.RED) {
            node.color = Color.BLACK;
        } else if (node.parent != null && node.parent.parent == null) {
        } else if (node.parent != null && node.parent.color == Color.RED && node.color == Color.RED) {
            // uncle is red
            if ((node.parent.color == Color.RED && node.color == Color.RED) && ((node.parent.parent.child1 == node.parent && node.parent.parent.child2 != null && node.parent.parent.child2.color == Color.RED) | (node.parent.parent.child2 == node.parent && node.parent.parent.child1 != null && node.parent.parent.child1.color == Color.RED))) {
                uncleRed(node);
            } 

// uncle is black triangle
            else if (((node.parent.child1 != null && node.parent.child1 == node && node.parent.parent.child2 == node.parent && (node.parent.parent.child1 == null || node.parent.parent.child1.color == Color.BLACK)) || (node.parent.child2 != null && node.parent.child2 == node && node.parent.parent.child1 == node.parent && (node.parent.parent.child2 == null || node.parent.parent.child2.color == Color.BLACK)))) {
                uncleBlackTriangle(node);
            } // uncle is black line
            else if (((node.parent != null && node.parent.child1 != null && node.parent.child1 == node && node.parent.parent != null && node.parent.parent.child1 != null && node.parent.parent.child1 == node.parent && (node.parent.parent.child2 == null || node.parent.parent.child2.color == Color.BLACK)) || (node.parent != null && node.parent.child2 != null && node.parent.child2 == node && node.parent.parent != null && node.parent.parent.child2 != null && node.parent.parent.child2 == node.parent && (node.parent.parent.child1 == null || node.parent.parent.child1.color == Color.BLACK)))) {
                uncleBlackLine(node);
            }

        }
    }

    private void uncleRed(Node node) {
        if (node.parent.parent.child1 == node.parent && node.parent.parent.child2 != null && node.parent.parent.child2.color == Color.RED) {
            node.parent.color = Color.BLACK;
            node.parent.parent.child2.color = Color.BLACK;
            node.parent.parent.color = Color.RED;
            checkParentColor(node.parent.parent);

        } else if (node.parent.parent.child2 == node.parent && node.parent.parent.child1 != null && node.parent.parent.child1.color == Color.RED) {
            node.parent.color = Color.BLACK;
            node.parent.parent.child1.color = Color.BLACK;
            node.parent.parent.color = Color.RED;
            checkParentColor(node.parent.parent);

        }
    }

    private void uncleBlackTriangle(Node node) {

        if (node.parent.child1 != null && node.parent.child1 == node && node.parent.parent.child2 == node.parent && (node.parent.parent.child1 == null || node.parent.parent.child1.color == Color.BLACK)) {
            rotateRight(node.parent);
            uncleBlackLine(node.child2);
        } else if (node.parent.child2 != null && node.parent.child2 == node && node.parent.parent.child1 == node.parent && (node.parent.parent.child2 == null || node.parent.parent.child2.color == Color.BLACK)) {
            rotateLeft(node.parent);
            uncleBlackLine(node.child1);
        }
    }

    private void uncleBlackLine(Node node) {

        if (node.parent != null && node.parent.child1 != null && node.parent.child1 == node && node.parent.parent != null && node.parent.parent.child1 != null && node.parent.parent.child1 == node.parent && (node.parent.parent.child2 == null || node.parent.parent.child2.color == Color.BLACK)) {
            rotateRight(node.parent.parent);
            node.parent.color = Color.BLACK;
            node.parent.child2.color = Color.RED;
            checkParentColor(node.parent);
        } else if (node.parent != null && node.parent.child2 != null && node.parent.child2 == node && node.parent.parent != null && node.parent.parent.child2 != null && node.parent.parent.child2 == node.parent && (node.parent.parent.child1 == null || node.parent.parent.child1.color == Color.BLACK)) {
            rotateLeft(node.parent.parent);
            node.parent.color = Color.BLACK;
            node.parent.child1.color = Color.RED;
            checkParentColor(node.parent);
        }
    }

    private void rotateRight(Node rotationRoot) {
        Node smaller = rotationRoot.child1;
        rotationRoot.child1 = smaller.child2;
        if (rotationRoot.child1 != null) {
            rotationRoot.child1.parent = rotationRoot;
        }
        smaller.parent = rotationRoot.parent;
        smaller.child2 = rotationRoot;
        rotationRoot.parent = smaller;
        smaller.child2.parent = smaller;
        if (smaller.parent != null) {
            if (smaller.parent.child1 == rotationRoot) {
                smaller.parent.child1 = smaller;
            } else {
                smaller.parent.child2 = smaller;
            }
        }
    }

    private void rotateLeft(Node rotationRoot) {
        Node bigger = rotationRoot.child2;
        rotationRoot.child2 = bigger.child1;
        if (rotationRoot.child2 != null) {
            rotationRoot.child2.parent = rotationRoot;
        }
        bigger.parent = rotationRoot.parent;
        bigger.child1 = rotationRoot;
        rotationRoot.parent = bigger;
        //Po indyjsku następna linijka
        bigger.child1.parent = bigger;
        if (bigger.parent != null) {
            if (bigger.parent.child1 == rotationRoot) {
                bigger.parent.child1 = bigger;
            } else {
                bigger.parent.child2 = bigger;
            }
        }
    }

    public void actualizeRoot(Node node) {
        while (node.parent != null) {
            root = node.parent;
            node = node.parent;
        }
    }
}
