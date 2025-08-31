package tehtava_1;
import java.util.ArrayList;

public class Library {
    //luodaan yksityinen array list jossa tallennetaan kaikki kirjaston book oliot.
    private ArrayList<Book> books = new ArrayList<>();

    //lisää annetun book olion kirjaston kokoelmaan
    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        //käy läpi kaikki kirjat books listall
        for (int i = 0; i < books.size(); i++) {
            // Haetaan kirja listalta indeksin perusteella ja tulostetaan sen tiedot.
            // Käytetään kirjan toString()-metodia, vaikka sitä ei erikseen kutsutakaan.
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("\nBooks by Author \"" + author + "\":");
        boolean found = false;
        //kääydään läpi kaikki kirjat listall
        for (Book book : this.books) {
            //verrataan kirjan kirjailijaa annettuun nimeen
            //string olioita verrataan AINAAA .equals() metodill
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
                found = true;
            }
        }
        //Jos yhtään kirjaa ei löyty. tulostetaan ilmoitus
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }
}