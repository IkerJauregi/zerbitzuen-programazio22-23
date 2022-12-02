package multihilos;

public class HiloEjemplol extends Thread {
    private int c; // contador de cada hilo
    private int hilo;

    // constructor
    public HiloEjemplol(int hilo) {
        this.hilo = hilo;
        System.out.println("CREANDO HILO:" + hilo);
    }

    // método run
    public void run() {
        c = 0;
        while (c <= 5) {
            System.out.println("Hilo:" + hilo + " C = " + c);
            c++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        HiloEjemplol h = null;
        sleep(1000);
        for (int i = 0; i < 3; i++) {
            h = new HiloEjemplol(i + 1);
            h.start();
        }
        System.out.println("3 hilos creados.");
    }
}