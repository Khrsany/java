package tehtava_3;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    //vanhat metodit
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }
    public boolean borrowBook(String title) {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove();
                System.out.println("\nLainasit kirjan: \"" + title + "\"");
                return true;
            }
        }
        System.out.println("\nKirjaa \"" + title + "\" ei löytynyt lainattavaksi.");
        return false;
    }

    public void returnBook(Book book) {
        this.books.add(book);
        System.out.println("Palautit kirjan: \"" + book.getTitle() + "\"");
    }

    //tarkistaa, onko tietynniminen kirja saatavilla kirjastossa.

    public boolean isBookAvailable(String title) {
        // Käydään läpi kaikki kirjat 'for-each'-silmukalla.
        for (Book book : this.books) {
            // Jos kirjan nimi vastaa etsittyä nimeä...
            if (book.getTitle().equals(title)) {
                return true; // ...palautetaan heti true ja metodin suoritus päättyy.
            }
        }
        // Jos silmukka päättyy niin yhtään vastaavaa kirjaa ei löytynyt
        // palautetaan falsse
        return false;
    }
}