# Calculator Project with GitHub Copilot

This project demonstrates a simple `Calculator` class developed as an exercise in using the AI-assisted coding tool, GitHub Copilot. The program is a basic calculator model capable of summing positive integers.

## Source Code (`Calculator.java`)

```java
public class Calculator {
    private int currentValue;

    public Calculator() {
        this.currentValue = 0;
    }

    /**
     * Resets the calculator's current value to zero.
     */
    public void reset() {
        currentValue = 0;
    }

    /**
     * Adds a positive integer to the calculator's current value.
     * Throws an IllegalArgumentException if the number is negative.
     * @param number The positive integer to add.
     */
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        currentValue += number;
    }

    /**
     * Returns the current value of the calculator.
     * @return The current sum.
     */
    public int getValue() {
        return currentValue;
    }

    /**
     * A temporary main method for demonstrating and testing the Calculator class.
     */
    public static void main(String[] args) {
        Calculator calc = new Calculator(); 

        System.out.println("Initial value: " + calc.getValue());

        // Add numbers
        calc.add(10);
        calc.add(5);
        System.out.println("Value after additions: " + calc.getValue());

        // Reset the calculator
        calc.reset();
        System.out.println("Value after reset: " + calc.getValue());

        // Try to add a negative number
        try {
            System.out.println("Attempting to add -3...");
            calc.add(-3);
        } catch (IllegalArgumentException e) {
            System.out.println("An error occurred as expected: " + e.getMessage());
        }
    }
}