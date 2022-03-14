package lab2.zadanie;

public class Zadanie {
    private int liczba;

    public Zadanie(int liczba) { this.liczba = liczba; }

    public Wynik licz(){
        Wynik wynik = new Wynik();
        wynik.ustawWynik(false);
        int ostatniaLiczba = (int) Math.ceil(Math.sqrt(liczba));
        for(int i = 2; i <= ostatniaLiczba; i++){
            if(liczba % i == 0){
                wynik.ustawWynik(true);
                break;
            }
        }
        return wynik;
    }
}
