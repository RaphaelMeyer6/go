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
public class JeuTest {
    
    public JeuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of jouer method, of class Jeu.
     */
    @Test
    public void testJouer() {
        System.out.println("jouer");
        Joueur blanc = new Joueur (true,"Blanc");
        Joueur noir  = new Joueur (false,"Noir");
        Goban goban = new Goban (10,10);
        Jeu instance = new Jeu (goban,blanc,noir);
        Point2D point = new Point2D (3,2);
        instance.jouer(point, false);
        assertEquals(instance.joueurJoue,true);
        assertEquals(instance.passesJ1,0);
    }

    /**
     * Test of finPartie method, of class Jeu.
     */
    @Test
    public void testFinPartie() {
        System.out.println("finPartie");
        Joueur blanc = new Joueur (true,"Blanc");
        Joueur noir  = new Joueur (false,"Noir");
        Goban goban = new Goban (10,10);
        Jeu instance = new Jeu (goban,blanc,noir);
        Jeu instance2 = new Jeu (goban,blanc,noir);
        instance.passesJ1=2;
        instance.passesJ2=1;
        instance2.passesJ1=2;
        instance2.passesJ2=2;
        boolean expResult = false;
        boolean result = instance.finPartie();
        assertEquals(expResult, result);
        assertEquals(instance2.finPartie(),true);

    }

}
