package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
     /*   Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom()); // Utskrift: 0 true

        System.out.println("-------------------------");

        String[] s = {"Ole", null, "Per", "Kari",null};
        Liste<String> liste1 = new DobbeltLenketListe<>(s);
        System.out.println(liste1.antall() + " " + liste1.tom());
        System.out.println(liste1.toString());

        //Oppgave 2a
        String [] s1 = {}, s2 = {"A"}, s3 = {null, "A",null,"B"};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println("Vanlig toString: " + l1.toString() + " " + l2.toString()
                + " " + l3.toString());

        System.out.println("Omvendt toString: " + l1.omvendtString() + " " + l2.omvendtString()
                + " " + l3.omvendtString());

        //oppgave 2b
        System.out.println("------------------");
        System.out.println("Oppgave 2 b)");
        DobbeltLenketListe<Integer> liste2 = new DobbeltLenketListe<>();
        System.out.println(liste2.toString() + " " + liste2.omvendtString());

        for(int i = 1; i <= 3; i++){
            liste2.leggInn(i);
            System.out.println(liste2.toString() + " " + liste2.omvendtString());
        }


        //Oppgave 3
        System.out.println("------------------");
        Integer[] poop= {3,4,6,7,8,9,0,1,2,3,4};
        Liste<Integer> liste3 = new DobbeltLenketListe<>(poop);
        System.out.println("Oppgave 3:");
        int verdi = liste3.hent(4);
        System.out.println("Verdi av indeks 4 : "+verdi);

        DobbeltLenketListe<Integer> liste = new DobbeltLenketListe<>();

        liste.leggInn(1);
        liste.leggInn(2);
        liste.leggInn(3);
        liste.leggInn(4);
        System.out.println(liste.toString());
        System.out.println(liste.hent(3));
*/
        //Oppgave 4
        System.out.println("------------------");
        System.out.println("Oppgave 4");
        //FIXME fikk den til å funke i testen .. tester jeg den feil her?
        String [] s4 = {"Bulbasaur","Arcanine", "Articuno", "Squirtle","Charizard", "Pikachu", "Articuno"};
        DobbeltLenketListe<String> pokedex = new DobbeltLenketListe<>(s4);
        System.out.println(pokedex.indeksTil("Arcanine"));
/*
        //Oppgave 6
       System.out.println("------------------");
        System.out.println("Oppgave 6");

        String[] hei = {};
        DobbeltLenketListe<String> halla = new DobbeltLenketListe<>(hei);
        System.out.println("Før fjerning:");
        System.out.println(halla.toString());
        System.out.println(halla.omvendtString());
        halla.fjern(0);
        System.out.println("Etter fjerning:");
        System.out.println(halla.toString());
        System.out.println(halla.omvendtString());


        //Oppgave 6:
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>();
        liste.leggInn("A");
        liste.leggInn("B");

        try {
            liste.fjern(1);
        } catch (Exception e) {
            System.out.println("Oppgave 6za: Her kastes det et unntak, men det skal ikke skje!!");
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6zb: Her må det være en pekerfeil!");
        }

        liste.leggInn("B");

        try {
            liste.fjern("B");
        } catch (Exception e) {
            System.out.println
                    ("Oppgave 6zd: Her kastes det et unntak, men det skal ikke skje!!");
        }

        if (!liste.toString().equals("[A]")) {
            System.out.println
                    ("Oppgave 6ze: Her må det være en pekerfeil!");
        }

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Oppg. 3b");

        Character[] c = {'A','B','C','D','E','F','G','H','I','J',};
        DobbeltLenketListe<Character> listeC = new DobbeltLenketListe<>(c);
        System.out.println(listeC.subliste(3,8));   // [D,E,F,G,H]
        System.out.println(listeC.subliste(5,5));  // []
        System.out.println(listeC.subliste(8,listeC.antall())); // [I,J]
        System.out.println(listeC.subliste(0,11)); // skal kaste unntak


        //Oppgave 8:
        String[] navn = {"Lars", "Anders", "Bodil", "Kari", "Per", "Berit"};
        Liste<String> liste = new DobbeltLenketListe<>(navn);
        liste.forEach(s -> System.out.print(s + " "));  //Denne skriver ut
        System.out.println();
        for(String s : liste) System.out.print(s + " ");
        */

        //Oppgave 9:
        /*
        String [] navnListe = new String [] {"Birger", "Lars", "Anders", "Bodil", "Kari", "Per", "Berit"};
        DobbeltLenketListe<String> liste = new DobbeltLenketListe<>(navnListe);
        liste.fjernHvis(navn -> navn.charAt(0) == 'B'); // Fjerner navn som starter med B
        System.out.println(liste + " " + liste.omvendtString());


        // Oppgave 10:
        String[] navn2 = {"Lars","Anders","Bodil","Kari","Per","Berit"};

        Liste<String> listeS = new DobbeltLenketListe<>(navn2);

        DobbeltLenketListe.sorter(listeS, Comparator.naturalOrder()); // [Anders,Berit,Bodil,Kari,Lars,Per]
        System.out.println(listeS);
        System.out.println(Arrays.toString(navn2)); // tabellen navn2 er upåvirket
        */
    }
}
