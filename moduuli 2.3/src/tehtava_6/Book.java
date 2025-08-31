package tehtava_6;

import java.util.ArrayList;

public class Book {
//samat metodit jää
    private String title, author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;
    public Book(String title, String author, int publicationYear) {
        this.title = title; this.author = author; this.publicationYear = publicationYear;
        this.rating = 0.0; this.reviews = new ArrayList<>();
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }
    public void setRating(double rating) { if (rating >= 0 && rating <= 5) this.rating = rating; }
    public void addReview(String review) { this.reviews.add(review); }
    public double getRating() { return rating; }
    public ArrayList<String> getReviews() { return reviews; }
    @Override public String toString() {
        return "Title: \"" + title + "\", Author: \"" + author + "\", Year: " + publicationYear + ", Rating: " + rating;
    }
}