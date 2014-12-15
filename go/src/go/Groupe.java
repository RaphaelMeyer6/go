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

    public Groupe(ArrayList<Pierre> pierres) {
        this.pierres = pierres;
    }

    public ArrayList<Pierre> getPierres() {
        return pierres;
    }

    public void setPierres(ArrayList<Pierre> pierres) {
        this.pierres = pierres;
    }
    
    public void fusionnerGroupes (Groupe g){
        
    }
    
}
