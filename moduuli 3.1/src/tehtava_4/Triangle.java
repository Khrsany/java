package tehtava_4;

public class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(String color, double base, double height) {
        super(color); //välitetään väri yläluokalle.
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle (color: " + getColor() + ", base: " + this.base + ", height: " + this.height + ")";
    }
}