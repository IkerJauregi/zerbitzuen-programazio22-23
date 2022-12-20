
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class TCPServidorObjetos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int numeroPuerto = 6006;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        
        String cad="";
        
        System.out.println("Esperando conexion...");
        Socket clienteConectado = servidor.accept();
        System.out.println("Cliente conectado...");
        
        ObjectInputStream ois = new ObjectInputStream(clienteConectado.getInputStream());
        Ikaslea ik = (Ikaslea)ois.readObject();
        
        System.out.println("Ikaslea: " + ik.getId() + "," + ik.getIzena() + " " + ik.getAbizena());
        
        //CERRAR STREAMS Y SOCKETS
        System.out.println("Cerrando conexion...");
        clienteConectado.close();
        servidor.close();
    }
}
