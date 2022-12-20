package tcp;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
        String Host = "localhost";
        int Puerto = 12321;//puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);
        InetAddress i = Cliente.getInetAddress();
        System.out.println("Puerto Local: " + Cliente.getLocalPort());
// CREO FLUJO DE SALIDA AL SERVIDOR
        DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
// ENVIO UN SALUDO AL SERVIDOR
        Scanner sc = new Scanner(System.in);
        Double dirua;
        do{
            System.out.println("Zenbat diru nahi diozu bidali? Max = 250€");
            dirua = sc.nextDouble();
            if(dirua > 250){
                System.out.println("Gehiegizko dirua sartu duzu.");
            }
        }while(dirua > 250);
       //Bidali dirua 
        flujoSalida.writeUTF(dirua.toString());
        
        
// CREO FLUJO DE ENTRADA AL SERVIDOR
        DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
        // EL SERVIDOR ME ENVIA UN MENSAJE
        //String bidalikoDena = hilabeteKop + "#" + sobratutakoDirua;
        String jasotakoa = flujoEntrada.readUTF();
        String[] jasotakoArray = jasotakoa.split("#");
        String hilabeteak = jasotakoArray[0];
        String sobratutakoDirua = jasotakoArray[1];
        System.out.println("Recibiendo del SERVIDOR: \n\t Hilabete kopuruak: " + hilabeteak + " sobratutako dirua: " + sobratutakoDirua + "€");
        
        flujoSalida.writeUTF("Informazioa jasota bezeroan.");
        System.out.println(flujoEntrada.readUTF());

// CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        Cliente.close();
    }
}
