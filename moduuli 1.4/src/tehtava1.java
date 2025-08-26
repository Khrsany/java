import java.util.Scanner;
import java.util.Random;

public class tehtava1 {
    public static void main(String[] args) {
        String[] firstNames = {"Matti", "Liisa", "Pekka", "Anna", "Juha", "Sari"};
        String[] lastNames = {"Virtanen", "Korhonen", "Nieminen", "Mäkinen", "Hämäläinen", "Laine"};

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Kuinka monta nimeä generoidaan? ");
        int numberOfNames = scanner.nextInt();

        System.out.println("Generoidut nimet:");

        for (int i = 0; i < numberOfNames; i++) {
            int firstNameIndex = random.nextInt(firstNames.length);

            int lastNameIndex = random.nextInt(lastNames.length);

            String fullName = firstNames[firstNameIndex] + " " + lastNames[lastNameIndex];
            System.out.println(fullName);
        }

        scanner.close();
    }
}
