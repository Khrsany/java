package tehtava_2;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Fibonacci_csv {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("Fibonacci.csv");
             BufferedWriter bw = new BufferedWriter(fw)) {

            // Otsikkorivi
            bw.write("Index;Value");
            bw.newLine();

            // Fibonacci-laskenta
            int a = 0;
            int b = 1;
            for (int i = 0; i < 20; i++) {
                bw.write(i + ";" + a);
                bw.newLine();

                int next = a + b;
                a = b;
                b = next;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
