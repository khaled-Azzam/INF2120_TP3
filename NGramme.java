import java.util.ArrayList;
import java.util.Arrays;

public class NGramme {
    private ArrayList <ArrayList<String>> nGrammes =
            new ArrayList <> ( );

    private ArrayList <String> listDeMots;

    public NGramme () { }

    public NGramme ( String phrase, int n) {
        //1.Separation des mots et enregistrement des mots
        listDeMots =
            new ArrayList <> ( Arrays.asList
                    ( phrase.split ( "[^a-zA-ZÀ-ÿ]{1}" ) ) ) ;
        int i = 0;
        ArrayList<String> nGUnit;

        while ( listDeMots.size () - i >= n ) {
            //Prener n mots à partir de i et construire un AL puis l'ajouter à
            //nGrammes
            nGUnit = new ArrayList <> ();
            for ( int s = 0; s < n ; s++ ) {
                nGUnit.add(listDeMots.get ( i + s ));
            }
            nGrammes.add ( nGUnit );
            i++;
        }

    }

    public int nbrGrammes () {
        return nGrammes.size ();
    }

    //c
    public int compareA ( NGramme nGramme) {
        ArrayList<ArrayList<String>> ngramme;
        ngramme = (ArrayList<ArrayList<String>>)nGramme.nGrammes.clone ();
        int tailleInitiale = ngramme.size ();
        for ( ArrayList < String > nGr:nGrammes) {
            ngramme.remove ( nGr );
        }

        return tailleInitiale - ngramme.size ();
    }

    //r
    public double rappel (NGramme nGramme) {
        return ( double ) compareA ( nGramme ) / nGramme.nbrGrammes ();
    }

    //precision
    public double precision ( NGramme nGramme ) {
        return ( double ) compareA ( nGramme ) / nbrGrammes () ;
    }

    public double fMesure ( NGramme nGramme ) {
        return 2 * rappel ( nGramme ) * precision ( nGramme ) /
                (rappel ( nGramme ) + precision ( nGramme ) );
    }
    @Override
    public String toString ( ) {
        return nGrammes.toString ();
    }
}

