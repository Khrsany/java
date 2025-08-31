package tehtava_6;

import java.util.ArrayList;
public class User {
    private String name;
    private int age;
    //jjokaisella käyttäjällä on oma lista kirjoista jotka hän on lainannut
    private ArrayList<Book> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>(); //alustetaan lista tyhjäksi
    }

    //Gettermetodit
    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    //Metodi lisää kirjan käyttäjän lainattujen listalle. Kirjasto kutsuu tätä.
    public void borrowBook(Book book) {
        this.borrowedBooks.add(book);
    }

    //metodi poistaa kirjan käyttäjän lainattujen listalta Kirjasto kutsuu tätä
    public boolean returnBook(Book book) {
        // .remove() palauttaa true, jos poisto onnistui muuten false.
        return this.borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "Käyttäjä: " + name + " (Ikä: " + age + "), Lainatut kirjat: " + borrowedBooks.size() + " kpl";
    }
}