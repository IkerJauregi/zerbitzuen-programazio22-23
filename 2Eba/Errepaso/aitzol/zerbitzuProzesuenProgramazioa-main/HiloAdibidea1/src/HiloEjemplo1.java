/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class HiloEjemplo1 extends Thread{
    private int c;
    private int hilo;
    
    //constructor
    
    public HiloEjemplo1(int hilo){
        this.hilo = hilo;
        System.out.println("Creando hilo: " + hilo);
    }
    
    public void run(){
        c = 0;
        while(c<=5){
            System.out.println("Hilo: " + hilo + " C = " + c);
            c++;
        }
    }
    
    public static void main(String[] args) {
        HiloEjemplo1 h = null;
        for (int i = 0; i < 3; i++) {
            h =  new HiloEjemplo1(i+1);
            h.start();
        }
        System.out.println("3 hilos creados");
    }
}
