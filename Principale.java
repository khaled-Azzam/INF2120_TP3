import java.util.Scanner;

public class Principale {
    public static void main (String [] args) {

        int i = 4;
        Scanner sc = new Scanner( System.in );
        System.out.print ( "Entrez la phrase générée : " );
        String phrase1 = sc.nextLine();
        System.out.print ( "Entrez la phrase cible : " );
        String phrase2 = sc.nextLine();
        sc.close();

        Phrase ph1 = new Phrase ( phrase1 );
        Phrase ph2 = new Phrase ( phrase2 );

        ph1.compareA ( ph2 );
    }
}
