/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package go;

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
    
    private BufferedImage image;
    private Pierre pierre;
    
    public ImagePierre(Pierre pierre, int width, int height){
        this.pierre=pierre;
        this.setSize(width, height);
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(pierre!=null){
            String imgName="";
            if(pierre.isBlanc()){
                imgName="white.png";
            }else{
                imgName="black.png";
            }
            try{
                image = ImageIO.read(new File(imgName+".png"));
            }catch (IOException e){ 
                e.printStackTrace();
            } 
        }else{
            image=null;
	}
        g.drawImage(image, 0, 0, null);
        
    }
}
