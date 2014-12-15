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
    private ArrayList<Pierre> listePierres;


    
    

    public Goban(int height, int width, ArrayList<Pierre> listePierres) {
        this.height = height;
        this.width = width;
        this.listePierres = listePierres;
    }

    public ArrayList<Pierre> getListePierres() {
        return listePierres;
    }

    public void setListePierres(ArrayList<Pierre> listePierres) {
        this.listePierres = listePierres;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

        public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
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
