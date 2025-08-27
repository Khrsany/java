public class InventoryItem {
    private String name;
    private double cost;
    private String category;
    private int quantity; // uusi kenttä määrälle

    // päivitetty nyt ottamaan vastaan määräkin
    public InventoryItem(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    // gettee metodit kaikille ominaisuuksille
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    // muutos settermetodi määrän päivittämistä varten
    public void setQuantity(int quantity) {
        if (quantity >= 0) { // Varmistetaan ettei määrä ole negatiivinen
            this.quantity = quantity;
        }
    }
}