/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    public Goban(int height, int width, Pierre[][] listePierres) {
        this.height = height;
        this.width = width;
        this.listePierres = listePierres;
    }

    public Pierre[][] getListePierres() {
        return listePierres;
    }

    public void setListePierres(Pierre[][] listePierres) {
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
        if (listePierres[p.getX()][p.getY()]!=null){
            estLibre = false;
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
    
    public ArrayList<Pierre> aVoisin(Pierre pi) {
        ArrayList<Point2D> listeAdjacents = new ArrayList<>();
        ArrayList<Pierre> listeVoisins = new ArrayList<>();
        Point2D nord = new Point2D(pi.getPosition().getX(), pi.getPosition().getY() + 1);
        Point2D sud = new Point2D(pi.getPosition().getX(), pi.getPosition().getY() - 1);
        Point2D est = new Point2D(pi.getPosition().getX() + 1, pi.getPosition().getY());
        Point2D ouest = new Point2D(pi.getPosition().getX() - 1, pi.getPosition().getY());
        listeAdjacents.add(nord);
        listeAdjacents.add(sud);
        listeAdjacents.add(est);
        listeAdjacents.add(ouest);
        
        for (Point2D p : listeAdjacents) {
            if (!intersectionLibre(p) && pi.sameColor(listePierres[p.getX()][p.getY()])) {
                listeVoisins.add(listePierres[p.getX()][p.getY()]);
            }
        }
        return listeVoisins;
    }
            
    
    public void ajouterGroupe (Pierre pi){
        
    }
    
  public void poserPierre(Point2D p, boolean blanc) {
        Pierre pierre = new Pierre(blanc, p);
        this.listePierres[p.getX()][p.getY()] = pierre;
        
        if (aVoisin(pierre).isEmpty()){
            ArrayList<Pierre> listeUnePierre = new ArrayList<>();
            listeUnePierre.add(pierre);
            pierre.groupe = new Groupe(listeUnePierre);
        }
        else for (Pierre pi : aVoisin(pierre)){
            pierre.groupe.fusionnerGroupes(pi.groupe);
        }
    }
  
    public void enregistrer(String fileName){
        
        BufferedWriter bw=null;
         try{
            bw = new BufferedWriter(new FileWriter(fileName));
            for(int j=0;j<this.getHeight();j++){   
                for(int i=0;i<this.getWidth();i++){
                  if (listePierres[i][j]==null){
                      bw.write("X ");
                  }
                  else if (listePierres[i][j].isBlanc()){
                      bw.write("B ");
                  }
                  else {
                      bw.write("N ");
                  }
                }
                bw.newLine();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(bw!=null){
                try{
                    bw.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        
    }
}
