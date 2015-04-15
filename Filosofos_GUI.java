/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Maximiliano
 */
public class Filosofos_GUI extends JFrame {

        
        private JFrame frame;
        private JTextField [] field;
        private JButton button;
        JPanel panel;
        private Imagen image;
        private BoxLayout box;

    public Filosofos_GUI() {
        super("Cena de filosofos");
        field = new JTextField[5];
        this.toFront();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        construir();
        etiquetas();
        
        
        
            
        
    }
    public final void etiquetas(){
        for(int i=0;i<field.length;i++){
            field[i]=new JTextField("hola");
            field[i].setSize(150, 25);
            field[i].setBackground(new Color(230, 230, 230));
            field[i].setForeground(Color.black);
            field[i].setCaretColor(new Color(230, 230, 230));
            field[i].setHorizontalAlignment(JTextField.CENTER);
            field[i].setFont(new Font("Arial", Font.ITALIC, 16));
            field[i].setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
        }
        System.out.println(this.getSize()+ " ahora height "+ this.getHeight()+" ahora width "+this.getWidth() );
        field[0].setLocation((int) (this.getWidth()*0.5-(field[0].getWidth()/2)), (int)(this.getHeight()*0.28-(field[0].getHeight()/2)));
        field[1].setLocation((int) (this.getWidth()*0.12-(field[0].getWidth()/2)), (int)(this.getHeight()*0.32-(field[0].getHeight()/2)));
        field[2].setLocation((int) (this.getWidth()*0.28-(field[0].getWidth()/2)), (int)(this.getHeight()*0.69-(field[0].getHeight()/2)));
        field[3].setLocation((int) (this.getWidth()*0.73-(field[0].getWidth()/2)), (int)(this.getHeight()*0.69-(field[0].getHeight()/2)));
        field[4].setLocation((int) (this.getWidth()*0.87-(field[0].getWidth()/2)), (int)(this.getHeight()*0.32-(field[0].getHeight()/2)));
            this.getContentPane().add(field[0]);
            this.getContentPane().add(field[1]);
            this.getContentPane().add(field[2]);
            this.getContentPane().add(field[3]);
            this.getContentPane().add(field[4]);
        Imagen imagen = new Imagen();
        imagen.setImagen(getClass().getResource("filo.png").getFile());
        imagen.setSize(this.getWidth(),this.getHeight()-27);
        imagen.setLocation(0, 0);
            this.getContentPane().add(imagen);
        imagen.setBackground(new Color(230, 230, 230));
    }
    public final void construir(){
        setLayout(null);
        setMinimumSize(new Dimension(800, 700));
        setSize(800, 700);
        setResizable(true);
        setLocationRelativeTo(null);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JTextField[] getField() {
        return field;
    }

    public void setField(JTextField [] field) {
        this.field = field;
    }
    public void setField(int index,JTextField field){
        this.field[index]=field;
    }
    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public Imagen getImage() {
        return image;
    }

    public void setImage(Imagen image) {
        this.image = image;
    }
}