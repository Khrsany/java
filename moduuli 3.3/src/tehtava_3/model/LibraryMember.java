package tehtava_3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryMember {
    private final String name;
    private final int memberId;

    private final List<Book> borrowedBooks = new ArrayList<>();
    private final List<Book> reservedBooks = new ArrayList<>();

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    public String getName()  { return name; }
    public int getMemberId() { return memberId; }

    public List<Book> getBorrowedBooks() { return Collections.unmodifiableList(borrowedBooks); }
    public List<Book> getReservedBooks() { return Collections.unmodifiableList(reservedBooks); }

    // paketinsisäiset apurit (sama paketti tehtava_3.model)
    public void addBorrowed(Book b)   { borrowedBooks.add(b); }
    public void removeBorrowed(Book b){ borrowedBooks.remove(b); }

    public void addReserved(Book b)   { reservedBooks.add(b); }
    public void removeReserved(Book b){ reservedBooks.remove(b); }

    public boolean hasReserved(Book b) { return reservedBooks.contains(b); }

    @Override
    public String toString() {
        return name + " (id: " + memberId + ")";
    }
}
