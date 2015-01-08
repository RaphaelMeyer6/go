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
 * Class that defines the Goban content
 * @author Akatosh
 */
public class ContentWindowGame extends JPanel{
    
    private Jeu game;
    private int cellWidth, cellHeight;
    private ImagePierre[][] listPositions;
    
    /**
     * Constructor of the content with size and the Goban
     * @param width the content width
     * @param height the content height
     * @param plateau the Goban
     */
    public ContentWindowGame(int width, int height, Jeu game){
        this.game=game;
        this.listPositions=new ImagePierre[this.game.getPlateau().getWidth()][this.game.getPlateau().getHeight()];
        this.setSize(width,height);
        this.setBackground(new Color(245,172,99));
        this.setLayout(null);
        for(int i=0;i<this.game.getPlateau().getWidth();i++){
            for(int j=0;j<this.game.getPlateau().getHeight();j++){
                listPositions[i][j]=new ImagePierre(0,0,game.getPlateau().getListePierres()[i][j],0,0,this.game,new Point2D(i,j));
                this.add(listPositions[i][j]);
            }
        }
    }
    /**
     * Paint the lines, background of the Goban and the stones that are in the Goban
     * @param g graphic object for override
     */
    @Override
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        cellWidth=(int)((double)this.getWidth()/((double)game.getPlateau().getWidth()+1));
        cellHeight=(int)((double)this.getHeight()/((double)game.getPlateau().getHeight()+1));
        for(int i=1;i<game.getPlateau().getWidth()+1;i++){
            g.setColor(Color.BLACK);
            g.drawLine(i*cellWidth,cellHeight,i*cellWidth,game.getPlateau().getHeight()*cellHeight);
            g.drawLine(cellWidth,i*cellHeight,game.getPlateau().getWidth()*cellWidth,i*cellHeight);
        }
        for(int i=0;i<game.getPlateau().getListePierres().length;i++){
            for(int j=0;j<game.getPlateau().getListePierres().length;j++){
                listPositions[i][j].setNewBounds(cellWidth/2+cellWidth*i+(cellWidth-(int)((double)cellWidth/1.2))/2, cellHeight/2+cellHeight*j+(cellHeight-(int)((double)cellHeight/1.2))/2, (int)((double)cellWidth/1.2), (int)((double)cellHeight/1.2));
                listPositions[i][j].setPierre(game.getPlateau().getListePierres()[i][j]);
            }
        }
    }
}
