import library.model.Book;
import library.model.LibraryMember;
import library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // 1) Lisätään kirjoja
        lib.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884"));
        lib.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991"));
        lib.addBook(new Book("Refactoring", "Martin Fowler", "9780201485677"));

        // 2) Lisätään jäseniä
        LibraryMember a = new LibraryMember("Abbas", 1);
        LibraryMember b = new LibraryMember("Sara", 2);
        lib.addMember(a);
        lib.addMember(b);

        // 3) Lainaus ja palautus
        lib.borrowBook(1, "9780132350884"); // Abbas lainaa Clean Code
        lib.borrowBook(2, "9780132350884"); // epäonnistuu (jo lainassa)
        lib.borrowBook(2, "9780134685991"); // Sara lainaa Effective Java

        lib.printBooks();
        lib.printMembers();

        lib.returnBook(1, "9780132350884"); // Abbas palauttaa
        lib.borrowBook(2, "9780132350884"); // Sara saa sen nyt

        System.out.println("--- After returns/borrows ---");
        lib.printBooks();
        lib.printMembers();
    }
}
