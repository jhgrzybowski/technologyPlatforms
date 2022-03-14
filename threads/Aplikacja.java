package lab2;

import lab2.zadanie.Zadanie;
import lab2.pracownik.Pracownik;
import lab2.zadanie.repo.Sesja;

import java.util.Scanner;

public class Aplikacja {
    public static void main(String[] args){
        int numerWatku = Integer.parseInt(args[0]);
        Sesja sesja = new Sesja();
        for(int i = 0; i < numerWatku; i++){
            Thread watek = new Thread(new Pracownik(sesja.getListaZadan(), sesja.getListaWynikowZadan()));
            sesja.dodajWatek(watek);
            watek.start();
        }
        Scanner skaner = new Scanner(System.in);
        boolean czyKoniec = false;
        System.out.println("Menu :");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Koniec");
        System.out.println("Podaj numer komendy : ");
        while(!czyKoniec && skaner.hasNext()){
            switch(skaner.next()){
                case "1":
                    System.out.print("Podaj liczbe do sprawdzenia : ");
                    int liczba = skaner.nextInt();
                    sesja.dodajZadanie(new Zadanie(liczba));
                    System.out.print("Podaj numer komendy : ");
                    break;
                case "2":
                    czyKoniec = true;
                    System.out.println("Koniec watkow");
                    break;
                default:
                    System.out.print("Podałeś zły numer!");
                    System.out.print("Podaj numer komendy : ");
            }
        }
        // Posprzątanie po sobie
        skaner.close();
        for(Thread watek : sesja.getWatki()){
            watek.interrupt();
        }
    }
}
