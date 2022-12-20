package unieibar;


import java.net.*;

public class SocketTCP_Bezeroa {

	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 6000;
		
		//Socket-a ireki
		Socket bezeroa = new Socket(host, port);
		
		InetAddress inAddr = bezeroa.getInetAddress();
		System.out.println("bezeroa.getLocalPort(): " + bezeroa.getLocalPort()); // LOCAL
		System.out.println("bezeroa.getPort(): " + bezeroa.getPort());	// REMOTO
		System.out.println("inAddr.getHostName().toString(): " + inAddr.getHostName().toString()); // HOST REMOTO
		System.out.println("inAddr.getHostAddress().toString(): " + inAddr.getHostAddress().toString()); // IP HOST REMOTO
		Thread.sleep(2000);
		bezeroa.close(); // socket-a itxi

	}

}
