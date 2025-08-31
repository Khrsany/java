package tehtava_4;

import java.util.ArrayList; // TÄRKEÄÄ: Tarvitaan arvostelujen listaa varten!

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    // --- UUDET MUUTTUJAT TEHTÄVÄÄN 4 ---
    private double rating; // Muuttuja arvosanalle (esim. 4.5)
    private ArrayList<String> reviews; // Lista sanallisille arvosteluille

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;

        // Alustetaan uudet muuttujat konstruktorissa.
        // Jokaisella uudella kirjalla on oletusarvosana 0.0 ja tyhjä lista arvosteluille.
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    // --- VANHAT GETTER-METODIT ---
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    // --- UUDET METODIT TEHTÄVÄÄN 4 ---

    /**
     * Asettaa kirjalle arvosanan.
     * Varmistaa, että arvosana on välillä 0-5.
     * @param rating Kirjalle annettava arvosana.
     */
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Virheellinen arvosana. Anna arvo väliltä 0-5.");
        }
    }

    /**
     * Lisää kirjalle uuden sanallisen arvostelun.
     * @param review Arvosteluteksti.
     */
    public void addReview(String review) {
        this.reviews.add(review);
    }

    // --- UUDET GETTER-METODIT TEHTÄVÄÄN 4 ---

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * Päivitetty toString(), joka näyttää nyt myös kirjan arvosanan.
     */
    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear + ", Rating: " + rating;
    }
}