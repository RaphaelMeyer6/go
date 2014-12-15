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
    private int blanchesCapturees;
    private int noiresCapturees;

    /**
     * Constructeur par defaut
     * @param height
     * @param width 
     */
    public Goban(int height, int width){
        this.height=height;
        this.width=width;
        listePierres = new Pierre[height][width];
        this.blanchesCapturees=0;
        this.noiresCapturees=0;
    }
    public Goban(int height, int width, Pierre[][] listePierres) {
        this.height = height;
        this.width = width;
        this.listePierres = listePierres;
        this.blanchesCapturees=0;
        this.noiresCapturees=0;
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

    public int getBlanchesCapturees() {
        return blanchesCapturees;
    }

    public void setBlanchesCapturees(int blanchesCapturees) {
        this.blanchesCapturees = blanchesCapturees;
    }

    public int getNoiresCapturees() {
        return noiresCapturees;
    }

    public void setNoiresCapturees(int noiresCapturees) {
        this.noiresCapturees = noiresCapturees;
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

    public int nombreLibertes(Groupe g) {
        int lib = 0;
        ArrayList<Point2D> listeLibertes = new ArrayList<>();
        for (Pierre pi : g.getPierres()) {
            ArrayList<Point2D> listeAdjacents = new ArrayList<>();
            Point2D nord = new Point2D(pi.getPosition().getX(), pi.getPosition().getY() + 1);
            Point2D sud = new Point2D(pi.getPosition().getX(), pi.getPosition().getY() - 1);
            Point2D est = new Point2D(pi.getPosition().getX() + 1, pi.getPosition().getY());
            Point2D ouest = new Point2D(pi.getPosition().getX() - 1, pi.getPosition().getY());
            listeAdjacents.add(nord);
            listeAdjacents.add(sud);
            listeAdjacents.add(est);
            listeAdjacents.add(ouest);

            for (Point2D p : listeAdjacents) {
                if (!horsPlateau(p) && intersectionLibre(p) && !listeLibertes.contains(p)) {
                    listeLibertes.add(p);
                    lib++;
                }
            }
        }


        return lib;
    }
    
    /**
     * Return a list of neighbours of the asked color 
     * @param pi
     * @param blanc
     * @return 
     */
    public ArrayList<Pierre> voisins(Pierre pi, boolean blanc) {
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
            if (!intersectionLibre(p) && 
                    listePierres[p.getX()][p.getY()].isBlanc()==blanc ) {
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
        
        if (voisins(pierre,pierre.isBlanc()).isEmpty()){
            ArrayList<Pierre> listeUnePierre = new ArrayList<>();
            listeUnePierre.add(pierre);
            pierre.setGroupe(new Groupe(listeUnePierre));
        }
        else for (Pierre pi : voisins(pierre,pierre.isBlanc())){
            pierre.getGroupe().fusionnerGroupes(pi.getGroupe());
        }
    }
    
     /**
     * Capture des groupes adverses 
     * 
     * @param p
     * @return 
     */
    public boolean capture(Pierre p){
        
        boolean adversairesCaptures = false;
        ArrayList<Pierre> voisinsAdverses = new ArrayList<>();
        voisinsAdverses = voisins(p,!p.isBlanc());
        if(!voisinsAdverses.isEmpty()){
            for(Pierre voisinAdverse : voisinsAdverses){
                if(this.nombreLibertes(voisinAdverse.getGroupe())==0)
                {
                    this.captureGroupe(voisinAdverse.getGroupe());
                    adversairesCaptures = true;
                }
            }
        }
        return adversairesCaptures;
    }
    
    /**
     * Capture du groupe avec modification des compteurs de pierres capturees
     * @param g 
     */
    public void captureGroupe(Groupe g){
        
        ArrayList<Pierre> pierres = g.getPierres();
        if(pierres.get(0).isBlanc()){
            this.blanchesCapturees = this.blanchesCapturees + pierres.size();
        }
        else{
            this.noiresCapturees = this.noiresCapturees+ pierres.size();
        }
        for(Pierre p : g.getPierres()){
            this.listePierres[p.getPosition().getX()][p.getPosition().getY()]
                    = null;
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
