
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
public class Haria extends Thread{
    
    String mezua = "";
    
    public Haria(int i){
        if(i == 1){
            mezua = "TIC";
        }else {
            mezua = "TAC";
        }
    }
    
    @Override
    public void run(){
        while(true){
            System.out.println(mezua);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Haria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
