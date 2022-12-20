
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class TcpServidorKalkulagailua {
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
            String eragiketa[] = cad.split(" ");
            
            if(eragiketa[1].equals("+")){
                float emaitza = Float.parseFloat(eragiketa[0]) + Float.parseFloat(eragiketa[2]);
                fSalida.println("Emaitza: " + emaitza);
            }else if(eragiketa[1].equals("-")){
                float emaitza = Float.parseFloat(eragiketa[0]) - Float.parseFloat(eragiketa[2]);
                fSalida.println("Emaitza: " + emaitza);
            }else if(eragiketa[1].equals("*")){
                float emaitza = Float.parseFloat(eragiketa[0]) * Float.parseFloat(eragiketa[2]);
                fSalida.println("Emaitza: " + emaitza);
            }else if(eragiketa[1].equals("/")){
                float emaitza = Float.parseFloat(eragiketa[0]) / Float.parseFloat(eragiketa[2]);
                fSalida.println("Emaitza: " + emaitza);
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
