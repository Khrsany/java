import java.util.Scanner;
import java.util.ArrayList;

public class tehtava3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Anna taulukon koko: ");
        int size = scanner.nextInt();
        int[] originalArray = new int[size];

        System.out.println("Syötä luvut taulukkoon:");
        for (int i = 0; i < size; i++) {
            System.out.print("Syötä luku " + (i + 1) + ": ");
            originalArray[i] = scanner.nextInt();
        }
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (int number : originalArray) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }

        System.out.println("\nTaulukko ilman duplikaatteja:");
        for (int uniqueNumber : uniqueList) {
            System.out.print(uniqueNumber + " ");
        }
        System.out.println();

        scanner.close();
    }
}