package uniebar;

import java.io.*;
import java.net.*;

public class Zerbitzaria {
	public static void main(String[] args) {
		System.out.println("Zerbitzaria: HASI da.");
		try {
			System.out.println("Zerbitzaria: 12345 portuan entzuten...");
			ServerSocket socketZerbitzaria = new ServerSocket(12345);
			Socket socketBezeroarekin = socketZerbitzaria.accept(); // Konexioaren zai geratu
			System.out.println("Zerbitzaria: socketBezeroarekin onartuta eta sortuta. Mezuaren zai...");
			InputStream is = socketBezeroarekin.getInputStream(); // Bezeroarekin zabaldutako socket-etik irakurtzeko
			OutputStream os = socketBezeroarekin.getOutputStream(); // Bezeroari idazteko zabaldutako fluxua
			DataInputStream dis = new DataInputStream(is); // InputStream-arekin lan egiteko objektu bat

			String str_mezua = (String) dis.readUTF(); // Mezu bat espero dugu eta irakurri egingo dugu
			System.out.println("Jasotako mezua: " + str_mezua);

			DataOutputStream dout = new DataOutputStream(os); // OutputStream-arekin lan egiteko objektu bat
			String str_bidaltzeko = "Zerbitzariak jasotakoa: " + str_mezua + ". OK!!! Agur!";
			dout.writeUTF(str_bidaltzeko); // Bezeroari itzultzeko mezua
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
