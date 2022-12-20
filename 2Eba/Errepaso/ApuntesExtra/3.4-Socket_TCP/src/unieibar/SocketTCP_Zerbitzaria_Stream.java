package unieibar;

import java.io.*;
import java.net.*;

public class SocketTCP_Zerbitzaria_Stream {

	public static void main(String[] args) throws IOException {
		int port = 6000;
		ServerSocket zerbitzaria = new ServerSocket(port);
		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // Bezeroa onartu
		
		// Bezeroak bidaltzen diguna jasotzeko sarrera fluxua
		InputStream is = bezeroa.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// Bezeroak mezu bat bidaltzen digu
		String mezua = dis.readUTF();
		System.out.println("Bezeroarengandik jasotakoa: " + mezua);
		
		// Bezeroari erantzuteko irteera fluxua
		OutputStream os = bezeroa.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		// Bezeroari erantzuten diogu
		dos.writeUTF("ZERBITZARIA naiz. Kaixo bezero!");
		
		//Fluxuak eta socket-ak itxi
		dos.close();
		os.close();
		dis.close();
		is.close();
		bezeroa.close();
		System.out.println("Socket TCP ZERBITZARIA itzalita. Agur!");
		zerbitzaria.close();
	}

}
