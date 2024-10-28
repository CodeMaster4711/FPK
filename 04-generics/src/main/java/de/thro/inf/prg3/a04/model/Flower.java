package de.thro.inf.prg3.a04.model;

public class Flower extends Plant {

    private final PlantColor plantColor;

    public Flower(String family, String name, double height, PlantColor plantColor) {
        super(family, name, height);

        /* ensure that a flower is never green */
        if (plantColor == PlantColor.GREEN) {
            throw new IllegalArgumentException("A plant may not be green");
        }
        this.plantColor = plantColor;

    }

    @Override
    public PlantColor getColor() {
        return plantColor;
    }
}
