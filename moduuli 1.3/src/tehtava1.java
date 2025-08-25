import java.util.Scanner;
public class tehtava1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the first number (a): ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("enter the second number (b): ");
        double b = Double.parseDouble(input.nextLine());
        System.out.print("enter the third number (c): ");
        double c = Double.parseDouble(input.nextLine());

        double d = b * b - 4 * a * c;


        if (d > 0) {
            double juuri1 = (-b + Math.sqrt(d)) / (2 * a);
            double juuri2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("yhtälöllä on kaksi juurta: " + juuri1 + "ja" + juuri2);
        } else if (d ==0) {
            double juuri1 = -b / (2 * a);
            System.out.println("yhtälöllä on yksi juuri: " + juuri1);
        } else {
            System.out.println("No real roots.");
        }


    }
}