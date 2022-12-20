package unieibar;

import java.io.*;
import java.net.*;

public class SocketTCP_Bezeroa_Stream {

	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 6000;
		
		System.out.println("Socket TCP BEZEROA martxan... ");
		
		//Socket-a ireki
		Socket bezeroa = new Socket(host, port);
		
		// Zerbitzarira mezua bidaltzeko irteera fluxua sortu
		OutputStream os = bezeroa.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		// Mezua bidaltzen diot zerbitzariari
		dos.writeUTF("BEZEROA naiz. Kaixo zerbitzari!");
		
		// Zerbitzariak bidaltzen diguna jasortzeko sarrera fluxua
		InputStream is = bezeroa.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// Zerbitzariak mezu bat bidaltzen digu
		String mezua = dis.readUTF();
		System.out.println("Zerbitzariarengandik jasotakoa: " + mezua);
		
		//Fluxuak eta socket-ak itxi
		dos.close();
		os.close();
		dis.close();
		is.close();
		bezeroa.close();
		System.out.println("Socket TCP BEZEROA itzalita. Agur!");
				

	}

}
