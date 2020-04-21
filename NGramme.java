import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Classe qui modélise le n-gramme d'une phrase
 * les différentes opérations à effectuer à savoir (nombre de
 * correspondances, rappel, précision, facteur F) on été déclarés sous forme
 * de Function < T, R >
 */
class NGramme {
    //Constantes
    private final static String EXP_REG_SPLIT = "[^a-zA-ZÀ-ÿ]+";

    //Variables d'instance
    private ArrayList < ArrayList < String > > nGrammes =
            new ArrayList <> ();
    private String phrase;
    private int nIemeGramme;

    /* Nombre de correspondances :*/
    // L'invocation de la méthode appel calcule le nombre de correspondances
    // de mots entre le gramme courrant et un autre gramme homologue (même n)
    private Function < NGramme, Double > nCorrespndances =
            nGramme -> {
                ArrayList< ArrayList < String > > ngramme;
                ngramme = new NGramme ( nGramme.phrase.toUpperCase ()
                        , nGramme.nIemeGramme ).nGrammes;
                for ( ArrayList < String > gramme : nGrammes ) {
                    for ( int i = 0; i < gramme.size (); i ++) {
                        gramme.set ( i, gramme.get ( i ).toUpperCase ());
                    }
                    ngramme.remove ( gramme );
                }

                return ( double ) ( nGramme.nGrammes.size ( ) -
                        ngramme.size ( ) );
            };

    /*Reppel :*/
    // L'invocation de la méthode appel calcule le rappel
    // de mots entre le gramme courrant et un autre gramme homologue (même n)
    private Function < NGramme, Double > rappel =
            nGramme -> nGramme.nbrGrammes () != 0 ?
                    nCorrespndances.apply ( nGramme ) / nGramme.nbrGrammes () :
                    0;

    /*Precision :*/
    // L'invocation de la méthode appel calcule la précision de similitude de
    // mots entre le gramme courrant et un autre gramme homologue (même n)
    private Function < NGramme, Double> precision =
            nGramme -> nbrGrammes () != 0 ?
                    nCorrespndances.apply ( nGramme ) / nbrGrammes () :
                    0;

    /*f-Mesure :*/
    // L'invocation de la méthode appel calcule le f-mesure de mots entre
    // le gramme courrant et un autre gramme homologue (même n)
    private Function < NGramme, Double> fMesure =
            nGramme -> rappel.apply ( nGramme ) +
                    precision.apply ( nGramme ) != 0 ?
                    2 * rappel.apply ( nGramme ) *
                            precision.apply ( nGramme ) /
                            ( rappel.apply ( nGramme ) +
                                    precision.apply ( nGramme ) ) :
                    0;

    //Constructeur
    /**
     * Constructeur de la classe
     * @param phrase la phrase utilisé pour construire un n-gramme
     * @param nIemeGramme le n-ième gramme à construire
     */
    NGramme ( String phrase , int nIemeGramme ) {

        //1.Separation des mots et enregistrement des mots
        ArrayList < String > listDeMots = new ArrayList <> ( Arrays.asList
                ( phrase.split ( EXP_REG_SPLIT ) ) );
        int i = 0;
        ArrayList<String> nGUnit;

        this.phrase = phrase;
        this.nIemeGramme = nIemeGramme;

        while ( listDeMots.size () - i >= nIemeGramme ) {
            //Prener n mots à partir de i et construire un AL puis l'ajouter à
            //nGrammes
            nGUnit = new ArrayList <> ();
            if ( ! listDeMots.get ( i ).equals ( "" ) ) {
                for ( int s = 0; s < nIemeGramme ; s++ ) {
                    nGUnit.add( listDeMots.get ( i + s ) );
                }
                nGrammes.add ( nGUnit );
            }
            i ++;
        }
    }

    /*Getters*/
    Function < NGramme, Double > getnCorrespndances ( ) {
        return nCorrespndances;
    }

    Function < NGramme, Double > getRappel ( ) {
        return rappel;
    }

    Function < NGramme, Double > getPrecision ( ) {
        return precision;
    }

    Function < NGramme, Double > getfMesure ( ) {
        return fMesure;
    }

    int getnIemeGramme ( ) {
        return nIemeGramme;
    }

    /*Methodes :*/
    private int nbrGrammes ( ) {
        return nGrammes.size ();
    }

    @Override
    public String toString ( ) {

        ArrayList<String> resultat;
        ArrayList<String> resultatFinal = new ArrayList <> (  );

        for ( ArrayList<String> gramme : nGrammes ) {
            resultat = new ArrayList <> ( );
            for (String s : gramme ) {
                resultat.add ( "\""+s+"\"" );
            }
            resultatFinal.add (
                    (gramme.size () > 1 ? "( " : "") +
                            String.join ( ", ", resultat ) +
                    (gramme.size () > 1 ? " )" : "")
            );
        }
        return resultatFinal.toString ();
    }
}

