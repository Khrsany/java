package tehtava_4;

import java.util.ArrayList; //  arvostelulistan printtamiseen

public class LibraryMain {
    public static void main(String[] args) {
        // Luodaan kirjat kuten ennenkin.
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);

        System.out.println("--- Kirjat alussa (ilman arvosanoja) ---");
        System.out.println("1. " + book1);
        System.out.println("2. " + book2);

        System.out.println("\n--- Arvosana- ja arvostelutestit ---");

        //anetaan ensimmäiselle kirjalle arvosana ja arvostelu
        System.out.println("\nAnnetaan kirjalle 1 arvosana 4.5 ja arvostelu...");
        book1.setRating(4.5);
        book1.addReview("Todella kattava perusteos Javaan.");

        //annetaan toiselle kirjalle arvosana ja kaksi arvostelua
        System.out.println("Annetaan kirjalle 2 arvosana 3.8 ja kaksi arvostelua...");
        book2.setRating(3.8);
        book2.addReview("Hyvä, mutta vaikeaselkoinen paikoin.");
        book2.addReview("Ehdottomasti lukemisen arvoinen, jos aihe kiinnostaa.");

        //yritetään antaa virheellinen arvosana
        System.out.println("Yritetään antaa virheellinen arvosana (7.0)...");
        book1.setRating(7.0);


        System.out.println("\n--- Kirjojen tiedot päivitysten jälkeen ---");

        //printtaa kirja 1.:n tiedot
        System.out.println("\nKirja 1:");
        System.out.println(book1); // toString() näyttää nyt arvosanan
        //etitään ja printataan kirjan arvostelut
        ArrayList<String> reviews1 = book1.getReviews();
        System.out.println("Arvostelut (" + reviews1.size() + " kpl):");
        for (String review : reviews1) {
            System.out.println("- " + review);
        }

        //printaaan kirja 2:n tiedot
        System.out.println("\nKirja 2:");
        System.out.println(book2);
        ArrayList<String> reviews2 = book2.getReviews();
        System.out.println("Arvostelut (" + reviews2.size() + " kpl):");
        for (String review : reviews2) {
            System.out.println("- " + review);
        }
    }
}