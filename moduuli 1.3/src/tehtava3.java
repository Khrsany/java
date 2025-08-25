import java.util.Scanner;

public class tehtava3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start number: ");
        int start = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the end number: ");
        int end = Integer.parseInt(scanner.nextLine());
        for (int number = start; number <= end; number++) {

            boolean onAlkuluku = true;
            if (number <= 1) {
                onAlkuluku = false;
            } else {
                for (int jakaja = 2; jakaja < number; jakaja++) {
                    if (number % jakaja == 0) {
                        onAlkuluku = false;
                        break;
                    }
                }
            }
            if (onAlkuluku) {
                System.out.println(number);
            }
        }
    }
}
