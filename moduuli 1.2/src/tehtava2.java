import java.util.Scanner;
public class tehtava2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the lengths of the first leg  ");
        double first = Double.parseDouble(sc.nextLine());
        System.out.print("enter the lengths of the second leg  ");
        double second = Double.parseDouble(sc.nextLine());

        double hypotenuse =(Math.sqrt(Math.pow(first,2)+Math.pow(second,2)));
        System.out.printf("hypetenuusan pituus on %.2f ",hypotenuse);


    }
}