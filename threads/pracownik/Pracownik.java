package lab2.pracownik;

import lab2.zadanie.Zadanie;
import lab2.zadanie.ListaWynikowZadan;
import lab2.zadanie.ListaZadan;
import lab2.zadanie.Wynik;

// The Runnable interface should be implemented by any class
// whose instances are intended to be executed by a thread.
public class Pracownik implements Runnable {
    private final ListaZadan listaZadan;
    private final ListaWynikowZadan listaWynikowZadan;

    public Pracownik(ListaZadan listaZadan, ListaWynikowZadan listaWynikowZadan){
        this.listaWynikowZadan = listaWynikowZadan;
        this.listaZadan = listaZadan;
    }

    @Override
    public void run(){
        while(!Thread.interrupted()){
            try {
                Zadanie zadanie = listaZadan.get();
                Thread.sleep(150);
                Wynik wynik = zadanie.licz();
                listaWynikowZadan.dodajWynik(wynik);
            } catch (InterruptedException except){
                break;
            }
        }
    }

}
