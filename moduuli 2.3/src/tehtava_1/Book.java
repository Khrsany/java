package tehtava_1;
public class Book {
    //yksittyiset muuttujat
    private String title;
    private String author;
    private int publicationYear;

    //Konstruktori jota kutsutaan kun luodaan uusi Book-olio.
    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    // getter metodit. joilla katsotaan tiedot

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    //@Override tarkoittaa että ylikirjoitamme oletustoteutuksen
    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear;
    }
}