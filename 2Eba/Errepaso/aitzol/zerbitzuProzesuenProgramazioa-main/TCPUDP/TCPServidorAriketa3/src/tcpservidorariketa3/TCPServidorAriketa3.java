/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcpservidorariketa3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author soto.aitzol
 */
public class TCPServidorAriketa3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int numeroPuerto = 6006;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        
        String cad="";
        
        System.out.println("Esperando conexion...");
        Socket clienteConectado = servidor.accept();
        System.out.println("Cliente conectado...");
        
        //CREO FLUJO DE SALIDA AL CLIENTE
        PrintWriter fSalida = new PrintWriter(clienteConectado.getOutputStream(),true);
        //CREO FLUJO DE ENTRADA AL CLIENTE
        BufferedReader fEntrada = new BufferedReader(new InputStreamReader(clienteConectado.getInputStream()));
        
        while((cad=fEntrada.readLine()) != null){
            System.out.println("Recibiendo " + cad);
            if(cad.equals("ES")){
                fSalida.println("Hola");
            }else if(cad.equals("EU")){
                fSalida.println("Kaixo"); 
            }else if(cad.equals("EN")){
                fSalida.println("Hello");
            }else if(cad.equals("*")){
                break;
            }
        }
        
        //CERRAR STREAMS Y SOCKETS
        System.out.println("Cerrando conexion...");
        fEntrada.close();
        fSalida.close();
        clienteConectado.close();
        servidor.close();
    }
    
}
