/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class HiloEjemplo2 extends Thread {
        public void run() {
            System.out.println("Dentro del Hilo:" + this.getName () +
            ", Prioridad: " + this.getPriority() +
            ", ID: " + this.getId());
        }
        
        public static void main(String[] args) {
            HiloEjemplo2 h = null;
            for (int i = 0; i < 3; i++) {
                h = new HiloEjemplo2 () ; //crear hilo
                h .setName("HIL0"+i); //damos nombre al hilo
                h .setPriority(i+1); //damos prioridad
                h.start(); //iniciar hilo
                System.out.println("Información del " +
                h .getName() +": "+ h .toString());
                System.out.println("3 HILOS CREADOS...");
            }// main
        }// clase
}
