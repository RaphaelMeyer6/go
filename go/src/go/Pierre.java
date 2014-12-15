package go;

/**
 *
 * @author alexis
 */
public class Pierre {
    
   boolean blanc;
   Point2D position;
   
   /**
    * Constructeur par défaut
    * @param blanc
    * @param position 
    */
   public Pierre(boolean blanc, Point2D position){
       this.blanc=blanc;
       this.position=new Point2D(position);
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
           
}
