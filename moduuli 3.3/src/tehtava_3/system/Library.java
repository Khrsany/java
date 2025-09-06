package tehtava_3.system;

import tehtava_3.model.Book;
import tehtava_3.model.LibraryMember;

import java.util.*;

public class Library {

    // Perusrekisterit
    private final Map<String, Book>           booksByIsbn   = new HashMap<>();
    private final Map<Integer, LibraryMember> membersById   = new HashMap<>();
    private final Set<String>                 availableIsbn = new HashSet<>();

    // Kuka on lainannut? ISBN -> memberId
    private final Map<String, Integer> borrowedBy = new HashMap<>();
    // Kuka on varannut? ISBN -> memberId
    private final Map<String, Integer> reservedBy = new HashMap<>();

    // ---- Perustoiminnot
    public void addBook(Book book) {
        if (booksByIsbn.containsKey(book.getIsbn())) {
            System.out.println("Book already exists: " + book.getIsbn());
            return;
        }
        booksByIsbn.put(book.getIsbn(), book);
        availableIsbn.add(book.getIsbn());
    }

    public void addMember(LibraryMember member) {
        if (membersById.containsKey(member.getMemberId())) {
            System.out.println("Member id already exists: " + member.getMemberId());
            return;
        }
        membersById.put(member.getMemberId(), member);
    }

    // ---- VARAUS
    public boolean reserveBook(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = booksByIsbn.get(isbn);
        if (m == null || b == null) {
            System.out.println("Unknown member or book.");
            return false;
        }
        if (b.isReserved()) {
            System.out.println("Book is already reserved.");
            return false;
        }
        if (borrowedBy.containsKey(isbn) && Objects.equals(reservedBy.get(isbn), memberId)) {
            System.out.println("Book already reserved by you.");
            return true;
        }
        b.setReserved(true);
        reservedBy.put(isbn, memberId);
        m.addReserved(b);
        System.out.println("Reserved: " + b + " for " + m);
        return true;
    }

    public boolean cancelReservation(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = booksByIsbn.get(isbn);
        if (m == null || b == null) return false;

        Integer who = reservedBy.get(isbn);
        if (!Objects.equals(who, memberId)) {
            System.out.println("This member didn't reserve the book.");
            return false;
        }
        reservedBy.remove(isbn);
        b.setReserved(false);
        m.removeReserved(b);
        System.out.println("Reservation canceled: " + b + " by " + m);
        return true;
    }

    public void displayReservedBooks(int memberId) {
        LibraryMember m = membersById.get(memberId);
        if (m == null) return;
        System.out.println("Reserved books for " + m.getName() + ":");
        for (Book b : m.getReservedBooks()) {
            System.out.println(" - " + b);
        }
    }

    // ---- Lainaus & palautus (minimi, jotta varaus toimii)
    public boolean borrowBook(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = booksByIsbn.get(isbn);
        if (m == null || b == null) {
            System.out.println("Unknown member or book.");
            return false;
        }
        if (!availableIsbn.contains(isbn)) {
            System.out.println("Book not available to borrow.");
            return false;
        }
        Integer reserver = reservedBy.get(isbn);
        if (b.isReserved() && !Objects.equals(reserver, memberId)) {
            System.out.println("Book is reserved for another member.");
            return false;
        }

        availableIsbn.remove(isbn);
        borrowedBy.put(isbn, memberId);
        m.addBorrowed(b);

        if (Objects.equals(reserver, memberId)) {
            reservedBy.remove(isbn);
            b.setReserved(false);
            m.removeReserved(b);
        }
        System.out.println("Borrowed: " + b + " by " + m);
        return true;
    }

    public boolean returnBook(int memberId, String isbn) {
        LibraryMember m = membersById.get(memberId);
        Book b = booksByIsbn.get(isbn);
        if (m == null || b == null) return false;

        Integer who = borrowedBy.get(isbn);
        if (!Objects.equals(who, memberId)) {
            System.out.println("This member didn't borrow the book.");
            return false;
        }

        borrowedBy.remove(isbn);
        m.removeBorrowed(b);
        availableIsbn.add(isbn);
        System.out.println("Returned: " + b + " by " + m);
        return true;
    }

    // Tulostuksia
    public void printBooks() {
        System.out.println("All books:");
        for (Book b : booksByIsbn.values()) {
            boolean available = availableIsbn.contains(b.getIsbn());
            String status = available ? "available" : "borrowed";
            if (b.isReserved()) status += ", reserved";
            System.out.println(" - " + b + " [" + status + "]");
        }
    }

    public void printMembers() {
        System.out.println("Members:");
        for (LibraryMember m : membersById.values()) {
            System.out.println(" - " + m + " | borrowed: " + m.getBorrowedBooks().size()
                    + " | reserved: " + m.getReservedBooks().size());
        }
    }
}
