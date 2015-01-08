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
        Point2D p = new Point2D(-1,1);
        Point2D p1 = new Point2D(6,5);
        Point2D p2 = new Point2D(5,6);
        Point2D p3 = new Point2D(2,2);
        Goban instance = new Goban(5,5);
        boolean expResult = true;
        boolean result = instance.horsPlateau(p);
        assertEquals(expResult, result);

        result = instance.horsPlateau(p1);
        assertEquals(expResult, result);        
        
        result = instance.horsPlateau(p2);
        assertEquals(expResult, result);       
        
        expResult = false;
        result = instance.horsPlateau(p3);
        assertEquals(expResult, result);  
    }

    /**
     * Test of bordPlateau method, of class Goban.
     */
    @Test
    public void testBordPlateau() {
        System.out.println("bordPlateau");
        Point2D p = new Point2D(0,0);
        Point2D p1 = new Point2D(-1,1);
        Point2D p2 = new Point2D(4,2);
        Point2D p3 = new Point2D(2,2);
        Goban instance = new Goban(5,5);
        
        boolean expResult = true;
        boolean result = instance.bordPlateau(p);
        assertEquals(expResult, result);
        
        expResult = false;
        result = instance.bordPlateau(p1);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.bordPlateau(p2);
        assertEquals(expResult, result);       
        
        expResult = false;
        result = instance.bordPlateau(p3);
        assertEquals(expResult, result);
    }

    /**
     * Test of coinPlateau method, of class Goban.
     */
    @Test
    public void testCoinPlateau() {
        System.out.println("coinPlateau");
        Point2D p = new Point2D(0,0);
        Point2D p1 = new Point2D(-1,1);
        Point2D p2 = new Point2D(4,4);
        Point2D p3 = new Point2D(4,3);
        Goban instance = new Goban(5,5);
        
        boolean expResult = true;
        boolean result = instance.coinPlateau(p);
        assertEquals(expResult, result);
        
        expResult = false;
        result = instance.coinPlateau(p1);
        assertEquals(expResult, result);
        
        expResult = true;
        result = instance.coinPlateau(p2);
        assertEquals(expResult, result);       
        
        expResult = false;
        result = instance.coinPlateau(p3);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of nombreLibertes method, of class Goban.
     */
    @Test
    public void testNombreLibertes() {
        System.out.println("nombreLibertes");
        Point2D p = new Point2D(0,0);
        Point2D p1 = new Point2D(0,1);
        Point2D p2 = new Point2D(1,1);
        Point2D p3 = new Point2D(1,0);
        Point2D p4 = new Point2D(4,4);
        Point2D p5 = new Point2D(2,2);
        Goban instance = new Goban(5,5);
        ArrayList<Pierre> listPG1 = new ArrayList();
        ArrayList<Pierre> listPG2 = new ArrayList();
        ArrayList<Pierre> listPG3 = new ArrayList();
        ArrayList<Pierre> listPG4 = new ArrayList();
        Pierre[][] listePierres = new Pierre[5][5];
        Pierre pi = new Pierre(true,p);
        Pierre pi1 = new Pierre (true,p1);
        Pierre pi2 = new Pierre(false,p2);
        Pierre pi3 = new Pierre (false,p3);
        Pierre pi4 = new Pierre (false,p4);
        Pierre pi5 = new Pierre (false,p5);
        listPG1.add(pi);
        listPG1.add(pi1);
        listPG2.add(pi2);
        listPG2.add(pi3);
        listPG3.add(pi4);
        listPG4.add(pi5);
        Groupe g1 = new Groupe(listPG1);
        Groupe g2 = new Groupe(listPG2);       
        Groupe g3 = new Groupe(listPG3);
        Groupe g4 = new Groupe(listPG4); 
        listePierres[0][0] = pi;
        listePierres[0][1] = pi1;
        listePierres[1][1] = pi2;
        listePierres[1][0] = pi3;
        listePierres[4][4] = pi4;
        listePierres[2][2] = pi5;
        instance.setListePierres(listePierres);
        
        
        int expResult = 1;
        int result = instance.nombreLibertes(g1);
        assertEquals(expResult, result);
        
        expResult = 3;
        result = instance.nombreLibertes(g2);
        assertEquals(expResult, result);
        
        expResult = 2;
        result = instance.nombreLibertes(g3);
        assertEquals(expResult, result);
        
        expResult = 4;
        result = instance.nombreLibertes(g4);
        assertEquals(expResult, result);        
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
