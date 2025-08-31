package tehtava_6;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>(); // uusi lista käyttäjille

    //vanhat metodit addBook, displayBooks, tilastot, jää.
    public void addBook(Book book) { this.books.add(book); }
    public void displayBooks() {
        System.out.println("--- Kirjaston saatavilla olevat kirjat ---");
        if (books.isEmpty()) {
            System.out.println("Ei kirjoja saatavilla.");
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    //metodi joka lisää käyttäjiää
    public void addUser(User user) {
        this.users.add(user);
    }

    public boolean borrowBook(User user, String title) {
        Book bookToBorrow = null;
        //etsitään kirja olio kirjaston saatavilla olevista kirjoista
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                bookToBorrow = book;
                break;
            }
        }

        //jos kirja löytyi...
        if (bookToBorrow != null) {
            this.books.remove(bookToBorrow);    //..poista se kirjaston listalta
            user.borrowBook(bookToBorrow);      // ja lisää se käyttäjän lainattujen listalle
            System.out.println("\n" + user.getName() + " lainasi kirjan: \"" + title + "\"");
            return true;
        } else {
            System.out.println("\nKirjaa \"" + title + "\" ei löytynyt lainattavaksi.");
            return false;
        }
    }

    /**
     * Palauttaa kirjan tietyltä käyttäjältä.
     * @param user Käyttäjä, joka palauttaa kirjan.
     * @param book Palautettava kirja-olio.
     * @return true, jos palautus onnistui.
     */
    public boolean returnBook(User user, Book book) {
        // Yritetään poistaa kirja käyttäjän lainoista.
        // Jos onnistuu (eli käyttäjällä oli tämä kirja)...
        if (user.returnBook(book)) {
            this.books.add(book); // ...lisätään se takaisin kirjaston päälistalle.
            System.out.println("\n" + user.getName() + " palautti kirjan: \"" + book.getTitle() + "\"");
            return true;
        } else {
            System.out.println("\n" + user.getName() + " ei voinut palauttaa kirjaa (sitä ei ollut lainassa hänellä).");
            return false;
        }
    }
}