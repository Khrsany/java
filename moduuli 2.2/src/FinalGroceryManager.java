import java.util.ArrayList;
public class FinalGroceryManager {
    private ArrayList<FinalGroceryItem> groceryList = new ArrayList<>();

    // Tämän luokan metodit addItem updateQuantityovat
    public void addItem(String name, double cost, String category, int quantity) {
        FinalGroceryItem newItem = new FinalGroceryItem(name, cost, category, quantity);
        groceryList.add(newItem);
    }

    public void updateQuantity(String itemName, int newQuantity) {
        for (FinalGroceryItem item : groceryList) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                return;
            }
        }
    }

    public void displayByCategory(String category) {
        System.out.println("\n--- Tuotteet kategoriassa: " + category + " ---");
        boolean found = false;
        for (FinalGroceryItem item : groceryList) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println("- " + item.getName() + " (Määrä: " + item.getQuantity() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ei tuotteita.");
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (FinalGroceryItem item : groceryList) {
            totalCost += item.getCost() * item.getQuantity();
        }
        return totalCost;
    }

    //KATTAVA TESTIOHJELMA MAIN METODISSA
    public static void main(String[] args) {
        FinalGroceryManager manager = new FinalGroceryManager();
        System.out.println("Käynnistetään ostoslistan hallintaohjelman testi...");

        //tuotteiden lisäyss
        System.out.println("\n--- Vaihe 1: Lisätään tuotteita listalle ---");
        manager.addItem("Maito", 1.50, "Maitotuotteet", 2);
        manager.addItem("Juusto", 5.00, "Maitotuotteet", 1);
        manager.addItem("Omena", 0.30, "Hedelmät", 5);
        manager.addItem("Leipä", 2.50, "Leipomotuotteet", 1);
        System.out.println("Tuotteet lisätty.");

        //testataan määrä
        System.out.println("\n--- Vaihe 2: Testataan määrän seurantaa ---");
        System.out.println("Alkuperäinen omenien määrä: " + manager.groceryList.get(2).getQuantity());
        manager.updateQuantity("Omena", 10);
        System.out.println("Päivitetty omenien määrä: " + manager.groceryList.get(2).getQuantity());

        // kategorin testaus
        System.out.println("\n--- Vaihe 3: Testataan kategorioita ---");
        manager.displayByCategory("Maitotuotteet");
        manager.displayByCategory("Hedelmät");

        //kokonaishinnan testaus määrät huomioiden
        System.out.println("\n--- Vaihe 4: Testataan kokonaishinnan laskentaa ---");
        System.out.println("Lasketaan listan kokonaishinta...");
        System.out.println("Laskelma: (2 * 1.50€) + (1 * 5.00€) + (10 * 0.30€) + (1 * 2.50€)");
        double total = manager.calculateTotalCost();
        System.out.printf("Lopullinen kokonaishinta: %.2f€\n", total);

        System.out.println("\nTesti suoritettu onnistuneesti!");
    }
}