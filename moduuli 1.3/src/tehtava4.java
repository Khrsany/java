import java.util.Scanner;
public class tehtava4 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            int pisteet = 0;

            for (int i = 0; i < 10; i++) {
                int luku1 = (int) (Math.random() * 10) + 1;
                int luku2 = (int) (Math.random() * 10) + 1;
                int oikeaVastaus = luku1 * luku2;

                System.out.print(luku1 + " * " + luku2 + " = ? ");
                int kayttajanVastaus = Integer.parseInt(scanner.nextLine());

                if (kayttajanVastaus == oikeaVastaus) {
                    System.out.println("Oikein!");
                    pisteet++;
                } else {
                    System.out.println("Väärin. Oikea vastaus oli " + oikeaVastaus);
                }
            }
            if (pisteet == 10) {
                System.out.println("Onneksi olkoon, osaat kertotaulut!");
                break;
            } else {
                System.out.println("Sait " + pisteet + "/10 pistettä. Yritetään uudelleen!");
            }
        }
    }
}