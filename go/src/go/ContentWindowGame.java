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
    
    private Goban plateau;
    private int cellWidth, cellHeight;
    private ImagePierre[][] listPositions;
    
    /**
     * Constructor of the content with size and the Goban
     * @param width the content width
     * @param height the content height
     * @param plateau the Goban
     */
    public ContentWindowGame(int width, int height, Goban plateau){
        this.plateau=plateau;
        this.listPositions=new ImagePierre[this.plateau.getWidth()][this.plateau.getHeight()];
        this.setSize(width,height);
        this.setBackground(new Color(245,172,99));
        this.setLayout(null);
        cellWidth=(int)((double)this.getWidth()/((double)plateau.getWidth()+1));
        cellHeight=(int)((double)this.getHeight()/((double)plateau.getHeight()+1));
        for(int i=0;i<plateau.getListePierres().length;i++){
            for(int j=0;j<plateau.getListePierres().length;j++){
                ImagePierre stone = new ImagePierre(i,j,plateau.getListePierres()[i][j],(int)((double)cellWidth/1.2),(int)((double)cellHeight/1.2));
                stone.setBounds(cellWidth/2+cellWidth*i, cellHeight/2+cellHeight*j, (int)((double)cellWidth/1.3), (int)((double)cellHeight/1.3));
                listPositions[i][j]=stone;
                this.add(stone);
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
        cellWidth=(int)((double)this.getWidth()/((double)plateau.getWidth()+1));
        cellHeight=(int)((double)this.getHeight()/((double)plateau.getHeight()+1));
        for(int i=1;i<plateau.getWidth()+1;i++){
            g.setColor(Color.BLACK);
            g.drawLine(i*cellWidth,cellHeight,i*cellWidth,plateau.getHeight()*cellHeight);
            g.drawLine(cellWidth,i*cellHeight,plateau.getWidth()*cellWidth,i*cellHeight);
        }
        for(int i=0;i<plateau.getListePierres().length;i++){
            for(int j=0;j<plateau.getListePierres().length;j++){
                listPositions[i][j].setBounds(cellWidth/2+cellWidth*i+(cellWidth-(int)((double)cellWidth/1.2))/2, cellHeight/2+cellHeight*j+(cellHeight-(int)((double)cellHeight/1.2))/2, (int)((double)cellWidth/1.2), (int)((double)cellHeight/1.2));
                if(plateau.getListePierres()[i][j]!=null){
                    listPositions[i][j].setPierre(plateau.getListePierres()[i][j]);
                }
            }
        }
    }
}
