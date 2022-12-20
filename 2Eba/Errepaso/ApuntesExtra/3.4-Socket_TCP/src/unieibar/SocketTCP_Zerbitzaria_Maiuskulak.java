package unieibar;
import java.io.*;
import java.net.*;

public class SocketTCP_Zerbitzaria_Maiuskulak {

	public static void main(String[] args) throws IOException {
		int port = 6000;
		String agurmezua = "*";
		ServerSocket zerbitzaria = new ServerSocket(port);
		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // 1. bezeroa
		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("Bezeroa konektatu da!");
		System.out.println(agurmezua + " jaso arte martxan egongo naiz oraingoan.");
		
		// Bezeroaren irteera fluxua 
		OutputStream os = bezeroa.getOutputStream();
		PrintWriter pwos = new PrintWriter(os, true);
		// Bezeroaren sarrera fluxua
		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String jasotakoZenb;
		String bidaltzekoTestuaHandiagoa = "Zenbakia HANDIAGOA da";
		String bidaltzekoTestuaTxikiagoa = "Zenbakia TXIKIAGOA da";
		int zenbakia = ((int) ((Math.random()*100)+1));
		
		while(null != (jasotakoZenb=br.readLine())) 
		{
			int bezeroZenb=Integer.parseInt(jasotakoZenb);  
			if(bezeroZenb==zenbakia) {
				System.out.println("ZORIONAK!");
				break;
			}else {
				if(bezeroZenb!=zenbakia & bezeroZenb>zenbakia) {
					System.out.println(bidaltzekoTestuaTxikiagoa);
				}else {
					System.out.println(bidaltzekoTestuaHandiagoa);
				}
			}
		}
		
		// Fluxuak eta socket-ak itxi
		System.out.println("Konexioak isten...");
		br.close();
		isr.close();
		is.close();
		pwos.close();
		os.close();		
		bezeroa.close();
		System.out.println("Socket TCP ZERBITZARIA itzalita. Agur!");
		zerbitzaria.close();
	}

}
