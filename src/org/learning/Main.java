package org.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Siamo un po’ fuori stagione, ma è meglio prepararsi in anticipo….e
        pensare alla lista dei regali di Natale!
        Vogliamo creare un programma che memorizzi la nostra lista. Il programma deve
        chiedere il nome del regalo da inserire in lista e salvarlo in una ArrayList
        (finché l’utente non decide di fermarsi).
        Ad ogni iterazione deve mostrare la lunghezza della lista e chiedere all’utente
        se vuole continuare aggiungendo un nuovo regalo.Al termine dell’inserimento ordinare
        la lista e stampare a video la lista ordinata.
        Bonus: Salvare la lista su file e recuperarla quando si avvia il programma, in modo
        da aggiungere i nuovi elementi in coda a quelli già scritti.*/


        Scanner scanner = new Scanner(System.in);
        //Istanzio la lista di stringhe vuota
        ArrayList<String> presents = new ArrayList<>();
        //Variabile regalo
        String present;
        //Variabile scelta
        String choice;
        do {
        System.out.println("Dimmi il nome del regalo");
        present = scanner.nextLine();
        //Aggiungo il regalo alla list
        presents.add(present);
        //Stampo la lunghezza della lista
        System.out.println(presents.size());
        System.out.println("Vuoi aggiungere altri regali? y/n");
        choice = scanner.nextLine();
        }while(!choice.equals("n"));
        //Stampo la lista
        System.out.println(presents);
        //Ordino e ristampo la lista ordinata
        Collections.sort(presents);
        System.out.println("lista ordinata" + presents);
    }
}
