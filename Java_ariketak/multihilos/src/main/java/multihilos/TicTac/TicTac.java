package multihilos.TicTac;

public class TicTac extends Thread {

    public static void main(String[] args) {
        try{
            HariaTicTac hTic = new HariaTicTac(1);
            HariaTicTac hTac = new HariaTicTac(0);

            hTic.start();
            hTac.start();

            hTic.join();
            hTac.join();
        }catch(InterruptedException ex){
            System.out.println(ex);
        }
    }
}
