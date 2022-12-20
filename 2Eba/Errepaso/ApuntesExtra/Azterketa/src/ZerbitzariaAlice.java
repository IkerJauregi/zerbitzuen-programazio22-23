
import java.io.*;
import java.net.*;

public class ZerbitzariaAlice {

    public static void main(String[] args) {
        int hilekoGaztuak = 30;
        int hileak;
        System.out.println("Alice konektatu da.");
        try {
            System.out.println("Zerbitzaria: 12321 portuan entzuten...");
            ServerSocket socketZerbitzaria = new ServerSocket(12321);
            Socket socketBezeroarekin = socketZerbitzaria.accept(); // Konexioaren zai geratu
            System.out.println("Alice: Bob onartuta eta konektatuta. diruaren zain...");
            InputStream is = socketBezeroarekin.getInputStream(); // Bezeroarekin zabaldutako socket-etik irakurtzeko
            OutputStream os = socketBezeroarekin.getOutputStream(); // Bezeroari idazteko zabaldutako fluxua
            DataInputStream dis = new DataInputStream(is); // InputStream-arekin lan egiteko objektu bat

            int dirua = (int) dis.read(); // Mezu bat espero dugu eta irakurri egingo dugu
            System.out.println("Jasotako dirua: " + dirua);

            DataOutputStream dout = new DataOutputStream(os); // OutputStream-arekin lan egiteko objektu bat
            hileak = dirua / hilekoGaztuak;
            String ordainduhilak = "Dirua jasotakoa: " + hileak + " hilak ordaindu ahal dira. OK!!!";
            
            dout.writeUTF(ordainduhilak); // Bezeroari itzultzeko mezua
            dout.flush();

            // Gure protokoloaren arabera, ez dugu ezer gehiago espero, beraz, fluxuak eta
            // socket-ak itxiko ditugu
            System.out.println("Zerbitzaria: fluxuak eta socket-ak isten...");
            dout.close();
            os.close();
            dis.close();
            is.close();
            socketBezeroarekin.close();
            socketZerbitzaria.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Zerbitzaria: BUKATU da.");
    }
}
