// Tiedosto: src/main/java/com/omaprojekti/virtualpet/VirtualPetApp.java
package com.omaprojekti.virtualpet;

import com.omaprojekti.virtualpet.controller.PetController;
import com.omaprojekti.virtualpet.model.Pet;
import com.omaprojekti.virtualpet.view.PetView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VirtualPetApp extends Application {

    @Override
    public void start(Stage stage) {
        // 1. Luo Malli (asetetaan lemmikki keskelle 800x600-ikkunaa)
        Pet pet = new Pet(400, 300);

        // 2. Luo Näkymä ja anna sille viittaus Malliin
        PetView view = new PetView(pet);

        // 3. Luo Kontrolleri ja anna sille viittaukset Malliin ja Näkymään
        new PetController(pet, view);

        // Piirretään lemmikki kerran sen alkusijaintiin ennen kuin animaatio alkaa
        view.drawPet();

        // 4. Kokoa käyttöliittymä ja näytä se
        Scene scene = new Scene(view.getLayout());
        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}