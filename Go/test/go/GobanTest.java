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
        //Capture d'un groupe de deux pierres adjacentes
        boolean result=false;
        Point2D p1=new Point2D(0,0);
        Point2D p2=new Point2D(0,1);
        Point2D p3=new Point2D(0,3);
        Goban instance = new Goban(10,10);
        instance.poserPierre(p1, true);
        instance.poserPierre(p2, true);
        boolean bool=instance.seSuicide(instance.getListePierres()[0][1]);
        instance.poserPierre(p3, true);
        Groupe groupe1=instance.getListePierres()[0][0].getGroupe();
        instance.captureGroupe(groupe1);
        if(instance.getBlanchesCapturees()==2){
            if (instance.getListePierres()[0][0]==null && instance.getListePierres()[0][1]==null){
                result=true;
            }
        }
        boolean expResult = true;
        assertEquals(expResult, result);
        //Capture d'un groupe consitué d'une seule pierre
        result=false;
        p1=new Point2D(0,0);
        p2=new Point2D(0,1);
        p3=new Point2D(0,3);
        instance = new Goban(10,10);
        instance.poserPierre(p1, true);
        instance.poserPierre(p2, false);
        bool=instance.seSuicide(instance.getListePierres()[0][1]);
        instance.poserPierre(p3, true);
        groupe1=instance.getListePierres()[0][0].getGroupe();
        instance.captureGroupe(groupe1);
        if(instance.getBlanchesCapturees()==1){
            if (instance.getListePierres()[0][0]==null){
                result=true;
            }
        }
        expResult = true;
        assertEquals(expResult, result);
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
        //Test d'une pierre placée dans un angle et entourée de pièces noires
        Point2D p1=new Point2D(0,0);
        Point2D p2=new Point2D(0,1);
        Point2D p3=new Point2D(1,0);
        Pierre pi1 = new Pierre(false,p1);
        Pierre[][] pierres=new Pierre[10][10];
        Goban instance = new Goban(10,10,pierres);
        instance.poserPierre(p2, false);
        instance.poserPierre(p3, true);
        boolean expResult = false;
        boolean result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
        //Test d'une pierre placée dans un angle et entourée d'au moins une pièce blanche
        p1=new Point2D(0,0);
        p2=new Point2D(0,1);
        p3=new Point2D(1,0);
        pi1 = new Pierre(false,p1);
        pierres=new Pierre[10][10];
        instance = new Goban(10,10,pierres);
        instance.poserPierre(p2, true);
        instance.poserPierre(p3, true);
        expResult = true;
        result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
        //Test d'une pierre placée sur un bord et entourée de pièces noires
        p1=new Point2D(0,0);
        p2=new Point2D(1,0);
        p3=new Point2D(2,0);
        Point2D p4=new Point2D(1,1);
        pi1 = new Pierre(false,p2);
        pierres=new Pierre[10][10];
        instance = new Goban(10,10,pierres);
        instance.poserPierre(p1, true);
        instance.poserPierre(p3, true);
        instance.poserPierre(p4, true);
        expResult = true;
        result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
        //Test d'une pierre placée sur un bord et entourée d'une pièce blanche au moins
        p1=new Point2D(0,0);
        p2=new Point2D(1,0);
        p3=new Point2D(2,0);
        p4=new Point2D(1,1);
        pi1 = new Pierre(false,p2);
        pierres=new Pierre[10][10];
        instance = new Goban(10,10,pierres);
        instance.poserPierre(p1, false);
        instance.poserPierre(p3, true);
        instance.poserPierre(p4, true);
        expResult = false;
        result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
        //Test d'une pierre au milieu du plateau et entourées de pièces noires
        p1=new Point2D(1,1);
        p2=new Point2D(1,0);
        p3=new Point2D(1,2);
        p4=new Point2D(0,1);
        Point2D p5=new Point2D(2,1);
        pi1 = new Pierre(false,p1);
        pierres=new Pierre[10][10];
        instance = new Goban(10,10,pierres);
        instance.poserPierre(p2, false);
        instance.poserPierre(p3, true);
        instance.poserPierre(p4, true);
        instance.poserPierre(p5, true);
        expResult = false;
        result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
        //Test d'une pierre au milieu du plateau et entourées de pièces noires
        p1=new Point2D(1,1);
        p2=new Point2D(1,0);
        p3=new Point2D(1,2);
        p4=new Point2D(0,1);
        p5=new Point2D(2,1);
        pi1 = new Pierre(false,p1);
        pierres=new Pierre[10][10];
        instance = new Goban(10,10,pierres);
        instance.poserPierre(p2, true);
        instance.poserPierre(p3, true);
        instance.poserPierre(p4, true);
        instance.poserPierre(p5, true);
        expResult = true;
        result = instance.seSuicide(pi1);
        assertEquals(expResult, result);
    }
    
}
