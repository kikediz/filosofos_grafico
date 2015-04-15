/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos2;

import javax.swing.JTextField;

/**
 *
 * @author maximiliano
 */
public class Main {
    Filosofos_GUI fgui;
    Cena_filosofos cena_filosofos;
    public Main(){
        fgui = new Filosofos_GUI();
        cena_filosofos=new Cena_filosofos();
        fgui.setVisible(true);
        fgui.pack();
        fgui.setResizable(false);
        agregar();
    }
    public void agregar(){
        while(true){
           JTextField[] field = fgui.getField();
           int[] estado_filosofo = Cena_filosofos.getEstado_filosofo();
           for(int i=0;i<estado_filosofo.length;i++){
               if(estado_filosofo [i]==0){
               field[i].setText("Pensando");
               }
               else if(estado_filosofo [i]==1){
                   field[i].setText("Esperando");
               }
                    else if(estado_filosofo [i]==2)
                        field[i].setText("Comiendo");
               fgui.setField(i, field[i]);
               
           }
           //fgui.setField(field);
        }
        
    }
    
    public static void main(String args[]) { 
        Thread thread = new Thread(
            new Runnable() {

            @Override
            public void run() {
                new Main();
            }
        });
        thread.start();
    }
}
