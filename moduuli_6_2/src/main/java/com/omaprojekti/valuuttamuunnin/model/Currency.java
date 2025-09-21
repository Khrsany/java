package com.omaprojekti.valuuttamuunnin.model;

public class Currency {
    private final String abbreviation; // Esim. "EUR"
    private final String name;         // Esim. "Euro"
    private final double rateToUSD;    // Kuinka monta yksikköä tätä valuuttaa on 1 USD

    public Currency(String abbreviation, String name, double rateToUSD) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.rateToUSD = rateToUSD;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getRateToUSD() {
        return rateToUSD;
    }

    // Tämä metodi on tärkeä! ChoiceBox käyttää tätä näyttääkseen valuutan nimen listassa.
    @Override
    public String toString() {
        return name + " (" + abbreviation + ")";
    }
}