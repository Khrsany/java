package tehtava_4;
// perusluokka jolla kaikille on yhteinen väri
public class Shape {

    //vanhakoodi
    private String color;

    //kunstruktori, joka vaatii että jokaiselle muodolle annetaan väri
    public Shape(String color) {
        this.color = color;
    }

    //getteri jolla värin voi kysyä.
    public String getColor() {
        return color;
    }

    //tämä on oletusmetodijonka aliluokat ylikirjoittavat
    public double calculateArea() {
        return 0.0;
    }
}