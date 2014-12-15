/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Akatosh
 */
public class ContentWindowGame extends JPanel{
    
    private Goban plateau;
    private int cellWidth, cellHeight;
    
    public ContentWindowGame(int width, int height, Goban plateau){
        this.plateau=plateau;
        this.setSize(width,height);
        this.setBackground(new Color(245,172,99));
        this.setLayout(null);
        
    }
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        cellWidth=(int)((double)this.getWidth()/(double)plateau.getWidth());
        cellHeight=(int)((double)this.getHeight()/(double)plateau.getHeight());
        for(int i=0;i<plateau.getWidth();i++){
            g.setColor(Color.BLACK);
            g.drawLine(i*cellWidth,0,i*cellWidth,this.getHeight());
            g.drawLine(0,i*cellHeight,this.getWidth(),i*cellHeight);
        }
        
	
        
    }
}
