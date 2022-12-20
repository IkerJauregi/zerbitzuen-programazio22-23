package TCP_ObjetuaBidali;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class ZerbitzariaObjetua {
    public static void main(String[] arg) throws IOException, ClassNotFoundException {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        int numeroPuerto = 6000;// Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clienteConectado = null;
        System.out.println("Esperando al cliente ");
        clienteConectado = servidor.accept();

        //inStream = new ObjectInputStream(socket.getInputStream());

        InputStream inputStream = clienteConectado.getInputStream();

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        Objetua mezua = (Objetua) objectInputStream.readObject();

        System.out.println(mezua.toString());
    }
}
