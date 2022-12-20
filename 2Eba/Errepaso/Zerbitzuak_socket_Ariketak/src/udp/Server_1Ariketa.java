package udp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
    public static void main(String[] argv) throws Exception {
        byte[] bufer = new byte[1024];//bufer para recibir el datagrama 
//ASOCIO EL SOCKET AL PUERTO 12345
        DatagramSocket socket = new DatagramSocket(12321);
        //ESPERANDO DATAGRAMA
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12321; //puerto al que envió el datagrama 
        System.out.println("Esperando Datagrama'......... ");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);//recibo datagrama
        int bytesRec = recibo.getLength();//obtengo numero de bytes
        String paquete = new String(recibo.getData());//obtengo String 
        System.out.println("Bidalitako dirua: \n\t" + paquete.trim());
        int hilekoKop = 60;
        int hilabeteKop = (int)(Double.parseDouble(paquete.trim()) / hilekoKop);
        double sobratutakoDirua = Double.parseDouble(paquete.trim()) - (hilekoKop * hilabeteKop);
        String bidalikoDena = hilabeteKop + "#" + sobratutakoDirua;
        DatagramPacket envio = new DatagramPacket(bidalikoDena.getBytes(), bidalikoDena.length(), destino, port); //portu desberdineta bialdu berkoa? 
        socket.send(envio);
        recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);//recibo datagrama
        String mensaje = "Informazioa jasota zerbitzarian.";
        envio = new DatagramPacket(mensaje.getBytes(), mensaje.length(), destino, port);
        socket.send(envio);
//VISUALIZO INFORMACIÓN
        System.out.println("Número de Bytes recibidos: " + bytesRec);
        System.out.println("Contenido del Paquete : " + paquete.trim());
        System.out.println("Puerto origen del mensaje: " + recibo.getPort()); 
        System.out.println("IP de origen : " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje:" + socket.getLocalPort());
        socket.close(); //cierro el socket
    }
}
