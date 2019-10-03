package no.oslomet.cs.algdat;

public class Main {
    public static void main(String[] args) {
        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom()); // Utskrift: 0 true

        System.out.println("-------------------------");

        String[] s = {"Ole", null, "Per", "Kari",null};
        Liste<String> liste1 = new DobbeltLenketListe<>(s);
        System.out.println(liste1.antall() + " " + liste1.tom());

        //Oppgave 2a
        String [] s1 = {}, s2 = {"A"}, s3 = {null, "A",null,"B"};
        DobbeltLenketListe<String> l1 = new DobbeltLenketListe<>(s1);
        DobbeltLenketListe<String> l2 = new DobbeltLenketListe<>(s2);
        DobbeltLenketListe<String> l3 = new DobbeltLenketListe<>(s3);

        System.out.println("Vanlig toString: " + l1.toString() + " " + l2.toString()
        + " " + l3.toString());

        System.out.println("Omvendt toString: " + l1.omvendtString() + " " + l2.omvendtString()
                + " " + l3.omvendtString());

       }
}
