package go;

/**
 *
 * @author alexis
 */
public class Point2D {
    
    private int x;
    private int y;
    
    /**
     * Constructeur par defaut
     * @param x
     * @param y 
     */
    public Point2D(int x,int y){
        this.x=x;
        this.y=y;
    }
    /**
     * Constructeur de copie
     * @param point 
     */
    public Point2D(Point2D point){
        this.x=point.getX();
        this.y=point.getY();
    }
    /**
     * Getter X
     * @return 
     */
    public int getX(){
        return this.x;
    }
    /**
     * Getter Y
     * @return 
     */
    public int getY() {
        return this.y;
    }
    /**
     * Setter X
     * @param x 
     */
    public void setX(int x){
        this.x=x;
    }
    /**
     * Setter Y
     * @param y 
     */
    public void setY(int y){
        this.y=y;
    }
    
}
