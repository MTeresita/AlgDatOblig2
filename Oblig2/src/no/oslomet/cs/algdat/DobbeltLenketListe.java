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
        Objects.requireNonNull(a,"Tabellen a er null!");
       hode = hale = new Node<>(null); // oppretter en midlertig node.

            for(T verdi : a){
                if(verdi != null) {
                    hale = hale.neste = new Node<>(verdi,hale,null); // ny verdi legges bakerst
                    antall++;
                }
                if(antall == 0){
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
        throw new NotImplementedException();
    }

    @Override
    public void leggInn(int indeks, T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean inneholder(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T hent(int indeks) {
        throw new NotImplementedException();
    }

    @Override
    public int indeksTil(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        throw new NotImplementedException();
    }

    @Override
    public boolean fjern(T verdi) {
        throw new NotImplementedException();
    }

    @Override
    public T fjern(int indeks) {
        throw new NotImplementedException();
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

            node = node.neste;

            while (node != null) {
                if(node.neste == null){
                    sb.append(node.verdi);
                }
                else {
                    sb.append(node.verdi).append(", "); //legger videre til de neste elementene.
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
        sb.append(node.verdi);
        node = node.forrige;

        while(node.forrige != null){
            sb.append(", ").append(node.verdi); //legger videre til de neste elementene.
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


