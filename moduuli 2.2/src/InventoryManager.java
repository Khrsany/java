import java.util.ArrayList;

public class InventoryManager {

    private ArrayList<InventoryItem> groceryList = new ArrayList<>();
    public void addItem(String name, double cost, String category, int quantity) {
        InventoryItem newItem = new InventoryItem(name, cost, category, quantity);
        groceryList.add(newItem);
    }

    //p*äivittää tietyn tuotteen määrä
    public void updateQuantity(String itemName, int newQuantity) {
        for (InventoryItem item : groceryList) {
            // etsitään oikea tuote nimen perusteella
            if (item.getName().equalsIgnoreCase(itemName)) {
                item.setQuantity(newQuantity);
                System.out.println("\nPäivitettiin tuotteen '" + itemName + "' määräksi " + newQuantity);
                return; // poisttuaabn metodista, kun tuote on löytynyt ja päivitetty
            }
        }
        System.out.println("Tuotetta '" + itemName + "' ei löytynyt päivitystä varten.");
    }


    //näyttetään kaikki tuotteet joiden määrä on enemmän kuin nolla
    public void displayAvailableItems() {
        System.out.println("\nSaatavilla olevat tuotteet:");
        for (InventoryItem item : groceryList) {
            if (item.getQuantity() > 0) {
                System.out.println(
                        "- " + item.getName() +
                                " (Hinta: " + item.getCost() + "€, " +
                                "Kategoria: " + item.getCategory() + ", " +
                                "Määrä: " + item.getQuantity() + ")"
                );
            }
        }
    }

    //muokkaus nyt se laksee kokonaishinnan ottaen huomioon tuotteiden määrä
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (InventoryItem item : groceryList) {
            // hinta kerrotaan nyt määrällä
            totalCost += item.getCost() * item.getQuantity();
        }
        return totalCost;
    }
    // Pääohjelma
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Lisätäännyt myös määrät mukana
        manager.addItem("Maito", 1.50, "Maitotuotteet", 2);
        manager.addItem("Omena", 0.30, "Hedelmät", 5);
        manager.addItem("Leipä", 2.50, "Leipomotuotteet", 1);

        System.out.println("--- Alkuperäinen lista ---");
        manager.displayAvailableItems();

        // testi määrän päivitystä
        manager.updateQuantity("Omena", 10);

        System.out.println("\n--- Lista päivityksen jälkeen ---");
        manager.displayAvailableItems();

        // lopullinen kokonaishinta
        double total = manager.calculateTotalCost();
        System.out.printf("\nOstosten lopullinen kokonaishinta: %.2f€\n", total);
    }
}