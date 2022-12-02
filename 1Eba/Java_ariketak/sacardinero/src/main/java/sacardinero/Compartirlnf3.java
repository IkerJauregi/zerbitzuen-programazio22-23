package sacardinero;

/**
 * Hello world!
 *
 */
public class Compartirlnf3 {
    public static void main(String[] args) {
        Cuenta c = new Cuenta(40);
        SacarDinero hi = new SacarDinero("Ana", c);
        SacarDinero h2 = new SacarDinero("Juan", c);
        hi.start();
        h2.start();
    }
}
