package tehtava_2;

//Pääohjelmajoka testaa library ja Bookluokkien toiminnallisuutta

public class LibraryMain {
    public static void main(String[] args) {
//vanha koodi
        Library myLibrary = new Library();

        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);

        System.out.println("--- Kirjasto alussa ---");
        myLibrary.displayBooks();
        System.out.println("\n--- Lainaus- ja palautustestit ---");

        // lainataan kirja, joka on olemassa
        myLibrary.borrowBook("The Art of Fiction");

        // ktstsotaan kirjaston sisältö lainauksen jälkeen
        System.out.println("\n--- Kirjasto lainauksen jälkeen ---");
        myLibrary.displayBooks();

        //uritetään lainata kirja jota ei ole
        myLibrary.borrowBook("A Random Book");

        // pllautetaan aiemmin lainattu kirja
        myLibrary.returnBook(book3);

        // katsotaan kirjaston sisältö palautuksen jälkeen
        System.out.println("\n--- Kirjasto palautuksen jälkeen ---");
        myLibrary.displayBooks();
    }
}