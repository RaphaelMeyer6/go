package go;

/**
 *
 * @author alexis
 */
public class Pierre {
    
   private boolean blanc;
   private Point2D position;
   private Groupe groupe;
   
   /**
    * Constructeur par défaut
    * @param blanc
    * @param position 
    */
   public Pierre(boolean blanc, Point2D position){
       this.blanc=blanc;
       this.position=new Point2D(position);
       this.groupe=null;
   }
   
      /**
    * Constructeur avec groupe
    * @param blanc
    * @param position 
    * @param group
    */
   public Pierre(boolean blanc, Point2D position, Groupe group){
       this.blanc=blanc;
       this.position=new Point2D(position);
       this.groupe=group;
   }
   
   /**
    * Constructeur pour une position x,y
    * @param blanc
    * @param x
    * @param y 
    */
   public Pierre(boolean blanc,int x,int y){
       this.blanc=blanc;
       this.position= new Point2D(x,y);
       this.groupe=null;
   }
      /**
    * Constructeur pour une position x,y
    * @param blanc
    * @param x
    * @param y 
    * @param group
    */
   public Pierre(boolean blanc,int x,int y,Groupe group){
       this.blanc=blanc;
       this.position= new Point2D(x,y);
       this.groupe=group;
   }
   
   
   
   /**
    * Return true if white
    * @return 
    */
   public boolean isBlanc(){
       return this.blanc;
   }
   /**
    * Return the position
    * @return 
    */
   public Point2D getPosition(){
       return this.position;
   }
   /**
    * Return true if the stones have the same color
    * @param p
    * @return 
    */
   public boolean sameColor(Pierre p){
       return this.isBlanc() == p.isBlanc();
   }

   /**
    * 
    * @return 
    */
    public Groupe getGroupe() {
        return groupe;
    }

    /**
     * 
     * @param groupe 
     */
    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
           
   
}
