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
    private JPanel content;
    private int cell_width;
    private int cell_height;

    public WindowGame(int width, int height){
        this.setSize(width, height);
        this.content=new JPanel();
        this.content.setBackground(Color.WHITE);
        this.content.setLayout(null);
        this.setSize(width, height);
        this.setContentPane(content);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    public WindowGame(int width, int height, Goban plateau){
        this(width,height);
        this.plateau=plateau;
        cell_width=(int)((double)this.getWidth()/(double)plateau.getWidth());
        cell_height=(int)((double)this.getHeight()/(double)plateau.getHeight());
        System.out.println(cell_width);
        for(int i=0;i<plateau.getWidth();i++){
            for(int j=0;j<plateau.getHeight();j++){
                JPanel cell = new JPanel();
                cell.setBounds(i*cell_width,j*cell_height,cell_width, cell_height);
                cell.setBackground(new Color(245,172,99));
                cell.setBorder(BorderFactory.createLineBorder(Color.black));
                this.content.add(cell);
            }
        }
        repaint();
        
    }
    

    public Goban getPlateau() {
        return plateau;
    }

    public void setPlateau(Goban plateau) {
        this.plateau = plateau;
    }
    
}
