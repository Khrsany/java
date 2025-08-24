import java.util.Scanner;
public class tehtava3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a weight in grams: ");
        double grammat = Double.parseDouble(sc.nextLine());

        double luotiGrammoina = (13.28);
        double naulaGrammoina = 32 * luotiGrammoina;
        double leiviskaGrammoina = 20 * naulaGrammoina;

        System.out.println("Weight (g): " + grammat);
        int leiviskat = (int) (grammat / leiviskaGrammoina);
        double grammatLeiviskoidenJalkeen = grammat % leiviskaGrammoina;
        int naulat = (int) (grammatLeiviskoidenJalkeen / naulaGrammoina);
        double grammatNaulojenJalkeen = grammatLeiviskoidenJalkeen % naulaGrammoina;
        double luodit = grammatNaulojenJalkeen / luotiGrammoina;

        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.", grammat, leiviskat, naulat, luodit);



    }
}