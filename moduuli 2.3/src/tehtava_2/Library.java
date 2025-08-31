package tehtava_2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Tämä luokka edustaa kirjastoa.
 */
public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    // --- TEHTÄVÄN 1 METODIT ---
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");
        boolean found = false;
        for (Book book : this.books) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    // --- UUDET METODIT TEHTÄVÄÄN 2 ---

    /**
     * Lainaa kirjan nimen perusteella poistamalla sen listalta.
     */
    public boolean borrowBook(String title) {
        Iterator<Book> iterator = this.books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equals(title)) {
                iterator.remove(); // Poistaa kirjan turvallisesti.
                System.out.println("\nLainasit kirjan: \"" + title + "\"");
                return true;
            }
        }
        System.out.println("\nKirjaa \"" + title + "\" ei löytynyt lainattavaksi.");
        return false;
    }

    /**
     * Palauttaa kirjan lisäämällä sen takaisin listalle.
     */
    public void returnBook(Book book) {
        this.books.add(book);
        System.out.println("Palautit kirjan: \"" + book.getTitle() + "\"");
    }
}