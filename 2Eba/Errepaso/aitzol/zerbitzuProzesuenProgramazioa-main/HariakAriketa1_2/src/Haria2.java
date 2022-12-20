
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class Haria2 extends Thread{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("TAC");
            try {
                sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(Haria1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
