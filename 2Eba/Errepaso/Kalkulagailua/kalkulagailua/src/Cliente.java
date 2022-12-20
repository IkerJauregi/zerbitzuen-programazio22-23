import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        while (true) {
            try {
                String mensaje;
                String host = "127.0.0.1";
                int puerto = 6001;
                int zen1, zen2;
                String operacion;

                Scanner sc = new Scanner(System.in);
                System.out.println("Programa cliente iniciado...");

                System.out.println("Primer numero: ");
                zen1 = sc.nextInt();
                System.out.println("Segundo numero: ");
                zen2 = sc.nextInt();
                System.out.println("Operación + - * /");
                operacion = sc.next();
//
                mensaje = zen1 + " " + operacion + " " + zen2;

                Socket cliente = new Socket(host, puerto);
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

                flujoSalida.writeUTF(mensaje);

                // CREO FLUJO DE ENTRADA AL SERVIDOR
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
                System.out.println("Recibiendo datos del servidor: " + flujoEntrada.readUTF());

                flujoEntrada.close();
                flujoSalida.close();
                cliente.close();
                System.out.print("");
                sc.nextLine();

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
