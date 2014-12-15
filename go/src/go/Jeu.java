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
     * Permet de lancer une partie
     */
    public void jouer(){
        while (!finPartie()){
            if(j1.jouer(plateau)){  //Si le joueur joue on réinitialise le nombre
                passesJ1=0;         //De tours pasés
            }
            else {
                passesJ1++;         //Sinon on incremente
            }
            if(j2.jouer(plateau)){
                passesJ2=0;
            }
            else{
                passesJ2++;
            }
        }
    }
    
    /**
     * Renvois true si les deux joueurs on passés au moins 2 tours chacun d'afilé
     * @return 
     */
    public boolean finPartie(){
        return ((passesJ1>=2)&&(passesJ2>=2));
    }
}
