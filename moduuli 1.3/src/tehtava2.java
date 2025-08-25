import java.util.Scanner;
public class tehtava2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("syötä binaariluku: ");
        String binaariLuku = sc.nextLine();

        int desimaaliluku = 0;
        int pituus = binaariLuku.length();

        for (int i = 0; i < pituus; i++) {
            char merkki = binaariLuku.charAt(i);

            if (merkki == '1') {
                int potenssi = pituus - 1 - i;
                double paikanAvro = Math.pow(2, potenssi);
                desimaaliluku += paikanAvro;
            }
        }

        System.out.println("Desimaalilukuna: " +desimaaliluku);


    }
}