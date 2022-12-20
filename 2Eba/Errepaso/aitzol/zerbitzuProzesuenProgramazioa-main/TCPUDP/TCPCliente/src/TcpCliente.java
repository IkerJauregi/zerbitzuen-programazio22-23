
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class TcpCliente {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6006;//puerto remoto
        
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);
        
        // CREO FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new
        DataOutputStream(Cliente.getOutputStream());
        
        // ENVIO UN SALUDO AL SERVIDOR
        flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");
        
        // CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream flujoEntrada = new
        DataInputStream(Cliente.getInputStream());

        // EL SERVIDOR ME ENVIA UN MENSAJE
        System.out.println("Recibiendo del SERVIDOR: \n\t" + flujoEntrada.readUTF());
        
        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close(); 
        flujoSalida.close();
        Cliente.close ();

    }
}
