package tehtava_1;

//extends Car eli että SportsCar on Car luokan aliluokka.
public class SportsCar extends Car {

    // kuunstruktori joka kutsuu yläluokan Car konstruktoria super()  komennolla
    public SportsCar(String typeName) {
        super(typeName); // Välitetään nimi Car-luokan konstruktorille.
    }

    //ylikirjoitetaan override alkuperäinen accelerate metodi
    //tämä versio on tehokkaampi
    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            //urheiluauto kiihtyy nopeammin esim.20 yksikköä
            setSpeed(getSpeed() + 20);
            //kuluttaa enemmän bensaa esim. 2 yksikköö
            //tarvitsisimme Car luokkaan setGasolineLevel metodin tämän tekemiseksi
            //yksinkertaistetaan ja jätetään se pois toistaiseksi
        } else {
            setSpeed(0);
        }
    }

    //ylikirjoitetaan myös decelerate metodi tehokkaammalla versioll
    @Override
    void decelerate(int amount) {
        if (getGasolineLevel() > 0) {
            //yrheiluauto jarruttaa tehokkaammin  esim. 2 kertaisesti
            if (amount > 0)
                setSpeed(Math.max(0, getSpeed() - amount * 2));
        } else {
            setSpeed(0);
        }
    }
}