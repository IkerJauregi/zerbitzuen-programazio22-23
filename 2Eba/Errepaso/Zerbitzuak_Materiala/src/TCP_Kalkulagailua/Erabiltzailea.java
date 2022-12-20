package TCP_Kalkulagailua;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Erabiltzailea {
    public static void main(String[] args) throws Exception {
        while (true) {

            System.out.print("\033[H\033[2J");
            System.out.flush();

            Scanner sc = new Scanner(System.in);
            String mezua;
            String Host = "127.0.0.1";
            // String Host = "192.168.65.16";
            int Puerto = 6000;// puerto remoto
            System.out.println("PROGRAMA CLIENTE INICIADO....");
            System.out.println("Idatzi zerbait eta zerbitzariak \"Kaixo!\" erantzungo du.");
            System.out.println("Idatzi zerbait \"kalkulagailua 5 * 6\" formatuarekin, eta zerbitzariak erantzuna bueltatuko du.");
            Socket Cliente = new Socket(Host, Puerto);
            // CREO FLUJO DE SALIDA AL SERVIDOR
            DataOutputStream flujoSalida = new DataOutputStream(Cliente.getOutputStream());
            // ENVIO UN SALUDO AL SERVIDOR
            mezua = sc.nextLine();
            flujoSalida.writeUTF(mezua);
            // kalkulagailua 5 * 6
            // kaixo
            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(Cliente.getInputStream());
            // EL SERVIDOR ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del SERVIDOR: \n\t" +
                    flujoEntrada.readUTF());
            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            Cliente.close();
            System.out.print("");
            sc.nextLine();
        } // main
    }
}
