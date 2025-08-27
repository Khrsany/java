public class CategorizedItem {
    private String name;
    private double cost;
    private String category;

    // nyt se on päivitetty ottamaan vastaan myös kategoria
    public CategorizedItem(String name, double cost, String category) {
        this.name = name;
        this.cost = cost;
        this.category = category;
    }

    // getter metodit joilla voidaan lukea olion tietoia
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }
}