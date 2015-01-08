/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Anouk
 */
public class PierreTest {
    
    public PierreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isBlanc method, of class Pierre.
     */
    @Test
    public void testIsBlanc() {
        System.out.println("isBlanc");
        Pierre instance = new Pierre (false,5,2);
        boolean expResult = false;
        boolean result = instance.isBlanc();
        assertEquals(expResult, result);

    }

    /**
     * Test of sameColor method, of class Pierre.
     */
    @Test
    public void testSameColor() {
        System.out.println("sameColor");
        Pierre p = new Pierre (true,3,6);
        Pierre instance = new Pierre (true,4,7);
        boolean expResult = true;
        boolean result = instance.sameColor(p);
        assertEquals(expResult, result);

    }

}
