package hasierakoak;
public class abrirNotepad {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "NOTEPAD";
        Process p;
        try {
            p = r.exec(comando);
        } catch (Exception e) {
            System.out.println("Error e n : " + comando);
            e.printStackTrace();
        }
    }

}
