// Tiedosto: src/main/java/com/omaprojekti/virtualpet/controller/PetController.java
package com.omaprojekti.virtualpet.controller;

import com.omaprojekti.virtualpet.model.Pet;
import com.omaprojekti.virtualpet.view.PetView;

public class PetController {
    private Pet pet;
    private PetView view;

    // Hiiren kohdekoordinaatit, joihin lemmikki pyrkii
    private double targetX;
    private double targetY;

    // Lemmikin nopeus (pikseliä per ruudunpäivitys)
    private static final double PET_SPEED = 2.0;

    public PetController(Pet pet, PetView view) {
        this.pet = pet;
        this.view = view;

        // Asetetaan tapahtumankäsittelijät hiirelle
        setupMouseHandlers();

        // Asetetaan animaatiologiikka valmiiksi, mutta ei vielä käynnistetä sitä.
        // Tämä on elegantti tapa antaa näkymälle suoraan metodi, jota se kutsuu jatkuvasti.
        view.startAnimation(this::updatePetPosition);
        view.stopAnimation(); // Pysäytetään heti alussa, odotetaan hiiren liikettä.
    }

    private void setupMouseHandlers() {
        // Tapahtumankäsittelijä, joka aktivoituu, kun hiirtä liikutetaan piirtoalueen päällä
        view.getCanvas().setOnMouseMoved(event -> {
            this.targetX = event.getX();
            this.targetY = event.getY();
            view.startAnimation(this::updatePetPosition); // Käynnistetään lemmikin liike
        });

        // Tapahtumankäsittelijä, joka aktivoituu, kun hiiri poistuu piirtoalueelta
        view.getCanvas().setOnMouseExited(event -> {
            view.stopAnimation(); // Pysäytetään lemmikin liike
        });
    }

    /**
     * Tätä metodia kutsutaan jatkuvasti AnimationTimerin kautta, kun animaatio on käynnissä.
     * Se laskee ja päivittää lemmikin sijainnin.
     */
    private void updatePetPosition() {
        double currentX = pet.getX();
        double currentY = pet.getY();

        // Lasketaan etäisyys kohteeseen (Pythagoraan lause)
        double distanceX = targetX - currentX;
        double distanceY = targetY - currentY;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        // JOS: Lemmikki on jo melkein perillä, pysäytetään animaatio.
        if (distance < PET_SPEED) {
            view.stopAnimation();
            return; // Lopetetaan tämän metodin suoritus
        }

        // MUUTEN: Lasketaan yhden askeleen vaatima liike.
        // Normalisoidaan suuntavektori (saadaan suuntavektori, jonka pituus on 1)
        double directionX = distanceX / distance;
        double directionY = distanceY / distance;

        // Liikutetaan lemmikkiä nopeuden verran oikeaan suuntaan
        double newX = currentX + directionX * PET_SPEED;
        double newY = currentY + directionY * PET_SPEED;

        // Päivitetään lemmikin uusi sijainti malliin
        pet.setX(newX);
        pet.setY(newY);
    }
}