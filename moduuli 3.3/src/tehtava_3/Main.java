package tehtava_3;

import tehtava_3.model.Book;
import tehtava_3.model.LibraryMember;
import tehtava_3.system.Library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        // Kirjat
        lib.addBook(new Book("Clean Code", "Robert C. Martin", "9780132350884"));
        lib.addBook(new Book("Effective Java", "Joshua Bloch", "9780134685991"));

        // Jäsenet
        LibraryMember a = new LibraryMember("Abbas", 1);
        LibraryMember s = new LibraryMember("Sara", 2);
        lib.addMember(a);
        lib.addMember(s);

        // Varaus
        lib.reserveBook(2, "9780132350884");    // Sara varaa Clean Code
        lib.displayReservedBooks(2);

        // Lainataan toinen kirja (ei varattu)
        lib.borrowBook(1, "9780134685991");     // Abbas lainaa Effective Java

        // Varaus estää toista lainaamasta:
        lib.borrowBook(1, "9780132350884");     // epäonnistuu: varattu Saralle

        // Varaaja saa lainata kun kirja on saatavilla:
        lib.borrowBook(2, "9780132350884");     // onnistuu ja varaus poistuu

        // Palautus & tulostus
        lib.returnBook(1, "9780134685991");
        System.out.println("\n--- Status ---");
        lib.printBooks();
        lib.printMembers();

        // Mahdollinen peruutus
        lib.cancelReservation(2, "9780132350884"); // ei tee mitään, varaus jo poistui
    }
}
