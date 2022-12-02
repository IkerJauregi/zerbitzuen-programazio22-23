package ariketabasikoak;
public class zenbakiak {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Errorea, sartu bi zenbaki mesedez");
            System.exit(1);
        }
        try {
            int no1 = Integer.parseInt(args[0]);
            int no2 = Integer.parseInt(args[1]);
            System.out.println(no1 + no2);
        } catch (Exception e) {
            System.out.println("Errore bat gertatu da - seguru zaude bi *zenbaki* sartu dituzula?");
        }
    }
}
