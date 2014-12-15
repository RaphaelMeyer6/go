/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Akatosh
 */
public class WindowGame extends JFrame{
    private Goban plateau;
    private ContentWindowGame content;
    
    public WindowGame(int width, int height){
        this.setTitle("Jeu de GO");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public WindowGame(int width, int height, Goban plateau){
        this(width,height);
        this.plateau=plateau;
        this.content=new ContentWindowGame(width,height,plateau);
        this.setContentPane(content);
    }

    public Goban getPlateau() {
        return plateau;
    }

    public void setPlateau(Goban plateau) {
        this.plateau = plateau;
        this.content=new ContentWindowGame(this.getWidth(),this.getHeight(),plateau);
        this.setContentPane(content);
    }
    
}
