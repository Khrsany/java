package tehtava_4;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String color, double width, double height) {
        super(color); //välitetään väri yläluokalle
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle (color: " + getColor() + ", width: " + this.width + ", height: " + this.height + ")";
    }
}