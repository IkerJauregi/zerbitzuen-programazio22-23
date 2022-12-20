
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author soto.aitzol
 */
public class TCPClienteKalkulagailua {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6006;//puerto remoto

        System.out.println("PROGRAMA CLIENTE INICIADO....");
        Socket Cliente = new Socket(Host, Puerto);

        // CREO FLUJO DE SALIDA AL SERVIDOR 
        PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
        // CREO FLUJO DE ENTRADA AL SERVIDOR / zerbitzariak bidaltzen duena jasotzeko
        BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));

        // FLUJO PARA ENTRADA ESTANDAR / idatzitakoa jasotzeko
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String cadena, eco = "";
        System.out.print("Introduce cadena: ");
        cadena = in.readLine();//lectura por teclado 
        while (!cadena.equals("-1")) {
            fsalida.println(cadena); //envió cadena al servidor
            eco = fentrada.readLine(); //recibo cadena del servidor
            System.out.println(" =>ECO: " + eco);
            System.out.print("Introduce cadena: ");
            cadena = in.readLine();//lectura por teclado
        }
        fsalida.close();
        fentrada.close();
        System.out.println("Fin del envió... ");
        in.close();
        Cliente.close();
    }
}
