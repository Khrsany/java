package library.model;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final String isbn; // yksilöivä tunnus

    public Book(String title, String author, String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle()  { return title; }
    public String getAuthor() { return author; }
    public String getIsbn()   { return isbn; }

    @Override
    public String toString() {
        return title + " / " + author + " (ISBN: " + isbn + ")";
    }

    // Sama kirja tunnistetaan ISBN:llä
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }
    @Override
    public int hashCode() { return Objects.hash(isbn); }
}
