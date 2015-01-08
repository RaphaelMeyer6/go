/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.util.ArrayList;
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
public class GroupeTest {
    
    public GroupeTest() {
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
     * Test of getPierres method, of class Groupe.
     */
    @Test
    public void testGetPierres() {
        System.out.println("getPierres");
        ArrayList<Pierre> pierres = new ArrayList<>();
        Point2D p=new Point2D(1,1);
        pierres.add(new Pierre(true,p));
        Groupe instance = new Groupe(pierres);
        ArrayList<Pierre> expResult = pierres;
        ArrayList<Pierre> result = instance.getPierres();
        assertEquals(expResult, result);

    }
    /**
     * Test of fusionnerGroupes method, of class Groupe.
     */
    @Test
    public void testFusionnerGroupes() {
        System.out.println("fusionnerGroupes");
        Point2D p=new Point2D(1,1);
        Point2D p2=new Point2D(2,2);
        
        ArrayList<Pierre> pierres = new ArrayList<>();
        Pierre Pi1=new Pierre(true,p);
        pierres.add(Pi1);
        Groupe instance = new Groupe(pierres);
        
        ArrayList<Pierre> pierres2 = new ArrayList<>();
        Pierre Pi2=new Pierre(true,p);
        pierres2.add(Pi2);
        Groupe g2 = new Groupe(pierres2);
        
        instance.fusionnerGroupes(g2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
