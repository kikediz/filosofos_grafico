/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos2;

/**
 *
 * @author morte
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Imagen extends JPanel{
    private Image fondo=null;
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setOpaque(true);
        g.drawImage(fondo,0,0,getWidth(),getHeight(),null);
    }
    public void setImagen(String imagen){
        if (imagen!=null) {
            fondo=new ImageIcon(imagen).getImage();
        }
    }
    public Imagen(){
        
    }
    
}