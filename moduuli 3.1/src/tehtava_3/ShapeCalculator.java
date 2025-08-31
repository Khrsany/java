package tehtava_3;

import java.util.ArrayList;
import java.util.List;

public class ShapeCalculator {
    public static void main(String[] args) {
        //tehään lista johon voi laittaa mitä tahansa Shape olioita
        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(5.0));
        shapes.add(new Rectangle(4.0, 6.0));
        shapes.add(new Triangle(3.0, 8.0));

        System.out.println("Shape Calculator\n");

        //käydään kaikki muodot läpi ja printataan niiden tiedot ja pintaala.
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape.toString() + ": " + shape.calculateArea());
        }
    }
}