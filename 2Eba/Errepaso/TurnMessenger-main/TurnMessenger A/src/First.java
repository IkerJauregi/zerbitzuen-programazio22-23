import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        int port = 9865;
        String host = "127.0.0.1";
        try (Scanner in = new Scanner(System.in)) {
            Socket socket = new Socket(host, port);
            System.out.println("Connected!");
            while (true) {
                OutputStream output = socket.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(output);
                System.out.print("Alain: ");
                String sendData = in.nextLine();
                flujoSalida.writeUTF("Alain: " + sendData);
                InputStream input = socket.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(input);
                String data = flujoEntrada.readUTF();
                System.out.println(data);
            }
            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
