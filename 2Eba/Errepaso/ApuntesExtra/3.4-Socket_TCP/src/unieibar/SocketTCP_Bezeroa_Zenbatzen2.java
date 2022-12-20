package unieibar;

import java.io.*;
import java.net.*;

public class SocketTCP_Bezeroa_Zenbatzen2
{

	public static void main(String[] args) throws Exception {
		String host = "192.168.72.141";
		int port = 6000;
		
		System.out.println("Socket TCP BEZEROA martxan... ");
		
		//Socket-a ireki
		Socket socket_zerbitzariarekin = new Socket(host, port);
		
		// Zerbitzariak bidaltzen diguna jasortzeko sarrera fluxua
		InputStream is = socket_zerbitzariarekin.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// Zerbitzariak mezu bat bidaltzen digu
		String mezua = dis.readUTF();
		System.out.println("Zerbitzariarengandik jasotakoa: " + mezua);
		
		//Fluxuak eta socket-ak itxi
		dis.close();
		is.close();
		socket_zerbitzariarekin.close();
		System.out.println("Socket TCP BEZEROA itzalita. Agur!");
				

	}

}
