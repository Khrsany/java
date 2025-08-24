import java.util.Scanner;
public class tehtava1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a temperature in Fahrenheit: ");
        double fahrenheit = Double.parseDouble(sc.nextLine());

        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        System.out.printf("%.1f Fahrenheit is %.1f in Celsius.", fahrenheit, celsius);

    }
}