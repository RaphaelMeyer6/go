/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

/**
 * Classe crée pour des soucis d'évolutivité
 * Possibilité future de rentrer son nom
 * @author ebriand
 */
public class Joueur {
    
    private boolean blanc;
    private String nom;

    /**
     * Basic constructor
     * @param blanc 
     */
    public Joueur(boolean blanc) {
        this.blanc = blanc;
    }

    /**
     * Basic constructor
     * @param blanc
     * @param nom 
     */
    public Joueur(boolean blanc, String nom) {
        this(blanc);
        this.nom = nom;
    }

    /**
     * 
     * @return 
     */
    public boolean isBlanc() {
        return blanc;
    }

    /**
     * 
     * @param blanc 
     */
    public void setBlanc(boolean blanc) {
        this.blanc = blanc;
    }

    /**
     * 
     * @return 
     */
    public String getNom() {
        return nom;
    }

    /**
     * 
     * @param nom 
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    

    public boolean jouer(Goban plateau){
        boolean aJoue=false;
        
        //TODO
        
        return aJoue;
    }
    
    
}
