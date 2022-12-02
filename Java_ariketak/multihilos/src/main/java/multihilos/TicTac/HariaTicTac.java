package multihilos.TicTac;

public class HariaTicTac extends Thread {
    String mezua = "";

    public HariaTicTac(int i) {
        if (i == 1) {
            mezua = "TIC";
        } else {
            mezua = "TAC";
            setName(mezua);
        }
    }

    public void run() {
        while (true) {
            System.out.println(mezua);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}