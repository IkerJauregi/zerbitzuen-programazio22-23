import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.flush();
                int numeroPuerto = 6001;
                ServerSocket serverSocket = new ServerSocket(numeroPuerto);
                // Al principio no abra ningun cliente conectado asique sera null
                System.out.println("El servidor esta esperando al cliente...");
                Socket cliente = serverSocket.accept();

                // Ahora para recibir datos desde el cliente
                InputStream entrada = cliente.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(entrada);

                // El mensaje del cliente
                String mensaje = flujoEntrada.readUTF();
                System.out.println("El cliente me envia: " + mensaje);

                // Ahora para enviar los datos al cliente
                OutputStream salida = cliente.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(salida);
                mensaje = Calculadora(mensaje);

                flujoSalida.writeUTF(mensaje);
                // Cerrar los Socket y los Streams
                entrada.close();
                flujoEntrada.close();
                salida.close();
                flujoSalida.close();
                cliente.close();
                serverSocket.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static String Calculadora(String mensaje) {
        String[] parts = mensaje.split(" ");
        int num1, num2, resultado = 0;

        num1 = Integer.parseInt(parts[0]);
        num2 = Integer.parseInt(parts[2]);
        switch (parts[1]) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
            default:
                break;
        }
        mensaje = num1 + " " + parts[1] + " " + num2 + " = " + Integer.toString(resultado);
        return mensaje;
    }
}
