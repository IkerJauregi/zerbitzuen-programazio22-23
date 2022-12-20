/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP_ObjectEjemplo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Hodei
 */
public class TCPObjectEjemploServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("Esperando al cliete...."); 
        Socket cliente = servidor.accept();
        //Prepara un flujo de salida para objetos 
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        //Prepara un objeto y se envia
        Persona per = new Persona("Juan",20);
        outObjeto.writeObject(per);
        System.out.println("Envio: " + per.getIzena() + "Urteak:" + per.getUrteak());
        
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        
        Persona dato = (Persona) inObjeto.readObject();
        System.out.println("Recibido: " + dato.getIzena() + "Urteak: " + dato.getUrteak());
        
        
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();
    }
    
}
