import java.util.ArrayList;
import java.util.function.Function;

/**
 * Classe modélisant une phrase
 */
class Phrase {

    //Constantes
    private final static String LETTRE_CORRESPONDANCES = "c";
    private final static String LETTRE_RAPPEL = "r";
    private final static String LETTRE_PRECISION = "q";
    private final static String LETTRE_F_MESURE = "F";
    private final static String SEPARATEUR_ELEMENTS = ", ";
    private final static int NB_GRAMMES = 4;
    private final static String EGALE_A = " = ";
    private final static String FIN_LIGNE = ".\n";
    private final static String GRAMMES_DE_LA_PHRASE = "-grammes de la phrase ";
    private final static String SEPARATEUR_RESULTATS = " : ";


    //Variables d'instance
    private ArrayList<NGramme> listGrammes = new ArrayList <> ( );
    private int nPhrase;

    //Constructeur
    Phrase ( String phrase , int nPhrase ) {
        //Variables d'instance
        this.nPhrase = nPhrase;
        for (int i = 0; i < 4; i ++) {
            listGrammes.add ( new NGramme ( phrase , i + 1 ) );
        }
    }

    /*Methodes d'instance*/
    /**
     * Affiche à l'écran le resultat global représenté par :
     * 1. les n-grammes de la première phrase
     * 2. les n-grammes de la deuxième phrase
     * 3. les résultats des differentes opérations (c, r, q, F)
     */
    private void afficherGrammes ( ) {
        listGrammes.forEach ( nGramme -> afficher (
                nGramme.getnIemeGramme () +
                        //format : 1-grammes de la phrase 1 :
                        GRAMMES_DE_LA_PHRASE + nPhrase + SEPARATEUR_RESULTATS +
                nGramme.toString () ) );
    }

    /**
     * Comparer la phrase courante (this) avec une autre phrase en effectuant
     * les calcules suivants :
     * 1. c : le nombre de correspndances de mots entre les différents grammes
     * 2. r : le rappel de chaque paire de grammes homologues
     * 3. q : la précision entre chaque paire de grammes homologues
     * 4. F : le f-mesure entre chaque paire de grammes homologues
     * @param phrase la pharse à comparer avec.
     */
    void comparerA ( Phrase phrase ) {
        afficherGrammes ();
        phrase.afficherGrammes ();
        afficher ( afficherResultats ( phrase ));
    }

    /**
     * Construit le String contenant les résultats des calcules de :
     * 1. c : le nombre de correspndances de mots entre les différents grammes
     * 2. r : le rappel de chaque paire de grammes homologues
     * 3. q : la précision entre chaque paire de grammes homologues
     * 4. F : le f-mesure entre chaque paire de grammes homologues
     * @param phrase la phrase à comparer avec.
     * @return le String contenant les résultats des calcules (c, r, q, F)
     */
    private String afficherResultats ( Phrase phrase ) {
        String rappels = "";
        String precisions = "";
        String fMesure = "";
        String correspondances = "";

        for ( int i = 0; i < NB_GRAMMES; i ++) {
            correspondances += ( formate (
                    listGrammes.get ( i ).getnCorrespndances ( ) ,
                    i , LETTRE_CORRESPONDANCES , phrase )
                    .replace ( ".0" , "" ) );

            rappels += ( formate ( listGrammes.get ( i ).getRappel ( ) ,
                    i , LETTRE_RAPPEL , phrase ) );

            precisions += ( formate ( listGrammes.get ( i )
                            .getPrecision ( ) , i , LETTRE_PRECISION ,
                    phrase ) );

            fMesure += ( formate ( listGrammes.get ( i ).getfMesure () ,
                    i , LETTRE_F_MESURE , phrase ) );
        }
        return correspondances.toString ( ) + rappels + precisions + fMesure;
    }

    /**
     * Formate chaque resultat pour une opération
     * @param operation l'operation a éffectuer sur le n-gramme correspondant
     *                  (ex : rappel, précision ...etc)
     * @param index index du n-gramme dans la liste des grammes
     * @param lettre la lettre d'abrévéation représentant l'opération de calcule
     * @param phrase la phrase à comparer avec
     * @return renvoie le résultat formaté sous forme :
     *  lettre + index = resultat + ( , ou . selon le context) ( ex: r1 = 0.0, )
     */
    private String formate ( Function < NGramme, Double > operation ,
                             int index , String lettre , Phrase phrase ) {
        return lettre + ( index + 1 ) + EGALE_A +
                operation.apply ( phrase.listGrammes.get ( index ) ) +
                ( ( index == NB_GRAMMES - 1 ) ? FIN_LIGNE :
                        SEPARATEUR_ELEMENTS );
    }

    /**
     * Affiche à l'écran un String
     * @param chaineAAfficher le String à afficher à l'écran
     */
    private void afficher ( String chaineAAfficher ) {
        System.out.println ( chaineAAfficher );
    }
}
