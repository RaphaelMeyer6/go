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

    public boolean horsPlateau(Point2D p) {
        if ((p.getX() < 0) || (p.getX() >= width) || (p.getY() < 0) || (p.getY() >= height)) {
            return false;
        }
        return true;
    }

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
