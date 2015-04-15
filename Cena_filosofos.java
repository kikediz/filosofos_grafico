/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosofos2;

import java.math.*;
import java.util.Random;

/**
 *
 * @author morte
 */

public class Cena_filosofos extends Thread {
    // Shared by all Philosophers
    public final static int cantidad_filosofos = 5;              // Cantidad de filosofos

    public final static int estado_accion [] = {0,1,2};    //estado del filosofo : 0>pensando 1->esperando 2->comiendo

    private static int estado_filosofo[] = new int[cantidad_filosofos];    // Arreglo para supervisar el estado del filosofo

    private static Controlar ocupado = new Controlar(1);    //Controla los pelillos ocupados
    
    private static Controlar filosofo[] = new Controlar[cantidad_filosofos];    // Objeto representativo de filosofo

    public static int[] getEstado_filosofo() {
        return estado_filosofo;
    }

    public static void setEstado_filosofo(int[] aEstado_filosofo) {
        estado_filosofo = aEstado_filosofo;
    }

    public static Controlar getOcupado() {
        return ocupado;
    }

    public static void setOcupado(Controlar aOcupado) {
        ocupado = aOcupado;
    }

    public static Controlar[] getFilosofo() {
        return filosofo;
    }

    public static void setFilosofo(Controlar[] aFilosofo) {
        filosofo = aFilosofo;
    }

    //private String nombre [] = {"Descartes", "Marx", "Kierkegaard", "Spinoza", "Nietzsche"};
    
   
    
    // Instance variable
    private int identificador;                    // Identificador del filosofo
    private int palillo_izquierda;                      // Palillo de la izquierda
    private int palillo_derecha;                     // Palillo de la derecha
    
    public Cena_filosofos(){
        Cena_filosofos p[] = new Cena_filosofos[cantidad_filosofos];        //crea un arreglo de objetos de tipo Cena_filosofos

        for(int i=0; i<cantidad_filosofos; i++) {   //bucle para crear filosofos
            
            p[i] = new Cena_filosofos(i);       //inicializa el objeto Cena_filosofos
            filosofo[i] = new Controlar(0);     //Objeto que representa a los filosofos de tipo Controlar inicializado
            p[i].start();       //lanza el hilo
        }
    }
    public Cena_filosofos(int i) {             // Crear filosofo
        
        identificador = i;
        palillo_izquierda = (i+cantidad_filosofos-1) % cantidad_filosofos;               // Ubica al filosofo centado a la izquierda
        palillo_derecha = (i+1) % cantidad_filosofos;                // Ubica al filosofo centado a la derecha
    }

    @Override
    public void run() {                     // And away we go
        while(true){
            pensar();                        // Cena_filosofos is thinking
            comprobar_palillos_comer();               // Toma los palillos libres
            comer();                          // Yum-yum, spahgetti
            regresar_palillos();                    // Put both forks back on the table
        }
    }

    public void comprobar_palillos_comer(){               // Metodo para esperar turno y usar los palillos para comer
        ocupado.esperar_turno();                        // Espera el turno por los palillos
        estado_filosofo[identificador] = estado_accion[1];           // Pone el estado en espera al filosofo
        //setText("El filosofo "+nombre[identificador] +" Hambriento");
        
        test(identificador);                    // Comprueba el estado de los palillos, para comer o esperar mas
        ocupado.tomar_turno();                      // Toma el turno de los palillos
        filosofo[identificador].esperar_turno();        // Se pone a la espera por los palillos
    }

    public void regresar_palillos(){       //Metodo para tomar los palillos
        ocupado.esperar_turno();        // Espera el turno por los palillos
        estado_filosofo[identificador] = estado_accion[0];         // Cambia a estado pensando al filoso tras comer
        test(palillo_izquierda);                       // Verifica si el filosofo de la izquierda puede comer
        test(palillo_derecha);                      // Verifica si el filosofo de la derecha puede comer
        ocupado.tomar_turno();      // Toma el turno de los palillos
    }
    
    private int random(){       //metodo para generar un numero aleatorio
        return (new Random().nextInt(5001));    //genera un valor entre 0 y n-1 que se pasa por parametro
    }

    public void test(int k){                // Metodo para comprobar el estado del filosofo k
        int onLeft = (k+cantidad_filosofos-1) % cantidad_filosofos;           // Determina el filosofo sentado a la izquierda
        int onRight = (k+1) % cantidad_filosofos;            // Determina el filosofo sentado a la derecha
        if( estado_filosofo[k] == estado_accion[1]  //condicion, si filosofo k está esperando
            && estado_filosofo[onLeft] != estado_accion[2]  //y filosofo de la izquierda no esta comiendo
            && estado_filosofo[onRight] != estado_accion[2] ) { //y filosofo de la derecha no esta comiendo

            estado_filosofo[k] = estado_accion[2];  //cambia estado del filosofo k, a comiendo
            filosofo[k].tomar_turno();      //filosofo k, toma su turno para comer
        }
    }

    public void pensar(){   //Metodo para poner a pensar a un filosofo
        try {
            sleep(random());    //hace que el hilo espere n milisegundos antes de continuar ejecutandose
        } catch (InterruptedException ex){ }
    }

    public void comer(){        //metodo para que el filosofo coma
        try {
            sleep(random());        //lanza un hilo de espera de n tiempo
        } catch (InterruptedException ex){ }
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getPalillo_izquierda() {
        return palillo_izquierda;
    }

    public void setPalillo_izquierda(int palillo_izquierda) {
        this.palillo_izquierda = palillo_izquierda;
    }

    public int getPalillo_derecha() {
        return palillo_derecha;
    }

    public void setPalillo_derecha(int palillo_derecha) {
        this.palillo_derecha = palillo_derecha;
    }

   
}
