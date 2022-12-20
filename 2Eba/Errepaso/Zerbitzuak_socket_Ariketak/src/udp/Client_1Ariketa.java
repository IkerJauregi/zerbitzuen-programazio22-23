package udp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author elorza.karmele
 */
public class Client_1Ariketa {//Bob
    public static void main(String[] args) throws IOException {
        byte[] bufer = new byte[1024];//bufer para recibir el datagrama 
        InetAddress destino = InetAddress.getLocalHost();
        int port = 12321; //puerto al que envió el datagrama 
        byte[] mensaje = new byte[1024];
        
        Scanner sc = new Scanner(System.in);
        Double dirua;
        do{
            System.out.println("Zenbat diru nahi diozu bidali? Max = 250€");
            dirua = sc.nextDouble();
            if(dirua > 250){
                System.out.println("Gehiegizko dirua sartu duzu.");
            }
        }while(dirua > 250);
        
        mensaje = dirua.toString().getBytes(); //codifico String a bytes
//CONSTRUYO EL DATAGRAMA A ENVIAR
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        DatagramSocket socket = new DatagramSocket(34567);//Puerto local 
        //ENVIO DATAGRAMA
        socket.send(envio);
        
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);//recibo datagrama
        //System.out.println(bufer.toString());
        mensaje = "Informazioa jasota bezeroan.".getBytes();
        envio = new DatagramPacket(mensaje, mensaje.length, destino, port);
        //ENVIO DATAGRAMA
        socket.send(envio);

        System.out.println("Enviando Datagrama de longitud: " + mensaje.length);
        System.out.println("Host destino : " + destino.getHostName());
        System.out.println("IP Destino : " + destino.getHostAddress());
        System.out.println("Puerto local del socket: " + socket.getLocalPort());
        System.out.println("Puerto al que envio: " + envio.getPort());

        
        
        
        
        
        socket.close(); //cierro el socket  
    }
}
