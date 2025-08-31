package tehtava_1;
//pääohjelma
public class LibraryMain {
    public static void main(String[] args) {
        //tehään uusi libary olio
        Library myLibrary = new Library();

        //3 uutta book oliota
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);
        Book book4 = new Book("Advanced Java", "Jane Doe", 2021);

        //lisätään luodut kirjat kirjastoon
        myLibrary.addBook(book1);
        myLibrary.addBook(book2);
        myLibrary.addBook(book3);
        myLibrary.addBook(book4);

        //tulostetaan kaikki kirjaston kirjatt
        myLibrary.displayBooks();

        //etsitään ja tulostetaan kirjat tietyltä kirjailijalta
        myLibrary.findBooksByAuthor("Jane Doe");

        //testataan tämä tapaus jossa kirjailijaa ei löydy
        myLibrary.findBooksByAuthor("Kevin Mitnick");
    }
}