package org.learning;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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


        File file = new File("./resources/list.txt");

        //Istanzio la lista di stringhe vuota
        ArrayList<String> presents = new ArrayList<>();
        //Leggo il file e assegno se ci sono righe alla lista
        readFile(file, presents);
        //Variabile regalo
        String present;
        //Variabile scelta
        String choice;
        do {
        System.out.println("Dimmi il nome del regalo");
        present = scanner.nextLine();
        //Aggiungo il regalo alla lista
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
        //Invoco il metodo per scrivere sul file
        writeToFile(file, presents);
    }


    //Metodo per scrivere nel file
    private static void writeToFile(File file, ArrayList<String> presents) {
        /*Blocco try-with-resources per gestire la chiusura del FileWriter
        gestisce automaticamente le risorse che devono essere chiuse
        dopo che hanno completato la loro attività.
         */
        try(FileWriter fileWriter = new FileWriter(file)){
            //Istanzio fileWriter
            for (String present : presents) {
                //Scrivo ogni elemento della lista nel file
                fileWriter.write(present + "\n");
            }
        }catch (IOException e){
            System.out.println("Unable to open file writer");
        }
    }

    //Metodo per leggere il testo del file
    public static void readFile(File file,ArrayList<String> presents){
        String line=null;
        //Blocco try-with-resource
        try (Scanner scanner = new Scanner(file)) {
            //Istanzio la variabile del numero di righe contenute nel file
            int listRows = 0;
            //Itero su tutte le righe del file
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                //Aumento contatore delle righe
                listRows++;
            }
            //Aggiungo le righe come elementi della lista presents
            for (int i = 0; i < listRows; i++) {
                presents.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to read");
        }
    }
}
