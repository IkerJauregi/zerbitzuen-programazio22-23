import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ErabiltzaileaObjetua {
    public static void main(String[] args) throws Exception {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Scanner sc = new Scanner(System.in);
        String Host = "127.0.0.1"; //"localhost" ipintzea berdina da
        // String Host = "192.168.65.16";
        int Puerto = 6000;// puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO....");
        System.out.println("Lehenik idatzi esaldi bat, eta ondoren sartu zenbaki bat.");
        System.out.println("Erantzuna serbitzariaren konsolan agertuko da");
        //Kaixo
        //69
        Socket Cliente = new Socket(Host, Puerto);

        OutputStream outputStream = Cliente.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        String str = sc.nextLine();
        int zenb = sc.nextInt();

        Objetua mezua = new Objetua(str, zenb);

        objectOutputStream.writeObject(mezua);

        Cliente.close();
        System.out.print("");
        sc.nextLine();
    } // main

}
