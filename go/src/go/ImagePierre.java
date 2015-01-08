/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 * Class that defines the graphic object for a position on the Goban
 * @author Akatosh
 */
public class ImagePierre extends JPanel{
    
    private Pierre pierre;
    private int width,height;
    private int x,y;
    private Point2D position;
    private boolean isHover;
    private Jeu game;
    
    /**
     * Constructor of the position
     * @param pierre a given stone, can be null
     * @param width the width of the image
     * @param height the height of the image
     */
    public ImagePierre(int x, int y, Pierre pierre, int width, int height, Jeu game, Point2D position){
        this.pierre=pierre;
        this.game=game;
        this.position=position;
        setNewBounds(x,y,width,height);
        this.isHover=false;
        this.setOpaque(false);
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(pierre!=null){
                    game.jouer(position, game.getJoueurJoue());
                }
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                isHover=true;
                repaint();
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                isHover=false;
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });	
    }
    /**
     * Paint the stone in black or white or do nothing if stone is set to null
     * @param g graphic object for override
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(pierre!=null){
            if(pierre.isBlanc()){
                g.setColor(Color.WHITE);
            }else{
                g.setColor(Color.BLACK);
            }
            g.fillOval((int)(width-width*0.9)/2, (int)(height-height*0.9)/2, (int)(width*0.9), (int)(height*0.9));
        }else if(isHover){
            if(game.getJoueurJoue()){
                g.setColor(new Color(255,255,255,120));
            }else{
                g.setColor(new Color(0,0,0,120));
            }
            g.fillOval((int)(width-width*0.9)/2, (int)(height-height*0.9)/2, (int)(width*0.9), (int)(height*0.9));
        }
        
    }
    public void setPierre(Pierre pierre){
        this.pierre=pierre;
    }
    public Pierre getPierre(){
        return this.pierre;
    }
    public void setNewBounds(int x, int y,int width, int height){
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        this.setBounds(this.x,this.y, this.width, this.height);
    }
}
