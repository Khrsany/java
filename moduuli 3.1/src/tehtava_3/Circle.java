package tehtava_3;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    //ylikirjoitetaan Shape luokan metodi omalla oikealla laskutoimituksella.
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    //tässäki ylikirjoitetaan oletus toString jotta tulostus on siistimpi.
    @Override
    public String toString() {
        return "Circle with radius " + this.radius;
    }
}