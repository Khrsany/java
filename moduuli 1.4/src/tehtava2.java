import java.util.Scanner;

public class tehtava2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Anna taulukon koko: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        System.out.println("Syötä luvut taulukkoon:");
        for (int i = 0; i < size; i++) {
            System.out.print("Syötä luku " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        int maxSum = Integer.MIN_VALUE;
        int bestStartIndex = 0;
        int bestEndIndex = 0;

        for (int i = 0; i < size; i++) {
            int currentSum = 0;
            for (int j = i; j < size; j++) {
                currentSum += numbers[j];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    bestStartIndex = i;
                    bestEndIndex = j;
                }
            }
        }
        System.out.println("\nSuurin summa: " + maxSum);
        System.out.println("Luvut indekseistä: " + (bestStartIndex + 1) + "-" + (bestEndIndex + 1));

        scanner.close();
    }
}