package go;

/**
 *
 * @author alexis
 */
public class Jeu {
    
    Joueur j1;
    Joueur j2;
    Goban plateau;
    int tour;
    int passesJ1;
    int passesJ2;
    boolean partieFinie = false;
    boolean joueurJoue = false;
    Point2D action;
    
    
    /**
     * Constructeur de base
     */
    public Jeu(Goban plateau){
        j1 = new Joueur(false);
        j2 = new Joueur(true);
        this.plateau=plateau;
        this.tour = 1;
    }
    /**
     * Constructeur comprennant 2 joueurs
     * @param j1
     * @param j2 
     */
    public Jeu(Goban plateau, Joueur j1, Joueur j2){
        this.j1 = j1;
        this.j2 = j2;
        this.plateau=plateau;
        this.tour = 1;
    }
    /**
     * Permet de jouer un coup. si le point envoyé est [-1;-1] le joueur passe
     * son tour
     * @param point
     * @param joueur 
     */
    public void jouer(Point2D point, boolean joueur){
        this.action=point;
        this.joueurJoue = !joueur;
        if (joueur){
            if ( action.getX()==-1 && action.getY()==-1){
            passesJ1++;
            }else {
                Pierre pierre = new Pierre(joueur,point);
                plateau.poserPierre(pierre.getPosition(),pierre.isBlanc());
                passesJ1=0;
            }
        }else{
            if ( action.getX()==-1 && action.getY()==-1){
            passesJ2++;
            }else {
                Pierre pierre = new Pierre(joueur,point);
                plateau.ajouterGroupe(pierre);
                passesJ2=0;
            }
        }
        partieFinie=finPartie();
    }
    
    /**
     * Renvois true si les deux joueurs on passés au moins 2 tours chacun d'afilé
     * @return 
     */
    public boolean finPartie(){
        return (passesJ1>=2)&&(passesJ2>=2);
    }
    
    /**
     * Renvois true si c'est le tour du joueur 2
     * et false si c'est le tour du joueur 1
     * @return 
     */
    public boolean getJoueurJoue(){
        return this.joueurJoue;
    }
    
}
