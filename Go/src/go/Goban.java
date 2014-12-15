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

    private int height;
    private int width;
    private Pierre[][] listePierres;

    /**
     * Constructeur par defaut
     * @param height
     * @param width 
     */
    public Goban(int height, int width){
        this.height=height;
        this.width=width;
        listePierres = new Pierre[height][width];
    }
    /**
     * Constructeur de copie de liste de pierres
     * @param height
     * @param width
     * @param listePierres 
     */
    public Goban(int height, int width, Pierre[][] listePierres) {
        this.height = height;
        this.width = width;
        this.listePierres = listePierres;
    }
    /**
     * Constructeur de copie
     * @param goban 
     */
    public Goban(Goban goban){
        this.height=goban.getHeight();
        this.width=goban.getWidth();
        this.listePierres=goban.getListePierres();
    }
    /**
     * Getter de la liste de pierres
     * @return 
     */
    public Pierre[][] getListePierres() {
        return listePierres;
    }
    /**
     * setter de la liste de pierre
     * @param listePierres 
     */
    public void setListePierres(Pierre[][] listePierres) {
        this.listePierres = listePierres;
    }
    /**
     * getter de la hauteur
     * @return 
     */
    public int getHeight() {
        return height;
    }
    /**
     * getter de la largeur
     * @return 
     */
    public int getWidth() {
        return width;
    }
    /**
     * setter de la hauteur
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * setter de la largeur
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /**
     * Renvois true si l'intersection specifie est libre
     * @param p
     * @return 
     */
    public boolean intersectionLibre(Point2D p) {
        boolean estLibre = true;
        if (listePierres[p.getX()][p.getY()]!=null){
            estLibre = false;
        }
        return estLibre;
    }
    /**
     * renvois true si la position passee est dans le plateau
     * @param p
     * @return 
     */
    public boolean horsPlateau(Point2D p) {
        if ((p.getX() < 0) || (p.getX() >= width) || (p.getY() < 0) || (p.getY() >= height)) {
            return false;
        }
        return true;
    }
    /**
     * Renvois le nombre de liberte d'une pierre
     * @param pi
     * @return 
     */
    public int nombreLibertes(Pierre pi) {
        int lib = 4;
        ArrayList<Point2D> listeAdjacents = new ArrayList<>();
        Point2D nord = new Point2D (pi.getPosition().getX(), pi.getPosition().getY()+1);
        Point2D sud = new Point2D (pi.getPosition().getX(), pi.getPosition().getY()-1);
        Point2D est = new Point2D (pi.getPosition().getX()+1, pi.getPosition().getY());
        Point2D ouest = new Point2D (pi.getPosition().getX()-1, pi.getPosition().getY());
        listeAdjacents.add(nord);
        listeAdjacents.add(sud);
        listeAdjacents.add(est);
        listeAdjacents.add(ouest);
        
        for (Point2D p : listeAdjacents) {
            if (horsPlateau(p) || !intersectionLibre(p))
            {
                lib--;
            }
        }


        return lib;
    }
}
