package ariketabasikoak;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class abrirCMD {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando = "CMD /C DIR"; //minuskulas ere ahalda idatzi
        Process p = null;
        try {
            p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStream isErr = p.getErrorStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedReader brErr = new BufferedReader(new InputStreamReader(isErr));

            String linea;
            while ((linea = br.readLine()) !=null) {
                System.out.println(linea);
                br.close();
            }
        } catch (Exception e) {
            System.out.println("Error en: " + comando);
            e.printStackTrace();
        }
        // Comprobar error 0 bien -1 mal
        int exitVal;
        try{
            exitVal = p.waitFor();
            System.out.println("Valor de salida: " + exitVal);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
