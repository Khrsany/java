package tehtava_4;

public class Circle extends Shape {
    private double radius;

    //konstruktorin pitää nyt ottaa vastaan myös väri ja välittää se yläluokalle.
    public Circle(String color, double radius) {
        super(color); // Kutsutaan yläluokan (Shape) konstruktoria ja annetaan sille väri.
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        //päivitetään toString sisältämään myös väri.
        return "Circle (color: " + getColor() + ", radius: " + this.radius + ")";
    }
}