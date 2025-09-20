package dictionary;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class DictionaryView extends Application {

    private final TextField wordInput = new TextField();
    private final Button searchButton = new Button("Search");
    private final Label resultLabel = new Label();

    private DictionaryController controller;

    @Override
    public void init() {
        controller = new DictionaryController(this);
    }

    @Override
    public void start(Stage stage) {
        FlowPane layout = new FlowPane();
        layout.setHgap(8);
        layout.setVgap(8);

        wordInput.setPromptText("Kirjoita sana…");
        layout.getChildren().addAll(wordInput, searchButton, resultLabel);

        searchButton.setOnAction(e -> controller.onSearch(wordInput.getText()));

        Scene scene = new Scene(layout, 420, 140);
        stage.setTitle("Virtual Dictionary");
        stage.setScene(scene);
        stage.show();
    }

    // Controller kutsuu tätä: vain teksti sisään, ei JavaFX-olioita
    public void showMessage(String text) {
        resultLabel.setText(text);
    }
}
