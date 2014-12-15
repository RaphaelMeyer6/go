/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
  
    public void enregistrer(String fileName){
        
        BufferedWriter bw=null;
         try{
            bw = new BufferedWriter(new FileWriter(fileName));
            bw.newLine();
            bw.write("tour");
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
    
    public Goban trouverGoban(String fileName, int tour){
        Goban plateau = new Goban(height,width);
        
        BufferedReader br=null;
        ArrayList<String> lineStack =null; 
        try{
            
            br = new BufferedReader(new FileReader(fileName));
            lineStack = new ArrayList<String>();
            String line;
            while((line=br.readLine())!=null){
                //We stack the lines readed in an array
                lineStack.add(line);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(br!=null){
                try{
                    br.close();
                    //We parse the file if everything went fine
                    plateau=parser(lineStack, tour);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
                
        return plateau;
    }
    
    
    private Goban parser(ArrayList<String> lineStack, int tour){
        Goban plateau = new Goban(height,width);
        int i=0;
        int j =0;
        ArrayList<String> goban = new ArrayList<String>();
        
        for (String s : lineStack){
            if (s.equals("tour")){
                i++;
            }
            if (i==tour){
                goban.add(s);
            }
        }
        
        i=0;
        j=0;
        for (String s: goban){
            for(String s2 : s.split(" ")){
                plateau.poserPierre(new Point2D(i,j), s2.equals("B"));
                i++;
            }
            j++;
        }
        
        return plateau;
    }
}
