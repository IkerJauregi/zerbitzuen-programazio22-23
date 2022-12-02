package sacardinero;

import java.util.Scanner;

public class Faktoriala {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int zen1, faktorial = 1;
        System.out.println("Sartu zenbaki bat: ");
        zen1 = sc.nextInt();
        
        while(zen1 != 0){
            faktorial = faktorial * zen1;
            zen1 = zen1 - 1;
        }
        System.out.println("Zenbakiaren faktoriala da: " + faktorial);
    }
}
