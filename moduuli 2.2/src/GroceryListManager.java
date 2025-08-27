import java.util.ArrayList;

public class GroceryListManager {

    // vaihdetaan lista säilömään GroceryItem olioita Stringien sijaan.
    private ArrayList<GroceryItem> groceryList = new ArrayList<>();

    // Uusi metodi tuotteelle ja hinnanlle.

    public void addItem(String name, double cost) {
        GroceryItem newItem = new GroceryItem(name, cost);
        groceryList.add(newItem);
    }

    // päivitetty metodi listan näyttämiseenn
    public void displayList() {
        System.out.println("Ostoslista:");
        for (int i = 0; i < groceryList.size(); i++) {
            GroceryItem currentItem = groceryList.get(i);
            // kysytään tuotteen nimi
            System.out.println((i + 1) + ". " + currentItem.getName() + " (" + currentItem.getCost() + "€)");
        }
    }

    //uusi metodi kokonais hinnan laskemiseen.
    public double calculateTotalCost() {
        double totalCost = 0.0;
        // Käydään läpi kaikki if silmukalla
        for (GroceryItem item : groceryList) {
            // Lisätään tuotteen hinta kokonaissummaan
            totalCost += item.getCost();
        }
        return totalCost;
    }


    // Pääohjelma jolla voi testata
    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        //  tuotteita jahintoja
        manager.addItem("Maito", 1.50);
        manager.addItem("Leipä", 2.50);
        manager.addItem("Juusto", 5.00);
        manager.displayList();

        // printaus
        double total = manager.calculateTotalCost();
        System.out.printf("\nOstosten kokonaishinta: %.2f€\n", total);
    }
}