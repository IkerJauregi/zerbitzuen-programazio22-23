package unieibar;
import java.io.IOException;
import java.net.*;

public class SocketTCP_Zerbitzaria {

	public static void main(String[] args) throws IOException {
		int port = 6000;
		ServerSocket zerbitzaria = new ServerSocket(port);
		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa1 = zerbitzaria.accept(); // 1. bezeroa
		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("1. bezeroa konektatu da!");
		System.out.println("bezeroa1.getPort(): " + bezeroa1.getPort());
		System.out.println("bezeroa1.getLocalPort(): " + bezeroa1.getLocalPort());
		System.out.println("bezeroa1.close()");
		bezeroa1.close();
		Socket bezeroa2 = zerbitzaria.accept(); // 2. bezeroa
		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("2. bezeroa konektatu da!");
		System.out.println("bezeroa2.getPort(): " + bezeroa2.getPort());
		System.out.println("bezeroa2.getLocalPort(): " + bezeroa2.getLocalPort());
		System.out.println("bezeroa2.close()");
		bezeroa2.close();
		System.out.println("Socket TCP ZERBITZARIA itzalita. Agur!");
		zerbitzaria.close();
	}
}
