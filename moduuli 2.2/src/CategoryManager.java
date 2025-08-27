import java.util.ArrayList;
public class CategoryManager {

    private ArrayList<CategorizedItem> groceryList = new ArrayList<>();

    //lisää tuotteen hinta ja kategoria listaan
    public void addItem(String name, double cost, String category) {
        CategorizedItem newItem = new CategorizedItem(name, cost, category);
        groceryList.add(newItem);
    }

     //prinnttaa kaikki ostoslistan tuotteet ja  tiedot.

    public void displayList() {
        System.out.println("Ostoslista:");
        for (int i = 0; i < groceryList.size(); i++) {
            CategorizedItem item = groceryList.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " (" + item.getCost() + "€, " + item.getCategory() + ")");
        }
    }

    //näytetään kaikki tuotteet jotka kuuluvat annettuun kategoriaan
    public void displayByCategory(String category) {
        System.out.println("\nNäytetään tuotteet kategoriasta: " + category);
        boolean found = false;
        for (CategorizedItem item : groceryList) {
            // Verrataan tuotteen kategoriaa kirjainkoosta riippumatta
            if (item.getCategory().equalsIgnoreCase(category)) {
                System.out.println("- " + item.getName() + " (" + item.getCost() + "€)");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Ei tuotteita tässä kategoriassa.");
        }
    }

    // Pääohjelmajoka testaa
    public static void main(String[] args) {
        //tehään uusi manageri olio
        CategoryManager manager = new CategoryManager();

        // lisätään tuottetaa hintoja ja kategorioita
        manager.addItem("Maito", 1.50, "Maitotuotteet");
        manager.addItem("Leipä", 2.50, "Leipomotuotteet");
        manager.addItem("Juusto", 5.00, "Maitotuotteet");
        manager.addItem("Omena", 0.30, "Hedelmät");
        manager.displayList();

        // testataan uutta displaybyCategory metodia
        manager.displayByCategory("Maitotuotteet");
        manager.displayByCategory("Hedelmät");
        manager.displayByCategory("Lihat"); // katsoo kategoriaa jossa ei ole tuotteit
    }
}