package tehtava_4.model;

public class Person {
    // --- kentät eri näkyvyysmääritteillä ---
    public static final String SPECIES = "Human"; // public + final (vakio), näkyy kaikkialle
    private String name;          // private: näkyy vain tässä luokassa
    protected int age;            // protected: näkyy tässä, aliluokissa (myös eri paketissa)
    int internalId;               // package-private: näkyy vain samassa paketissa (tehtava_4.model)

    // --- konstruktorit ---
    public Person(String name, int age, int internalId) {
        this.name = name;
        this.age = age;
        this.internalId = internalId;
    }

    // --- public getter/setter private-kentälle ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // --- protected metodi: aliluokat voivat kutsua, muut eivät (eri paketista) ---
    protected void celebrateBirthday() { this.age++; }

    // --- package-private metodi: näkyy vain samassa paketissa ---
    void resetInternalId() { this.internalId = 0; }

    // --- public metodi: näkyy kaikkialle ---
    public String info() {
        return "Person{name='" + name + "', age=" + age + ", internalId=" + internalId + "}";
    }
}
