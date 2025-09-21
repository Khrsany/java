package com.omaprojekti.valuuttamuunnin.controller;

import com.omaprojekti.valuuttamuunnin.model.Currency;
import com.omaprojekti.valuuttamuunnin.view.ConverterView;
import javafx.collections.FXCollections;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class ConverterController {
    private final ConverterView view;
    private final List<Currency> currencies;

    public ConverterController(ConverterView view) {
        this.view = view;
        this.currencies = new ArrayList<>();

        initializeCurrencies();
        populateChoiceBoxes();

        this.view.getConvertButton().setOnAction(event -> convert());
    }

    private void initializeCurrencies() {
        currencies.add(new Currency("USD", "Yhdysvaltain dollari", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.93));
        currencies.add(new Currency("GBP", "Britannian punta", 0.79));
        currencies.add(new Currency("JPY", "Japanin jeni", 145.83));
    }

    private void populateChoiceBoxes() {
        view.getFromCurrencyBox().setItems(FXCollections.observableArrayList(currencies));
        view.getToCurrencyBox().setItems(FXCollections.observableArrayList(currencies));
        view.getFromCurrencyBox().setValue(currencies.get(1)); // Euro oletuksena
        view.getToCurrencyBox().setValue(currencies.get(0)); // USD oletuksena
    }

    private void convert() {
        String amountText = view.getAmountField().getText();
        Currency fromCurrency = view.getFromCurrencyBox().getValue();
        Currency toCurrency = view.getToCurrencyBox().getValue();

        if (amountText.isEmpty() || fromCurrency == null || toCurrency == null) {
            showError("Täytä kaikki kentät.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            showError("Syötä määrä numerona.");
            return;
        }

        double amountInUSD = amount / fromCurrency.getRateToUSD();
        double result = amountInUSD * toCurrency.getRateToUSD();

        view.getResultField().setText(String.format("%.2f", result));
    }



    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Virhe");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}