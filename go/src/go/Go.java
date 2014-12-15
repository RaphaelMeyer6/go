/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

/**
 *
 * @author Акатош
 */
public class Go {
    
    public static void main(String [] arg){
        Goban plateau=new Goban(20,20,null);
        WindowGame test = new WindowGame(800,800,plateau);
        test.setVisible(true);
    }
}
