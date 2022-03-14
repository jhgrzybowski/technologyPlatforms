package lab2.zadanie.repo;

import lab2.zadanie.Zadanie;
import lab2.zadanie.ListaZadan;
import lab2.zadanie.ListaWynikowZadan;

import java.util.ArrayList;
import java.util.List;

public class Sesja {
    private final ListaZadan listaZadan = new ListaZadan();
    private final ListaWynikowZadan listaWynikowZadan = new ListaWynikowZadan();
    private final List<Thread> watki = new ArrayList<>();

    public ListaZadan getListaZadan() { return listaZadan; }

    public ListaWynikowZadan getListaWynikowZadan() { return listaWynikowZadan; }

    public List<Thread> getWatki() { return watki; }

    public void dodajWatek(Thread thread) { watki.add(thread); }

    public void dodajZadanie(Zadanie zadanie) { listaZadan.dodaj(zadanie); }

}
