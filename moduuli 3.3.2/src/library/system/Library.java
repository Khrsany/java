package library.system;

import library.model.Book;
import library.model.LibraryMember;

import java.util.*;

public class Library {
    // Yksinkertainen hallinta: "hyllyssä" olevat kirjat ja jäsenet
    private final Map<String, Book> allBooksByIsbn = new HashMap<>();
    private final Set<String> availableIsbns = new HashSet<>();
    private final Map<Integer, LibraryMember> membersById = new HashMap<>();

    // Lisää kirja kokoelmaan ja merkitse vapaaksi
    public void addBook(Book book) {
        if (allBooksByIsbn.containsKey(book.getIsbn())) {
            System.out.println("Book with ISBN already exists: " + book.getIsbn());
            return;
        }
        allBooksByIsbn.put(book.getIsbn(), book);
        availableIsbns.add(book.getIsbn());
    }

    // Lisää jäsen
    public void addMember(LibraryMember member) {
        if (membersById.containsKey(member.getMemberId())) {
            System.out.println("Member id already exists: " + member.getMemberId());
            return;
        }
        membersById.put(member.getMemberId(), member);
    }

    // Lainaus: kirja pitää olla olemassa ja vapaana
    public boolean borrowBook(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = allBooksByIsbn.get(isbn);
        if (m == null || b == null) {
            System.out.println("Unknown member or book.");
            return false;
        }
        if (!availableIsbns.contains(isbn)) {
            System.out.println("Book is not available: " + isbn);
            return false;
        }
        availableIsbns.remove(isbn);
        m.addBorrowed(b);
        return true;
    }

    // Palautus: kirjan tulee olla jäsenellä
    public boolean returnBook(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = allBooksByIsbn.get(isbn);
        if (m == null || b == null) {
            System.out.println("Unknown member or book.");
            return false;
        }
        if (!m.getBorrowedBooks().contains(b)) {
            System.out.println("Member does not hold this book.");
            return false;
        }
        m.removeBorrowed(b);
        availableIsbns.add(isbn);
        return true;
    }

    // Pieniä apumetodeja tulostukseen ja testaukseen
    public void printBooks() {
        System.out.println("All books:");
        for (Book b : allBooksByIsbn.values()) {
            String status = availableIsbns.contains(b.getIsbn()) ? "available" : "borrowed";
            System.out.println(" - " + b + " [" + status + "]");
        }
    }

    public void printMembers() {
        System.out.println("Members:");
        for (LibraryMember m : membersById.values()) {
            System.out.println(" - " + m + " | borrowed: " + m.getBorrowedBooks().size());
        }
    }
}
