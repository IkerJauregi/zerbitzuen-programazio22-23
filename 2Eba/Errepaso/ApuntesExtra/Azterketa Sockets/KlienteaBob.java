import java.io.*;
import java.net.*;

public class KlienteaBob {
	public static void main(String[] args) {
		System.out.println("Bezeroa: HASI da.");
		try {
			System.out.println("Bezeroa: 127.0.0.1:12345 zerbitzariarekin konektatu nahian...");
			Socket socketZerbitzareakin = new Socket("127.0.0.1", 12345); // Zerbitzariarekin konektatzen saiatuko naiz
			System.out.println("Bezeroa: Konektatu da zerbitzarira. Mezua bidaltzen...");
			OutputStream os = socketZerbitzareakin.getOutputStream(); // Zerbitzariari idazteko zabaldutako OutputStream
			DataOutputStream dout = new DataOutputStream(os); // OutputStream-arekin lan egiteko objektu bat
			String bezeroaren_mezua = "Kaixo zerbitzari! Zure bezeroa naiz. Zelan?";
			dout.writeUTF(bezeroaren_mezua); // Zerbitzariari bidalitako mezua
			dout.flush();
			System.out.println("Bezeroa: Mezua bidalita. Erantzunaren zai...");

			InputStream is = socketZerbitzareakin.getInputStream(); // Zerbitzariarekin zabaldutako socket-etik
																	// irakurtzeko
			DataInputStream dis = new DataInputStream(is); // InputStream-arekin lan egiteko objektu bat
			String str_mezua = (String) dis.readUTF(); // Mezu bat espero dugu eta irakurri egingo dugu
			System.out.println("Bezeroa: Jasotako mezua: " + str_mezua);

			// Gure protokoloaren arabera, ez dugu ezer gehiago bidaliko, beraz, fluxuak eta
			// socket-a itxiko ditugu
			System.out.println("Bezeroa: Mezua bidalita eta erantzuna jasota. Fluxuak eta konexioa isten...");
			dis.close();
			is.close();
			dout.close();
			os.close();
			socketZerbitzareakin.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Bezeroa: BUKATU da.");

	}

}
