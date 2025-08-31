package tehtava_4;

import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        //annetaan nyt myös värit, kun luomme olioit.
        shapes.add(new Circle("Red", 5.0));
        shapes.add(new Rectangle("Blue", 4.0, 6.0));
        shapes.add(new Triangle("Green", 3.0, 8.0));

        System.out.println("Shape Calculator\n");

        //printataan päivitetyt tiedot
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " -> Area: " + shape.calculateArea());
        }
    }
}