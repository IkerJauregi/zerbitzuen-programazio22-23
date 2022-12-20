package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clienteUDP {
    public static void main(String[] argv) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        InetAddress destino = InetAddress.getByName("127.0.0.1");
        int port = 12345; // puerto al que envió el datagrama
        byte[] mensaje = new byte[1024];
        String Saludo = "Proba mezua";
        mensaje = Saludo.getBytes(); // codifico String a bytes
        // CONSTRUYO EL DATAGRAMA A ENVIAR
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket();// Puerto local
        System.out.println("Enviando Datagrama de longitud: " +
                mensaje.length);
        System.out.println("Host destino : " + destino.getHostName());
        System.out.println("IP Destino : " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " +
                socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());
        // ENVIO DATAGRAMA
        socket.send(envio);
        socket.close(); // cierro el socket
    }
}