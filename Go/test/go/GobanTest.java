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
     * Test of getListePierres method, of class Goban.
     */
    @Test
    public void testGetListePierres() {
        System.out.println("getListePierres");
        Goban instance = null;
        Pierre[][] expResult = null;
        Pierre[][] result = instance.getListePierres();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListePierres method, of class Goban.
     */
    @Test
    public void testSetListePierres() {
        System.out.println("setListePierres");
        Pierre[][] listePierres = null;
        Goban instance = null;
        instance.setListePierres(listePierres);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Goban.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Goban instance = null;
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlanchesCapturees method, of class Goban.
     */
    @Test
    public void testGetBlanchesCapturees() {
        System.out.println("getBlanchesCapturees");
        Goban instance = null;
        int expResult = 0;
        int result = instance.getBlanchesCapturees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlanchesCapturees method, of class Goban.
     */
    @Test
    public void testSetBlanchesCapturees() {
        System.out.println("setBlanchesCapturees");
        int blanchesCapturees = 0;
        Goban instance = null;
        instance.setBlanchesCapturees(blanchesCapturees);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNoiresCapturees method, of class Goban.
     */
    @Test
    public void testGetNoiresCapturees() {
        System.out.println("getNoiresCapturees");
        Goban instance = null;
        int expResult = 0;
        int result = instance.getNoiresCapturees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNoiresCapturees method, of class Goban.
     */
    @Test
    public void testSetNoiresCapturees() {
        System.out.println("setNoiresCapturees");
        int noiresCapturees = 0;
        Goban instance = null;
        instance.setNoiresCapturees(noiresCapturees);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Goban.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Goban instance = null;
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class Goban.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        int height = 0;
        Goban instance = null;
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class Goban.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        int width = 0;
        Goban instance = null;
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of intersectionLibre method, of class Goban.
     */
    @Test
    public void testIntersectionLibre() {
        System.out.println("intersectionLibre");
        Point2D p = null;
        Goban instance = null;
        boolean expResult = false;
        boolean result = instance.intersectionLibre(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
