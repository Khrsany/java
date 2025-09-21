package com.omaprojekti.valuuttamuunnin.view;

import com.omaprojekti.valuuttamuunnin.model.Currency;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ConverterView {
    private GridPane layout;

    // UI-komponentit
    private TextField amountField;
    private TextField resultField;
    private ChoiceBox<Currency> fromCurrencyBox;
    private ChoiceBox<Currency> toCurrencyBox;
    private Button convertButton;

    public ConverterView() {
        layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setPadding(new Insets(25, 25, 25, 25));

        Label amountLabel = new Label("Määrä:");
        amountField = new TextField();
        amountField.setPromptText("Syötä määrä");

        Label fromLabel = new Label("Mistä valuutasta:");
        fromCurrencyBox = new ChoiceBox<>();

        Label toLabel = new Label("Mihin valuuttaan:");
        toCurrencyBox = new ChoiceBox<>();

        convertButton = new Button("Muunna");

        Label resultLabel = new Label("Tulos:");
        resultField = new TextField();
        resultField.setEditable(false);

        layout.add(amountLabel, 0, 0);
        layout.add(amountField, 1, 0);

        VBox fromVBox = new VBox(5, fromLabel, fromCurrencyBox);
        layout.add(fromVBox, 0, 1);

        VBox toVBox = new VBox(5, toLabel, toCurrencyBox);
        layout.add(toVBox, 1, 1);

        layout.add(convertButton, 1, 2);

        layout.add(resultLabel, 0, 3);
        layout.add(resultField, 1, 3);
    }

    public GridPane getLayout() {
        return layout;
    }

    // Getter-metodit Kontrolleria varten
    public TextField getAmountField() { return amountField; }
    public TextField getResultField() { return resultField; }
    public ChoiceBox<Currency> getFromCurrencyBox() { return fromCurrencyBox; }
    public ChoiceBox<Currency> getToCurrencyBox() { return toCurrencyBox; }
    public Button getConvertButton() { return convertButton; }
}