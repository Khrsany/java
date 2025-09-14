package tehtava_1;

public class Calculator {
    private int currentValue;

    public Calculator() {
        // Konstruktori, joka nollaa laskimen luodessa. Copilot saattaa lisätä tämän.
        this.currentValue = 0;
    }

    public void reset() {
        currentValue = 0;
    }

    // Adds a positive integer to the calculator. Throws an exception if the number is negative.
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        currentValue += number;
    }

    public int getValue() {
        return currentValue;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Luodaan uusi laskin-olio

        System.out.println("Laskimen arvo alussa: " + calc.getValue());

        // Lisätään lukuja
        calc.add(10);
        calc.add(5);

        System.out.println("Arvo lisäysten jälkeen: " + calc.getValue());

        // Nollataan laskin
        calc.reset();
        System.out.println("Arvo nollauksen jälkeen: " + calc.getValue());

        // Kokeillaan lisätä negatiivinen luku
        try {
            System.out.println("Yritetään lisätä -3...");
            calc.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("Tapahtui virhe: " + e.getMessage());
        }
    }
}