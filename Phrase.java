import java.util.ArrayList;
import java.util.function.Function;

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

    //Methodes d'instance
    private void afficherGrammes ( ) {
        listGrammes.forEach ( nGramme -> afficher ( nGramme.getnGr () +
                "-grammes de la phrase " + nPhrase + " : " +
                nGramme.toString () ) );
    }

    void comparerA ( Phrase phrase ) {
        afficherGrammes ();
        phrase.afficherGrammes ();
        afficher ( afficherResultats ( phrase ));
    }

    private String afficherResultats ( Phrase phrase ) {
        StringBuilder rappel = new StringBuilder ( );
        StringBuilder precision = new StringBuilder ( );
        StringBuilder fMesure = new StringBuilder ( );
        StringBuilder correspondances = new StringBuilder ( );

        for ( int i = 0; i < NB_GRAMMES; i ++) {
            correspondances.append ( formate (
                    listGrammes.get ( i ).getnCorrespndances ( ) ,
                    i , LETTRE_CORRESPONDANCES , phrase )
                    .replace ( ".0" , "" ) );

            rappel.append ( formate ( listGrammes.get ( i ).getRappel ( ) ,
                    i , LETTRE_RAPPEL , phrase ) );

            precision.append ( formate ( listGrammes.get ( i ).getPrecision ( ) ,
                    i , LETTRE_PRECISION , phrase ) );

            fMesure.append ( formate ( listGrammes.get ( i ).getfMesure ( ) ,
                    i , LETTRE_F_MESURE , phrase ) );
        }
        return correspondances.toString ( ) + rappel + precision + fMesure;
    }

    private String formate ( Function < NGramme, Double > operation , int index ,
                             String lettre , Phrase phrase ) {
        return lettre + ( index + 1 ) + EGALE_A +
                operation.apply ( phrase.listGrammes.get ( index ) ) +
                ( ( index == NB_GRAMMES - 1 ) ? FIN_LIGNE :
                        SEPARATEUR_ELEMENTS);
    }

    private void afficher ( String chaineAAfficher ) {
        System.out.println ( chaineAAfficher );
    }
}
