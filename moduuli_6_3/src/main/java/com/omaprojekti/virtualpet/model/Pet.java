// Tiedosto: src/main/java/com/omaprojekti/virtualpet/model/Pet.java
package com.omaprojekti.virtualpet.model;

public class Pet {
    private double x;
    private double y;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}