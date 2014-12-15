/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Akatosh
 */
public class ImagePierre extends JPanel{
    
    private Pierre pierre;
    private int width,height;
    
    public ImagePierre(Pierre pierre, int width, int height){
        this.pierre=pierre;
        this.width=width;
        this.height=height;
        this.setBackground(null);
        this.setBounds((width/2)+width*(pierre.getPosition().getX()-1), (height/2)+height*(pierre.getPosition().getY()-1), width, height);
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(pierre.isBlanc()){
            g.setColor(Color.WHITE);
        }else{
            g.setColor(Color.BLACK);
        }
        
        g.fillOval(0, 0, width, height);
        
    }
}
