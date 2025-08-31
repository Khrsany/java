package tehtava_5;

import java.util.ArrayList;
import java.util.Iterator;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
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
    public boolean isBookAvailable(String title) {
        for (Book book : this.books) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    //uudet moetodit

    //Laskee ja palauttaa kaikkien kirjojen keskimääräisen arvosanan.
    public double getAverageBookRating() {
        if (books.isEmpty()) {
            return 0.0; // Vältetään nollalla jakaminen jos kirjasto on tyhjä
        }

        double totalRating = 0.0;
        int ratedBooksCount = 0; //lskuri niille kirjoille joilla on arvosanaa¨

        //käydään kaikki kirjat läpi
        for (Book book : books) {
            // laskuihin mukaan vain kirjat, joille on annettu arvosana
            if (book.getRating() > 0) {
                totalRating += book.getRating(); // lisätään kirjan arvosana kokonaissummaan
                ratedBooksCount++; // kasvatetaan arvosteltujen kirjojen laskuria.
            }
        }

        // Jos yksikään kirja ei ole saanut arvosanaa palautetaan 0.0.
        if (ratedBooksCount == 0) {
            return 0.0;
        }

        // palautetaan keskiarvo: summa jaettuna määrällä
        return totalRating / ratedBooksCount;
    }

    //etsii ja palauttaa kirjan, jolla on eniten arvosteluja

    public Book getMostReviewedBook() {
        if (books.isEmpty()) {
            return null; // plalautetaan null eli tyhjä jos kirjoja ei ole
        }

        Book mostReviewedBook = books.get(0); //oletetaan aluksi, että ensimmäinen kirja on eniten arvosteltu.

        //käydään loput kirjat läpi ja verrataan
        for (int i = 1; i < books.size(); i++) {
            Book currentBook = books.get(i);
            //jos tämänhetkisellä kirjalla on enemmän arvosteluja kuin tähän mennessä löydetyllä...
            if (currentBook.getReviews().size() > mostReviewedBook.getReviews().size()) {
                mostReviewedBook = currentBook; // ...päivitetään se uudeski eniten arvostelluksi kirjaksi.
            }
        }

        return mostReviewedBook;
    }
}