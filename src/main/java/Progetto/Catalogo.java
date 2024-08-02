package Progetto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalogo {
    private List<Libro> libri;
    private List<Rivista> riviste;

    public Catalogo() {
        this.libri = new ArrayList<>();
        this.riviste = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        libri.add(libro);
    }

    public void aggiungiRivista(Rivista rivista) {
        riviste.add(rivista);
    }

    public void rimuoviElementoPerISBN(long isbn) {
        libri.removeIf(libro -> libro.getIsbn() == isbn);
        riviste.removeIf(rivista -> rivista.getIsbn() == isbn);
    }

    public void cercaElementoPerISBN(long isbn) {
        libri.stream()
                .filter(libro -> libro.getIsbn() == isbn)
                .forEach(System.out::println);
        riviste.stream()
                .filter(rivista -> rivista.getIsbn() == isbn)
                .forEach(System.out::println);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi Libro");
            System.out.println("2. Aggiungi Rivista");
            System.out.println("3. Rimuovi elemento per ISBN");
            System.out.println("4. Cerca elemento per ISBN");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine(); // Consuma il newline

            switch (scelta) {
                case 1:
                    System.out.print("ISBN: ");
                    long isbnLibro = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titoloLibro = scanner.nextLine();
                    System.out.print("Anno Pubblicazione: ");
                    int annoLibro = scanner.nextInt();
                    System.out.print("Numero Pagine: ");
                    int pagineLibro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Autore: ");
                    String autoreLibro = scanner.nextLine();
                    System.out.print("Genere: ");
                    String genereLibro = scanner.nextLine();
                    aggiungiLibro(new Libro(isbnLibro, titoloLibro, annoLibro, pagineLibro, autoreLibro, genereLibro));
                    break;
                case 2:
                    System.out.print("ISBN: ");
                    long isbnRivista = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titoloRivista = scanner.nextLine();
                    System.out.print("Anno Pubblicazione: ");
                    int annoRivista = scanner.nextInt();
                    System.out.print("Numero Pagine: ");
                    int pagineRivista = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                    Rivista.Periodicita periodicita = Rivista.Periodicita.valueOf(scanner.nextLine().toUpperCase());
                    aggiungiRivista(new Rivista(isbnRivista, titoloRivista, annoRivista, pagineRivista, periodicita));
                    break;
                case 3:
                    System.out.print("ISBN da rimuovere: ");
                    long isbnRimuovere = scanner.nextLong();
                    rimuoviElementoPerISBN(isbnRimuovere);
                    break;
                case 4:
                    System.out.print("ISBN da cercare: ");
                    long isbnCercare = scanner.nextLong();
                    cercaElementoPerISBN(isbnCercare);
                    break;
                case 5:
                    System.out.println("Uscita...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }
}
