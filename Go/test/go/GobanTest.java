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
 * @author Erwan
 */
public class GobanTest {
    
    public GobanTest() {
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
     * Test of intersectionLibre method, of class Goban.
     */
    @Test
    public void testIntersectionLibre() {
        System.out.println("intersectionLibre");
        Point2D p = new Point2D(2,2);
        Point2D p2 = new Point2D(1,1);
        Goban instance = new Goban(5,5);     
        Pierre[][] listePierres = new Pierre[5][5];
        listePierres[2][2] = new Pierre(true,p);
        instance.setListePierres(listePierres);
        
        boolean expResult = false;
        boolean result = instance.intersectionLibre(p);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.intersectionLibre(p2);
        assertEquals(expResult, result);

    }

    /**
     * Test of horsPlateau method, of class Goban.
     */
    @Test
    public void testHorsPlateau() {
        System.out.println("horsPlateau");
        Point2D p = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.horsPlateau(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bordPlateau method, of class Goban.
     */
    @Test
    public void testBordPlateau() {
        System.out.println("bordPlateau");
        Point2D p = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.bordPlateau(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coinPlateau method, of class Goban.
     */
    @Test
    public void testCoinPlateau() {
        System.out.println("coinPlateau");
        Point2D p = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.coinPlateau(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nombreLibertes method, of class Goban.
     */
    @Test
    public void testNombreLibertes() {
        System.out.println("nombreLibertes");
        Groupe g = null;
        Goban instance = null;
        int expResult = 0;
        int result = instance.nombreLibertes(g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of voisins method, of class Goban.
     */
    @Test
    public void testVoisins() {
        System.out.println("voisins");
        Pierre pi = null;
        boolean blanc = false;
        Goban instance = null;
        ArrayList<Pierre> expResult = null;
        ArrayList<Pierre> result = instance.voisins(pi, blanc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajouterGroupe method, of class Goban.
     */
    @Test
    public void testAjouterGroupe() {
        System.out.println("ajouterGroupe");
        Pierre pi = null;
        Goban instance = null;
        instance.ajouterGroupe(pi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poserPierre method, of class Goban.
     */
    @Test
    public void testPoserPierre() {
        System.out.println("poserPierre");
        Point2D p = null;
        boolean blanc = false;
        Goban instance = null;
        instance.poserPierre(p, blanc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of capture method, of class Goban.
     */
    @Test
    public void testCapture() {
        System.out.println("capture");
        Pierre p = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.capture(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of captureGroupe method, of class Goban.
     */
    @Test
    public void testCaptureGroupe() {
        System.out.println("captureGroupe");
        Groupe g = null;
        Goban instance = null;
        instance.captureGroupe(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enregistrer method, of class Goban.
     */
    @Test
    public void testEnregistrer() {
        System.out.println("enregistrer");
        String fileName = "";
        Goban instance = null;
        instance.enregistrer(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seSuicide method, of class Goban.
     */
    @Test
    public void testSeSuicide() {
        System.out.println("seSuicide");
        Pierre pi = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.seSuicide(pi);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
