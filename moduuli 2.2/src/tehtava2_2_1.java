import java.util.ArrayList;

public class tehtava2_2_1 {
    // 2. ArrayList, joka säilöö ostoslistan tuotteet merkkijonoina.
    private ArrayList<String> groceryList = new ArrayList<>();

    // 3. Metodit listan hallintaan

    /**
     * Lisää tuotteen ostoslistalle.
     * @param item Lisättävä tuote.
     */
    public void addItem(String item) {
        groceryList.add(item);
        System.out.println("\"" + item + "\" lisätty listalle.");
    }

    /**
     * Poistaa tuotteen ostoslistalta.
     * @param item Poistettava tuote.
     */
    public void removeItem(String item) {
        if (groceryList.remove(item)) {
            System.out.println("\nPoistetaan \"" + item + "\" listalta...");
        } else {
            System.out.println("Tuotetta \"" + item + "\" ei löytynyt listalta.");
        }
    }

    /**
     * Tulostaa koko ostoslistan numeroituna.
     */
    public void displayList() {
        System.out.println("\nOstoslista:");
        if (groceryList.isEmpty()) {
            System.out.println("Lista on tyhjä.");
        } else {
            for (int i = 0; i < groceryList.size(); i++) {
                System.out.println((i + 1) + ". " + groceryList.get(i));
            }
        }
    }

    /**
     * Tarkistaa, onko tietty tuote listalla.
     * @param item Etsittävä tuote.
     * @return true, jos tuote löytyy, muuten false.
     */
    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }

    // 4. Pääohjelma toiminnallisuuden testaamiseen
    public static void main(String[] args) {
        tehtava2_2_1 manager = new tehtava2_2_1();

        // Lisätään muutama tuote
        manager.addItem("Omenat");
        manager.addItem("Maito");
        manager.addItem("Leipä");

        // Näytetään lista
        manager.displayList();

        // Tarkistetaan löytyykö tuote
        String itemToCheck = "Maito";
        System.out.println("\nOnko \"" + itemToCheck + "\" ostoslistalla? " + manager.checkItem(itemToCheck));

        // Poistetaan tuote
        manager.removeItem("Maito");

        // Näytetään päivitetty lista
        manager.displayList();
    }
}