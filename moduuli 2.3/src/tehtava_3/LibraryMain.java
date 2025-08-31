package tehtava_3;

public class LibraryMain {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        System.out.println("--- Kirjasto alussa ---");
        myLibrary.displayBooks();

        //edellinen testaus
        System.out.println("\n--- Saatavuustarkistustestit ---");

        //tarkistetaan kirjan saatavuus, kun se ON kirjastossa.
        String bookToCheck = "Data Structures and Algorithms";
        System.out.println("Onko kirja \"" + bookToCheck + "\" saatavilla? " + myLibrary.isBookAvailable(bookToCheck));

        //lainataan sama kirja pois (käyttäen Tehtävän 2 metodia).
        myLibrary.borrowBook(bookToCheck);

        //tarkistetaan saattavuus uudelleen lainauksen jälkeen..
        System.out.println("Onko kirja \"" + bookToCheck + "\" saatavilla lainauksen jälkeen? " + myLibrary.isBookAvailable(bookToCheck));

        // taarkistetaan kirja, jota ei ole koskaan ollutkaan kirjastossa.
        System.out.println("Onko kirja \"War and Peace\" saatavilla? " + myLibrary.isBookAvailable("War and Peace"));
    }
}