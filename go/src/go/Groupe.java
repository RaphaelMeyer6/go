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
public class Groupe {
    
    private ArrayList<Pierre> pierres;

    /**
     * Constructeur basique
     * @param pierres 
     */
    public Groupe(ArrayList<Pierre> pierres) {
        this.pierres = pierres;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Pierre> getPierres() {
        return pierres;
    }

    /**
     * 
     * @param pierres 
     */
    public void setPierres(ArrayList<Pierre> pierres) {
        this.pierres = pierres;
    }
    
    /**
     * Fusionne le groupe courant avec le groupe g
     * @param g 
     */
    public void fusionnerGroupes (Groupe g){
        for(Pierre p : g.getPierres()){
            p.setGroupe(this);
            this.getPierres().add(p);          
        }
    }
    
}
