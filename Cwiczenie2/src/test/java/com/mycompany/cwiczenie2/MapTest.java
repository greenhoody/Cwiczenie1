/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cwiczenie2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nikt
 */
public class MapTest {
    
    public MapTest() {
    }

    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    
    @Test
    public void testSetValueDouble (){
    }
    
    @Test
    public void testCreatingOfNode(){
        
    }
    
    

    /**
     * Test of setValue method, of class Map.
     */
    @org.junit.jupiter.api.Test
    public void testSetValue() {
        System.out.println("setValue");
        Object key = null;
        Object value = null;
        Map instance = new Map();
        instance.setValue(key, value

    /**
     * Test of getValue method, of class Map.
     */
    @org.junit.jupiter.api.Test
    public void testGetValue() {
        System.out.println("getValue");
        Object key = null;
        Map instance = new Map();
        Object expResult = null;
        Object result = instance.getValue(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizeRoot method, of class Map.
     */
    @org.junit.jupiter.api.Test
    public void testActualizeRoot() {
        System.out.println("actualizeRoot");
        Node node = null;
        Map instance = new Map();
        instance.actualizeRoot(node);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
