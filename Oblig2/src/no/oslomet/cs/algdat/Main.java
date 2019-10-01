package no.oslomet.cs.algdat;

public class Main {
    public static void main(String[] args) {
        Liste<String> liste = new DobbeltLenketListe<>();
        System.out.println(liste.antall() + " " + liste.tom()); // Utskrift: 0 true

        System.out.println("-------------------------");

        String[] s = {"Ole", null, "Per", "Kari",null};
        Liste<String> liste1 = new DobbeltLenketListe<>(s);
        System.out.println(liste1.antall() + " " + liste1.tom());
    }
}
