import java.util.ArrayList;
import java.util.function.Function;

public class Phrase {
    private String phrase = "";
    private ArrayList<NGramme> listGrammes = new ArrayList <> ( );

    public Phrase (String phrase) {
        this.phrase = phrase;
        for (int i = 0; i < 4; i ++) {
            listGrammes.add ( new NGramme ( phrase , i + 1 ) );
        }
    }

    public void compareA (Phrase phrase) {
        afficherC ( phrase );
        afficherR ( phrase );
        afficherQ ( phrase );
        afficherF ( phrase );
    }

    public void afficherC ( Phrase phrase ) {
        String resultat = "";
        for ( int i = 0; i < 4; i ++) {
            resultat += "c" + ( i + 1 ) + " = " +
                    listGrammes.get ( i ).
                            compareA ( phrase.listGrammes.get ( i ) );
            if ( i == 3 )
                resultat += ".";
            else
                resultat += ", ";
        }
        afficher ( resultat );
    }

    public void afficherR ( Phrase phrase ) {
        String resultat = "";
        for ( int i = 0; i < 4; i ++) {
            resultat += "r" + ( i + 1 ) + " = " +
                    listGrammes.get ( i ).
                            rappel ( phrase.listGrammes.get ( i ) );
            if ( i == 3 )
                resultat += ".";
            else
                resultat += ", ";
        }
        afficher ( resultat );
    }

    public void afficherQ ( Phrase phrase ) {
        String resultat = "";
        for ( int i = 0; i < 4; i ++) {
            resultat += "q" + ( i + 1 ) + " = " +
                    listGrammes.get ( i ).
                            precision ( phrase.listGrammes.get ( i ) );
            if ( i == 3 )
                resultat += ".";
            else
                resultat += ", ";
        }
        afficher ( resultat );
    }

    public void afficherF ( Phrase phrase ) {
        String resultat = "";
        for ( int i = 0; i < 4; i ++) {
            resultat += "F" + ( i + 1 ) + " = " +
                    listGrammes.get ( i ).
                            fMesure ( phrase.listGrammes.get ( i ) );
            if ( i == 3 )
                resultat += ".";
            else
                resultat += ", ";
        }
        afficher ( resultat );
    }

    public void afficher (String chaineAAfficher) {
        System.out.println ( chaineAAfficher );
    }

}
