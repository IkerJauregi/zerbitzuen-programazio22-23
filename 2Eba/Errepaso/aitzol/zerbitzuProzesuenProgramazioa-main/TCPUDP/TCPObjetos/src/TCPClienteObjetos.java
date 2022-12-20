
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class TCPClienteObjetos {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6006;//puerto remoto

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);
        
        //Ikaslea adibidea
        //Ikaslea ik1 = new Ikaslea(1, "Aitzol", "Soto");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Sartu izena: ");
        String izena = in.readLine();
        System.out.print("Sartu abizena: ");
        String abizena = in.readLine();
        
        Ikaslea ik2 = new Ikaslea(2, izena, abizena);
                
        ObjectOutputStream oos = new ObjectOutputStream(Cliente.getOutputStream());
        oos.writeObject(ik2);
        
        System.out.println("Fin del envió... ");
        oos.close();
        Cliente.close();
    }
}
