package ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSerbidoreAdibidea {
    public static void main(String[] args) throws IOException {
        int Puerto = 6000;
        ServerSocket Servidor = new ServerSocket(Puerto);
        System.out.println("Escuchando en " + Servidor.getLocalPort());
        System.out.println("Esperando al cliente ....");
        Socket cliente1 = Servidor.accept();
        
        System.out.println(Servidor.getLocalPort());

        //Crea el flujo de entrada del cliente
        InputStream entrada = null;
        entrada = cliente1.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        System.out.println("Recibiendo del cliente: \n\t" + flujoEntrada.readUTF());

        OutputStream salida = null;
        salida = cliente1.getOutputStream();
        DataOutputStream flujoSalida = new DataOutputStream(salida);
        flujoSalida.writeUTF("Saludos al clilente del servidor");

        entrada.close();
        flujoEntrada.close();
        salida.close();
        Servidor.close();
        flujoSalida.close();
    }
}