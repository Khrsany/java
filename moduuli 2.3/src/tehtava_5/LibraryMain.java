package tehtava_5;

public class LibraryMain {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        book1.setRating(4.5);
        book1.addReview("Loistava perusteos.");
        book1.addReview("Auttoi pääsemään alkuun ohjelmoinnissa.");

        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        book2.setRating(4.8);
        book2.addReview("Todella syvällinen, mutta vaativa.");
        book2.addReview("Pakollinen kaikille devaajille.");
        book2.addReview("Hyvin jäsennelty.");

        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);
        //täll kirjalle ei anneta arvosana jotta nähdään, että keskiarvo lasketaan oikein
        book3.addReview("Mielenkiintoinen lukukokemus.");

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        System.out.println("--- Kirjasto alussa ---");
        myLibrary.displayBooks();

        System.out.println("\n--- Kirjaston tilastot ---");

        //testataan keskiarvon laskentaa.
        double avgRating = myLibrary.getAverageBookRating();
        // Käytetään String.format("%.2f", ...), jotta tulosteessa on vain kaksi desimaalia.
        System.out.println("Kirjojen keskimääräinen arvosana: " + String.format("%.2f", avgRating));

        //testataan eniten arvostellun kirjan hakua.
        Book mostReviewed = myLibrary.getMostReviewedBook();
        if (mostReviewed != null) {
            System.out.println("Eniten arvosteluja saanut kirja: " + mostReviewed.getTitle());
        } else {
            System.out.println("Kirjastossa ei ole kirjoja.");
        }
    }
}