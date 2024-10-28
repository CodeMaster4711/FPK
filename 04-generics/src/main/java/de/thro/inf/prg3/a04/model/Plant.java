package de.thro.inf.prg3.a04.model;

public abstract class Plant implements Comparable<Plant> {

    private final double height;
    private final String family;
    private final String name;

    public Plant(String family, String name, double height) {
        if (family == null || family.isEmpty()) throw new IllegalArgumentException("Specify a family");
        this.family = family;

        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Specify a family");
        this.name = name;

        if (height <= 0.0) throw new IllegalArgumentException(" Height may not be less or equal to zero");
        this.height = height;
    }

    public abstract PlantColor getColor();

    @Override
    public int compareTo(Plant o) {
        return Double.compare(this.height, o.height); // < 0, if the current, respectively left object is smaller.
        // >0, if the current, respectively left object is larger.
    }
}

