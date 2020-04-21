import java.util.Scanner;
/**
 * Classe qui compare deux phrases (en français) afin de décider si elles ont
 * le même contenu (si elles sont similaires).
 * Elle lit des entrees au clavier (2 phrases) ensuite affiche une suite
 * d'indicateurs de similarité.
 * indiquant la similarite entre les deux phrases.
 *
 * <p>les entrees sont :<br></p>
 * <p>
 *     1. Premiere phrase a comparer.
 * <br></p>
 * <p>
 *     2. Deuxieme phrase à comparer avec.
 * <br></p>
 * <p>
 *     La classe calcule et affiche la similarite entre les 2 phrases à
 *     travers 4 critères : <br>
 *     a. Le nombre de correspondances entre les différents n-grammes de
 *     chaque phrase.<br>
 *     b. Le rappel entre les n-grammes homologues (ont le même n) de
 *  *     chaque phrase.<br>
 *     c. La précision entre les n-grammes homologues (ont le même n) de
 *     chaque phrase.<br>
 *     d. le f-mesure entre les n-grammes homologues (ont le même n) de
 *  *     chaque phrase.<br>
 * </p>
 * <p><br></p>
 *
 * @author AZZAM KHALED code permanent : AZZK12078506
 * @version 2020
 */
public class Principale {

    //Constantes
    public final static String SOLICITER_PHRASE_GENEREE =
            "Entrez la phrase générée : ";
    public final static String SOLICITER_PHRASE_CIBLE =
            "Entrez la phrase cible : ";

    /**
     * compare deux phrases (en français) afin de décider si elles ont
     * le même contenu (si elles sont similaires).
     * @param args non utilisé dans la méthode main
     */
    public static void main (String [] args) {

        Scanner sc = new Scanner( System.in );
        System.out.print ( SOLICITER_PHRASE_GENEREE );
        String phrase1 = sc.nextLine();
        System.out.print ( SOLICITER_PHRASE_CIBLE );
        String phrase2 = sc.nextLine();
        sc.close();

        Phrase phraseGeneree = new Phrase ( phrase1 , 1 );
        Phrase phraseCible = new Phrase ( phrase2 , 2);

        //Afficher les résultat de comparaison de similarité
        phraseGeneree.comparerA ( phraseCible );
    }
}
