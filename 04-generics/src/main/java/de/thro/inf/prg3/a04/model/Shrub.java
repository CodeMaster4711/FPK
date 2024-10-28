package de.thro.inf.prg3.a04.model;

public class Shrub extends Plant {

    public final PlantColor plantColor;

    public Shrub(String family, String name, double height) {
        super(family, name, height);
        plantColor = PlantColor.GREEN;
    }

    @Override
    public PlantColor getColor() {
        return plantColor;
    }
}


