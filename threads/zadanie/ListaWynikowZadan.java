package lab2.zadanie;

import java.util.ArrayList;
import java.util.List;

public class ListaWynikowZadan {
    private final List<Wynik> wyniki = new ArrayList<>();

    public synchronized void dodajWynik(Wynik wynik) { wyniki.add(wynik); }

}
