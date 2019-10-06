package no.oslomet.cs.algdat;


////////////////// class DobbeltLenketListe //////////////////////////////


import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Predicate;



public class DobbeltLenketListe<T> implements Liste<T> {

    /**
     * Node class
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;                   // nodens verdi
        private Node<T> forrige, neste;    // pekere

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi;
            this.forrige = forrige;
            this.neste = neste;
        }

        private Node(T verdi) {
            this(verdi, null, null);
        }
    }

    // instansvariabler
    private Node<T> hode;          // peker til den første i listen
    private Node<T> hale;          // peker til den siste i listen
    private int antall;            // antall noder i listen
    private int endringer;         // antall endringer i listen

    public DobbeltLenketListe() {
        hode = hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) {
        //Hvis a er 0, så skal det kastet en NullPointerException
        //Objects.requireNonNull(a,"Tabellen a er null!");

        hode = hale = new Node<>(null); // oppretter en midlertig node.

        for (T verdi : a) {
            if (verdi != null) {
                hale = hale.neste = new Node<>(verdi, hale, null); // ny verdi legges bakerst
                antall++;
            }
            if (tom()) {
                hode = hale = new Node<>(null); // tom liste
            }
        }
    }

    public Liste<T> subliste(int fra, int til){
        throw new NotImplementedException();
    }

    @Override
    public int antall() {
       return antall;
    }
    @Override
    public boolean tom() {
        if (antall == 0 ){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean leggInn(T verdi) {
        if(verdi == null){ //Sjekker etter null-verdier
            Objects.requireNonNull(verdi, "Kan ikke legge til tomme verdier.");
            return false;
        }

        Node node = new Node(verdi);

        //Tilfelle 1: listen er tom
        if(tom()){
            hode = hale = node;
        }

        //Tilfelle 2: listen er ikke tom
        else{
            node.forrige = hale;
            hale.neste = node;
            hale = node;
        }
        antall++;
        endringer++;

        return true;
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        if(indeks < 0 || indeks > antall){
            throw new IndexOutOfBoundsException("Indeks er ikke gyldig");
        }
        else if(verdi == null) {
            Objects.requireNonNull(verdi, "Verdien er tom.");
        }

        else {
            Node<T> node = new Node<>(verdi);

            //Scenarioer:
            //1. tom liste
            if (tom()) {
                hode = hale = node;
            }

            //2. verdien skal legges først - forrigepeker = null
            else if (indeks == 0) {
                node.neste = hode;
                hode.forrige = node;
                hode = node;
            }

            //3. verdien skal legges bakerst - nestepeker = null
            else if (indeks == antall) {
                node.forrige = hale;
                hale.neste = node;
                hale = node;
            }

            //4. verdien skal legges mellom to andre verdier
            else {
                Node<T> p = hode;
                Node<T> q;
                for (int i = 0; i < indeks; i++) {
                    p = p.neste;
                }
                q = p.forrige;
                node.forrige = q;
                node.neste = p;
                q.neste = node;
                p.forrige = node;
            }

            endringer++;
            antall++;
        }
    }

    @Override
    public boolean inneholder(T verdi) {
        return indeksTil(verdi) != -1;

    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks,false);
        return finnNode(indeks).verdi;
    }

    private Node<T> finnNode(int indeks){
        //Finne noden med den gitte indeksen.
        int midten = antall / 2;
        Node<T> p = hode;
        Node<T> q = hale;

        if(antall == 1){
            return p; //Kun et element, returnerer her hodet (kunne vært hale også, men de er jo det samme..)
        }

        //Hvis indeks er høyere enn midten - så skal man starte fra halen og gå mot venstre, bruke forrige-pekere
        else if(indeks > midten){
            for(int i = antall-1; i > indeks; i--){
                q = q.forrige;
            }
            return q;
        }

        //Hvis indeks er mindre eller lik midten - så skal letingen starte fra hodet og gå mot høyre, bruke neste-pekere
        else{
            for(int i = 0; i <= indeks; i++){
                p = p.neste;
            }
            return p;
        }
    }


    @Override
    public int indeksTil(T verdi) {
        Node<T> node = hode;

        boolean funnet = false; //  sjekker om den er funnet
        int indeks = 0;

        while (node != null) { // så lenge node ikke er null, skal while løkken kjøre
            
            if (node.verdi.equals(verdi)) { // hvis node.neste.verdi er det samme som verdien som tas inn
                funnet = true; // setter denne variabelen til true
                break;
            }
            node = node.neste; // setter pekeren til neste node.
            indeks++; // og øker indeksen
        }

        if(funnet == true){ // er den funnet, returner indeks - som vil si, fordi den økes kun når den er funnet, dermed får vi 1 tilbake
            System.out.println(verdi + " eksiterer i listen");
            return indeks;


        }
        else {
            System.out.println(verdi + " eksiterer ikke listen");
            //hvis ikke returner -1, som vil si at den ikke eksistere
            return -1;
        }

        //TODO jeg er super dårlig på å forklare.. men spørr meg i morgen hvis det er noe haha!! - Maria

    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        //Denne skal erstatte verdien på indeks med en ny verdi og returnere det som lå der fra før
        //Indekskontroll og sjekk av null-verdier
        //Husk å øke endringer

        Objects.requireNonNull(nyverdi,"Ikke tillatt med nullverdier.");
        indeksKontroll(indeks, false);

        Node<T> p = finnNode(indeks);
        T temp = p.verdi;
        p.verdi = nyverdi;
        endringer++;

        return temp;
    }

    //Oppgave 6
    @Override
    public boolean fjern(T verdi) {
        //Denne skal fjerne verdi fra lista og returnere true
        //hvis verdi ikke er i lista, skal metoden returnere false
        //Variabel antall skal reduseres og endringer skal økes
        //pass på at tilfellet blir behandlet riktig hvis lista blir tom.


        if(tom()){
            return false;
        }

        else if(antall == 1 && hode.verdi.equals(verdi)){
            hode = hale = null;
            antall--;
            endringer++;
            return true;
        }

        else {
            Node<T> q = hode;

            for (int i = 0; i < antall; i++) {
                if (q.verdi.equals(verdi)) {
                    Node<T> p = q.forrige;
                    Node<T> r = q.neste;

                    //1. tilfelle: den første fjernes
                    if (q == hode) {
                        r.forrige = null;
                        hode = r;
                    }

                    //2. tilfelle: den siste fjernes
                    else if (q == hale) {
                        p.neste = null;
                        hale = p;
                    }

                    //3. tilfelle: en verdi mellom to andre fjernes
                    else {
                        p.neste = r;
                        r.forrige = p;
                    }

                    antall--;
                    endringer++;

                    return true;
                }
                q = q.neste;
            }
            return false;
        }
    }

    @Override
    public T fjern(int indeks) {
        //Denne skal fjerne og returnere verdien på posisjon indeks.
        //Obs: denne må først sjekkes
        //Variabel antall skal reduseres og endringer skal økes
        //pass på at tilfellet blir behandlet riktig hvis lista blir tom.

        if(tom()){
            throw new IndexOutOfBoundsException("Tom liste!"); //TODO: lista skal kunne være tome, så denne må vi gjøre noe med!
        }

        else if(indeks < 0 || indeks >= antall){
            throw new IndexOutOfBoundsException("Nei.");
        }

        else {
            Node<T> q = finnNode(indeks);
            Node<T> p = q.forrige;
            Node<T> r;

            //1a. tilfelle: den første fjernes og det er bare et element i listen
            if(antall == 1 && indeks == 0){
                hode = hale = null;
            }

            //1b. tilfelle: den første fjernes
            else if (indeks == 0) {
                r = q.neste;
                r.forrige = null;
                hode = r;
            }

            //2. tilfelle: den siste fjernes
            else if (indeks == (antall - 1)) {
                p.neste = null;
                hale = p;
            }

            //3. tilfelle: en verdi mellom to andre fjernes
            else {
                r = q.neste;
                p.neste = r;
                r.forrige = p;
            }

            antall--;
            endringer++;

            return q.verdi;
        }
    }

    @Override
    public void nullstill() {
        throw new NotImplementedException();
    }

    //Oppg 2a)
    @Override
    public String toString() {
        if(tom()){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");//starter Stringen med klammeparentes og legger til første elementet i lista.

        Node<T> node = hode;

        while (node != null) {
            if(node.verdi != null){
                if (node.neste == null) {
                    sb.append(node.verdi);
                } else {
                    sb.append(node.verdi).append(", "); //legger videre til de neste elementene.
                }
            }
            node = node.neste;
        }

        sb.append("]"); //avslutter Stringen med en klammeparentes.

        return sb.toString();//returnerer toStringen til StringBuilder'en.

    }

    //Oppg 2a)
    public String omvendtString() {
        if(tom()){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");//starter Stringen med klammeparentes og legger til første elementet i lista.

        Node<T> node = hale;

        while(node != null){
            if(node.verdi != null){
                if (node.forrige == null || node.forrige.verdi == null) {
                    sb.append(node.verdi);
                }
                else {
                    sb.append(node.verdi).append(", "); //legger videre til de neste elementene.
                }
            }
            node = node.forrige;
        }
        sb.append("]"); //avslutter Stringen med en klammeparentes.

        return sb.toString();//returnerer toStringen til StringBuilder'en.
    }

    @Override
    public Iterator<T> iterator() {
        throw new NotImplementedException();
    }

    public Iterator<T> iterator(int indeks) {
        throw new NotImplementedException();
    }

    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean fjernOK;
        private int iteratorendringer;

        private DobbeltLenketListeIterator(){
            denne = hode;     // p starter på den første i listen
            fjernOK = false;  // blir sann når next() kalles
            iteratorendringer = endringer;  // teller endringer
        }

        private DobbeltLenketListeIterator(int indeks){
            throw new NotImplementedException();
        }

        @Override       
        public boolean hasNext(){
            return denne != null;
        }

        @Override
        public T next(){
            throw new NotImplementedException();
        }

        @Override
        public void remove(){
            throw new NotImplementedException();
        }

    } // class DobbeltLenketListeIterator

    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new NotImplementedException();
    }

} // class DobbeltLenketListe


