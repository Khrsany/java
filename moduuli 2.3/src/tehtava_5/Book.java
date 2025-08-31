package tehtava_5;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

    //muuttujat arvosanalle ja arvosteluille
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;

        //alusttetaan uudet muuttujat
        this.rating = 0.0;
        this.reviews = new ArrayList<>();
    }

    //samat vanhat metodit¨¨
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Virheellinen arvosana. Anna arvo väliltä 0-5.");
        }
    }

    public void addReview(String review) {
        this.reviews.add(review);
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear + ", Rating: " + rating;
    }
}