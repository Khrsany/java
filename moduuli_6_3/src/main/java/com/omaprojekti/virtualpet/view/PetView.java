// Tiedosto: src/main/java/com/omaprojekti/virtualpet/view/PetView.java
package com.omaprojekti.virtualpet.view;

import com.omaprojekti.virtualpet.model.Pet;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class PetView {
    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;
    private Pet pet;
    private AnimationTimer animationTimer;

    // MUUTOS: Lisätty vakio lemmikin halutulle koolle.
    // Voit muuttaa tätä arvoa, jos haluat lemmikistä isomman tai pienemmän.
    private static final double PET_SIZE = 50.0;

    public PetView(Pet pet) {
        this.pet = pet;
        canvas = new Canvas(800, 600); // Piirtoalueen koko
        gc = canvas.getGraphicsContext2D(); // Piirtotyökalu

        // Ladataan kuva resources-kansiosta
        try {
            petImage = new Image(getClass().getResourceAsStream("/pet.png"));
        } catch (Exception e) {
            System.err.println("Kuvaa /pet.png ei löytynyt! Varmista, että se on src/main/resources-kansiossa.");
            petImage = null;
        }
    }

    /**
     * Piirtää lemmikin sen nykyiseen sijaintiin mallin tietojen perusteella.
     */
    public void drawPet() {
        // Tyhjennetään ensin koko piirtoalue, jotta vanha kuva katoaa
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (petImage != null) {
            // MUUTOS: Keskitys ja piirtäminen käyttävät nyt PET_SIZE-vakiota.
            double centeredX = pet.getX() - PET_SIZE / 2;
            double centeredY = pet.getY() - PET_SIZE / 2;

            // Piirretään kuva ja määritellään sen leveys ja korkeus PET_SIZE-vakion mukaan
            gc.drawImage(petImage, centeredX, centeredY, PET_SIZE, PET_SIZE);
        } else {
            // Varapiirto neliönä, jos kuvaa ei jostain syystä ladattu
            gc.fillRect(pet.getX() - 10, pet.getY() - 10, 20, 20);
        }
    }

    /**
     * Käynnistää animaation, joka päivittää ruutua jatkuvasti.
     * @param updateLogic Kontrollerin antama logiikka, joka suoritetaan joka ruudunpäivityksellä.
     */
    public void startAnimation(Runnable updateLogic) {
        if (animationTimer == null) {
            animationTimer = new AnimationTimer() {
                @Override
                public void handle(long now) {
                    updateLogic.run(); // Suoritetaan kontrollerin päivityslogiikka
                    drawPet();         // Piirretään lemmikki uudelleen sen mahdollisesti uudessa sijainnissa
                }
            };
        }
        animationTimer.start();
    }

    /**
     * Pysäyttää animaation.
     */
    public void stopAnimation() {
        if (animationTimer != null) {
            animationTimer.stop();
        }
    }

    // Metodit, joilla pääluokka ja kontrolleri voivat käyttää näkymän osia
    public Pane getLayout() {
        return new Pane(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}