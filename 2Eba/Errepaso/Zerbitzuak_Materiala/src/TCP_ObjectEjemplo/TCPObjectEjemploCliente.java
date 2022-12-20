/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TCP_ObjectEjemplo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Hodei
 */
public class TCPObjectEjemploCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6000;
        String host = "localhost";
        
        System.out.println("Programa cliente iniciado...");
        Socket cliente = new Socket(host,numeroPuerto);
        
        ObjectInputStream perEnt = new ObjectInputStream(cliente.getInputStream());       
        Persona dato = (Persona) perEnt.readObject();
        System.out.println("Recibido del servidor: " + dato.getIzena() + " " + dato.getUrteak());
        
        //modificar objeto
        
        dato.setIzena("HodeiOlivas");
        dato.setUrteak(19);
        
        //salida para objetos
        ObjectOutputStream perOut = new ObjectOutputStream(cliente.getOutputStream());
        //envia objeto
        perOut.writeObject(dato);
        System.out.println("Enviado al cliente desde el serviodr: " + dato.getIzena() + " " + dato.getUrteak());
        
        cliente.close();
        perEnt.close();
        perOut.close();
        
    }
    
}
