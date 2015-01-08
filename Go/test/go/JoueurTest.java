/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ECN
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isBlanc method, of class Joueur.
     */
    @Test
    public void testIsBlanc() {
        System.out.println("isBlanc");
        Joueur instance = new Joueur(true);
        boolean expResult = true;
        boolean result = instance.isBlanc();
        assertEquals(expResult, result);
        
        Joueur instance2 = new Joueur(false);
        expResult = false;
        result = instance2.isBlanc();
        assertEquals(expResult, result);
    }

    /**
     * Test of jouer method, of class Joueur.
     */
    @Test
    public void testJouer() {
        System.out.println("jouer");
        Goban plateau = new Goban(10,10);
        Joueur instance = new Joueur(true);
        Joueur instance2 = new Joueur(true);
        instance.jouer(plateau);
        
        boolean expResult = true;
        boolean result = instance.jouer(plateau);
        assertEquals(expResult, result);
        expResult = false;
        result = instance2.jouer(plateau);
        assertEquals(expResult, result);

    }
    
}
