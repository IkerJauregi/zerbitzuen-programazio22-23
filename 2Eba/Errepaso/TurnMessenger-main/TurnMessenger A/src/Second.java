import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        int port = 9865;
        try (Scanner in = new Scanner(System.in)){
            ServerSocket ssocket = new ServerSocket(port);
            System.out.println("Server listening on port " + port);
            System.out.println("Waiting for Alain to connect...");
            Socket socket = ssocket.accept();
            System.out.println("Alain is online!");
            String sendData;
            while(true) {
                InputStream input = socket.getInputStream();
                DataInputStream flujoEntrada = new DataInputStream(input);
                String data = flujoEntrada.readUTF();
                System.out.println(data);
                System.out.print("Erlantz: ");
                sendData = in.nextLine();
                OutputStream output = socket.getOutputStream();
                DataOutputStream flujoSalida = new DataOutputStream(output);
                flujoSalida.writeUTF("Erlantz: " + sendData);
            }
            //socket.close();
            //ssocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
