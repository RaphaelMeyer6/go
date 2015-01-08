/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import javax.swing.JFrame;


/**
 * Class that defines the GUI
 * @author Akatosh
 */
public class WindowGame extends JFrame{
    private Jeu game;
    private ContentWindowGame content;
    
    /**
     * Constructor of the window with size
     * @param width the window width
     * @param height the window height
     */
    public WindowGame(int width, int height){
        this.setTitle("Jeu de GO");
        this.setSize(width, height);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }
    /**
     * Constructor of the window with size and game
     * @param width the window width
     * @param height the window height
     * @param game the game
     */
    public WindowGame(int width, int height, Jeu game){
        this(width,height);
        this.game=game;
        this.content=new ContentWindowGame(width,height,game);
        this.setContentPane(content);
    }

    public Jeu getGame() {
        return game;
    }

    public void setGame(Jeu game) {
        this.game = game;
        this.content=new ContentWindowGame(this.getWidth(),this.getHeight(),game);
        this.setContentPane(content);
    }
    
}
