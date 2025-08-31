package tehtava_6;

public class LibraryMain {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        //luodaan kirjat ja lisätään ne kirjastoon
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);

        //luodaan käyttäjät ja lisätään heidät kirjastoon
        User user1 = new User("Matti Meikäläinen", 35);
        User user2 = new User("Liisa Joki", 28);
        myLibrary.addUser(user1);
        myLibrary.addUser(user2);

        System.out.println("--- Tilanne alussa ---");
        myLibrary.displayBooks();
        System.out.println(user1);
        System.out.println(user2);

        // testi..Matti lainaa kirjan
        myLibrary.borrowBook(user1, "Introduction to Java Programming");

        System.out.println("\n--- Tilanne 1. lainauksen jälkeen ---");
        myLibrary.displayBooks();
        System.out.println(user1);

        // testi liisa yrittä lainata samaa kirja
        myLibrary.borrowBook(user2, "Introduction to Java Programming");

        // matti palauttaa kirjan.
        myLibrary.returnBook(user1, book1); // Huom! Tarvitaan viittaus alkuperäiseen kirja-olioon.

        System.out.println("\n--- Tilanne palautuksen jälkeen ---");
        myLibrary.displayBooks();
        System.out.println(user1);

        // nyt Liisa voi lainaamaan kirjan.
        myLibrary.borrowBook(user2, "Introduction to Java Programming");

        System.out.println("\n--- Lopputilanne ---");
        myLibrary.displayBooks();
        System.out.println(user2);
    }
}