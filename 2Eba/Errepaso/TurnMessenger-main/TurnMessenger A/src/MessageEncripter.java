import java.util.ArrayList;

public class MessageEncripter {
    public static String key = "jhgkiadhkjadbgklhadklgjdfbgakldjbgladjbgldajbgfladijbgfoaidugfio0adubgfiuberoiubdfgoubdfgoubdogfiudfhdiohdiogdfg";

    public static void main(String[] args) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        String mezua = "Tengo diarrea OwO :)";
        System.out.println(mezua);
        System.out.println("----------------------");
        mezua = encript(mezua);
        System.out.println("======================");
        System.out.println(decript(mezua));
    }

    public static String encript(String mezua) {
        int luzera = mezua.length();
        int i = 0;
        char karakterea;
        for (char c : key.toCharArray()) {
            int posizioa = i % luzera;
            
            if (((int) mezua.charAt(posizioa) + (int) key.charAt(i)) > 255){
                karakterea = (char) ((mezua.charAt(posizioa) + key.charAt(i)) - 255);
            } else {
                karakterea = (char) (mezua.charAt(posizioa) + key.charAt(i));
            
            }
            char ch = karakterea;
            mezua = mezua.substring(0, posizioa) + ch + mezua.substring(posizioa + 1);
            System.out.println("Modified String = " + mezua);

            i++;
        }

        return mezua;
    }

    public static String decript(String mezua) {
        int luzera = mezua.length();
        int i = 0;
        char karakterea;
        for (char c : key.toCharArray()) {
            int posizioa = i % luzera;
            
            if (((int) mezua.charAt(posizioa) - (int) key.charAt(i)) < 0){
                karakterea = (char) ((mezua.charAt(posizioa) - key.charAt(i)) + 255);
            } else {
                karakterea = (char) (mezua.charAt(posizioa) - key.charAt(i));
            }
            char ch = karakterea;
            mezua = mezua.substring(0, posizioa) + ch + mezua.substring(posizioa + 1);
            System.out.println("Modified String = " + mezua);

            i++;
        }

        return mezua;
    }



}
