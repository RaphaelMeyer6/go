/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class that defines the graphic object for a position on the Goban
 * @author Akatosh
 */
public class ImagePierre extends JPanel{
    
    private Pierre pierre;
    private int width,height;
    private int x,y;
    
    /**
     * Constructor of the position
     * @param pierre a given stone, can be null
     * @param width the width of the image
     * @param height the height of the image
     */
    public ImagePierre(int x, int y, Pierre pierre, int width, int height){
        this.pierre=pierre;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        
        this.setBackground(new Color(0,0,0,0));
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Position"+x+","+y);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
        });	
    }
    /**
     * Paint the stone in black or white or do nothing if stone is null
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

            g.fillOval((width-(int)(width*0.8))/2, (height-(int)(height*0.8))/2, (int)(width*0.8), (int)(height*0.8));
        }
        
    }
    public void setPierre(Pierre pierre){
        this.pierre=pierre;
        repaint();
    }
    public Pierre getPierre(){
        return this.pierre;
    }
}
