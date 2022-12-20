package tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elorza.karmele
 */
public class Server_1Ariketa { //Alice
    public static void main(String[] arg) throws IOException {
        int puerto = 12321;// Puerto
        ServerSocket servidor = new ServerSocket(puerto);
        System.out.println("Escuchando en " + servidor.getLocalPort());
        System.out.println("Esperando al cliente .......");
        Socket clienteConectado = servidor.accept();
        int hilekoKop = 60;
        // CREO FLUJO DE ENTRADA DEL CLIENTE
        InputStream entrada = null;
        entrada = clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        //EL CLIENTE ME ENVIA UN MENSAJE  
        Double dinero = Double.parseDouble(flujoEntrada.readUTF());
        System.out.println("Bidalitako dirua: \n\t" + dinero);
        int hilabeteKop = (int)(dinero / hilekoKop);
        double sobratutakoDirua = dinero - (hilekoKop * hilabeteKop);
        String bidalikoDena = hilabeteKop + "#" + sobratutakoDirua;
        
// CREO FLUJO DE SALIDA AL CLIENTE
        OutputStream salida = null;
        salida = clienteConectado.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
// ENVIO UN SALUDO AL CLIENTE

        flujoSalida.writeUTF(bidalikoDena);

        System.out.println(flujoEntrada.readUTF());
        flujoSalida.writeUTF("Informazioa jasota zerbitzarian.");
// CERRAR STREAMS Y SOCKETS
        entrada.close();
        flujoEntrada.close();

        salida.close();

        flujoSalida.close();

        clienteConectado.close();

        servidor.close();
    }
}
