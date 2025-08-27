
public class Television{

    private boolean on;         // Kertoo onko TV päällä vaiin pois eli false.
    private int channel;      // sanoo mikä kanava on valittu.

    public Television () {
        // tässä on alkuarvot.. Uusi TV on pois päältä ja kanavalla 1
        this.on = false;
        this.channel = 1;
    }

    // METODIT
    public void pressOnOff() {
        // Muutetaan boolean arvo päinvastoi true ja false
        this.on = !this.on;
    }

    public void setChannel(int newChannel) {
        // Tarkistus tv tilasta
        if (this.on) {
            if (newChannel > 10) {
                this.channel = 1; // Yli 10 palataan ykksöeen
            } else if (newChannel < 1) {
                this.channel = 10; // Alle 1 mennään kymmeneen
            } else {
                this.channel = newChannel;
            }
        }
    }
    public boolean isOn() {
        return this.on;
    }
    public int getChannel() {
        return this.channel;
    }
}