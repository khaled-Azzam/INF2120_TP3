import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class PhraseTest {
    String phrase1;
    String phrase2;

    @Test
    public void comparerA_1 ( ) {
        var phrase1 = new Phrase ("a b c d e" , 1 );
        var phrase2 = new Phrase ("a b c d e" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 5, c2 = 4, c3 = 3, c4 = 2.\n" +
                        "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 1.0.\n" +
                        "q1 = 1.0, q2 = 1.0, q3 = 1.0, q4 = 1.0.\n" +
                        "F1 = 1.0, F2 = 1.0, F3 = 1.0, F4 = 1.0.\n");

        ;
    }

    @Test
    public void comparerA_2 ( ) {
        var phrase1 = new Phrase ("a b c d" , 1 );
        var phrase2 = new Phrase ("a b c d" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),"c1 = 4, c2 = 3, c3 = 2, c4 = 1.\n" +
                "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 1.0.\n" +
                "q1 = 1.0, q2 = 1.0, q3 = 1.0, q4 = 1.0.\n" +
                "F1 = 1.0, F2 = 1.0, F3 = 1.0, F4 = 1.0.\n");
    }

    @Test
    public void comparerA_3 ( ) {
        var phrase1 = new Phrase ("a b" , 1 );
        var phrase2 = new Phrase ("a b" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),"c1 = 2, c2 = 1, c3 = 0, c4 = 0.\n" +
                "r1 = 1.0, r2 = 1.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 1.0, q2 = 1.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 1.0, F2 = 1.0, F3 = 0.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_4 ( ) {
        var phrase1 = new Phrase ("a" , 1 );
        var phrase2 = new Phrase ("a" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 1, c2 = 0, c3 = 0, c4 = 0.\n" +
                "r1 = 1.0, r2 = 0.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 1.0, q2 = 0.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 1.0, F2 = 0.0, F3 = 0.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_5 ( ) {
        var phrase1 = new Phrase ("A B C" , 1 );
        var phrase2 = new Phrase ("a b c" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 3, c2 = 2, c3 = 1, c4 = 0.\n" +
                        "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 0.0.\n" +
                        "q1 = 1.0, q2 = 1.0, q3 = 1.0, q4 = 0.0.\n" +
                        "F1 = 1.0, F2 = 1.0, F3 = 1.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_6 ( ) {
        var phrase1 = new Phrase ("a b c d e" , 1 );
        var phrase2 = new Phrase ("f g h i j" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 0, c2 = 0, c3 = 0, c4 = 0.\n" +
                "r1 = 0.0, r2 = 0.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 0.0, q2 = 0.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_7 ( ) {
        var phrase1 = new Phrase ("a b c d" , 1 );
        var phrase2 = new Phrase ("a c e f" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 2, c2 = 0, c3 = 0, c4 = 0.\n" +
                "r1 = 0.5, r2 = 0.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 0.5, q2 = 0.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 0.5, F2 = 0.0, F3 = 0.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_8 ( ) {
        var phrase1 = new Phrase ("a3b3c3d3e" , 1 );
        var phrase2 = new Phrase ("a.b,c,-d'e" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 5, c2 = 4, c3 = 3, c4 = 2.\n" +
                        "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 1.0.\n" +
                        "q1 = 1.0, q2 = 1.0, q3 = 1.0, q4 = 1.0.\n" +
                        "F1 = 1.0, F2 = 1.0, F3 = 1.0, F4 = 1.0.\n");
    }

    @Test
    public void comparerA_9 ( ) {
        var phrase1 = new Phrase ("a a a a a a a a a a" , 1 );
        var phrase2 = new Phrase ("a a a a a" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 5, c2 = 4, c3 = 3, c4 = 2.\n" +
                        "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 1.0.\n" +
                        "q1 = 0.5, q2 = 0.4444444444444444, q3 = 0.375, q4 = 0.2857142857142857.\n" +
                        "F1 = 0.6666666666666666, F2 = 0.6153846153846153, F3 = 0.5454545454545454, F4 = 0.4444444444444445.\n");
    }

    @Test
    public void comparerA_10 ( ) {
        var phrase1 = new Phrase ("Lors de la construction d'un tableau." , 1 );
        var phrase2 = new Phrase ("Lors de la construction d'un logiciel contenant un tableau." , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 7, c2 = 6, c3 = 4, c4 = 3.\n" +
                        "r1 = 0.7, r2 = 0.6666666666666666, r3 = 0.5, r4 = 0.42857142857142855.\n" +
                        "q1 = 1.0, q2 = 1.0, q3 = 0.8, q4 = 0.75.\n" +
                        "F1 = 0.8235294117647058, F2 = 0.8, F3 = 0.6153846153846154, F4 = 0.5454545454545454.\n");
    }

    @Test
    public void comparerA_11 ( ) {
        var phrase1 = new Phrase ("Lors de la construction d'un tableau." , 1 );
        var phrase2 = new Phrase ("tableau un'd construction la de Lors." , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 7, c2 = 0, c3 = 0, c4 = 0.\n" +
                "r1 = 1.0, r2 = 0.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 1.0, q2 = 0.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 1.0, F2 = 0.0, F3 = 0.0, F4 = 0.0.\n");
    }

    @Test
    public void comparerA_12 ( ) {
        var phrase1 = new Phrase ("Lors LORS lORS lOrS" , 1 );
        var phrase2 = new Phrase ("LORs lORs loRS lors" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 4, c2 = 3, c3 = 2, c4 = 1.\n" +
                        "r1 = 1.0, r2 = 1.0, r3 = 1.0, r4 = 1.0.\n" +
                        "q1 = 1.0, q2 = 1.0, q3 = 1.0, q4 = 1.0.\n" +
                        "F1 = 1.0, F2 = 1.0, F3 = 1.0, F4 = 1.0.\n");
    }

    @Test
    public void comparerA_13 ( ) {
        var phrase1 = new Phrase ("lors" , 1 );
        var phrase2 = new Phrase ("lorsque" , 2 );

        Assertions.assertEquals ( phrase1.afficherResultats ( phrase2 ),
                "c1 = 0, c2 = 0, c3 = 0, c4 = 0.\n" +
                "r1 = 0.0, r2 = 0.0, r3 = 0.0, r4 = 0.0.\n" +
                "q1 = 0.0, q2 = 0.0, q3 = 0.0, q4 = 0.0.\n" +
                "F1 = 0.0, F2 = 0.0, F3 = 0.0, F4 = 0.0.\n");
    }
}