package library.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryMember {
    private final String name;
    private final int memberId;
    private final List<Book> borrowedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName()   { return name; }
    public int getMemberId()  { return memberId; }

    // Kirjat joita jäsenellä on lainassa
    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks);
    }

    // paketinsisäinen käyttö kirjastolta
    public void addBorrowed(Book b)   { borrowedBooks.add(b); }
    public void removeBorrowed(Book b){ borrowedBooks.remove(b); }

    @Override
    public String toString() { return name + " (id: " + memberId + ")"; }
}
