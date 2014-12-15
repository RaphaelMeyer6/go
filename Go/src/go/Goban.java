/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.util.ArrayList;

/**
 *
 * @author avinesse
 */
public class Goban {

    private int hauteur;
    private int largeur;
    private ArrayList<Pierre> listePierres;

    public Goban(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
    }

    public Goban(int hauteur, int largeur, ArrayList<Pierre> listePierres) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.listePierres = listePierres;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public ArrayList<Pierre> getListePierres() {
        return listePierres;
    }

    public void setListePierres(ArrayList<Pierre> listePierres) {
        this.listePierres = listePierres;
    }

    public boolean intersectionLibre(Point2D p) {
        boolean estLibre = true;
        for (Pierre pi : listePierres) {
            if (pi.getPosition().equals(p)) {
                return false;
            }
        }
        return estLibre;
    }
}
