package com.omaprojekti.valuuttamuunnin;

import com.omaprojekti.valuuttamuunnin.controller.ConverterController;
import com.omaprojekti.valuuttamuunnin.view.ConverterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CurrencyConverterApp extends Application {

    @Override
    public void start(Stage stage) {
        ConverterView view = new ConverterView();
        new ConverterController(view);

        Scene scene = new Scene(view.getLayout(), 400, 300);

        // Varmista, että sinulla on style.css-tiedosto resources-kansiossa
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("Valuuttamuunnin");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}