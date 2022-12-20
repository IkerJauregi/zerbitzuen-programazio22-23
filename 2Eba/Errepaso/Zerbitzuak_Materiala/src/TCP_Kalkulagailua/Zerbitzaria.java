package TCP_Kalkulagailua;

import java.io.*;
import java.net.*;

public class Zerbitzaria {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            int numeroPuerto = 6000;// Puerto
            ServerSocket servidor = new ServerSocket(numeroPuerto);
            Socket clienteConectado = null;
            System.out.println("Esperando al cliente ");
            clienteConectado = servidor.accept();
            // CREO FLUJO DE ENTRADA DEL CLIENTE

            InputStream entrada = null;
            entrada = clienteConectado.getInputStream();
            DataInputStream flujoEntrada = new DataInputStream(entrada);
            // EL CLIENTE ME ENVIA UN MENSAJE
            String mezua = flujoEntrada.readUTF();
            System.out.println("Recibiendo del CLIENTE: \n\t" + mezua);

            // CREO FLUJO DE SALIDA AL CLIENTE
            OutputStream salida = null;
            salida = clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);

            if (mezua.contains("kalkulagailua")) {
                mezua = kalkulagailua(mezua);
            } else {
                mezua = "Kaixo!";
            }

            flujoSalida.writeUTF(mezua);
            // CERRAR STREAMS Y SOCKETS
            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            clienteConectado.close();
            servidor.close();
        }
    }

    public static String kalkulagailua(String mezua) {
        String[] parts = mezua.split(" ");
        int zenb1, zenb2, erantzuna = 0;
        zenb1 = Integer.parseInt(parts[1]);
        zenb2 = Integer.parseInt(parts[3]);
        switch (parts[2]) {
            case "+":
                erantzuna = zenb1 + zenb2;
                break;
            case "-":
                erantzuna = zenb1 - zenb2;
                break;
            case "*":
                erantzuna = zenb1 * zenb2;
                break;
            case "/":
                erantzuna = zenb1 / zenb2;
                break;
            default:
                break;
        }
        mezua = zenb1 + " " +   parts[2] + " " + zenb2 + " = " + Integer.toString(erantzuna);
        return mezua;
    }

}
