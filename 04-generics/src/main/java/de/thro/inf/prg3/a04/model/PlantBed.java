package de.thro.inf.prg3.a04.model;

import de.thro.inf.prg3.a04.collections.SimpleList;
import de.thro.inf.prg3.a04.collections.SimpleListImpl;


public class PlantBed<T extends Plant>{
    private SimpleList<T> plants;

    public PlantBed() {
        this.plants = new SimpleListImpl<>();
    }

    public void add(T plant) {
        plants.add(plant);
    }

    public int size() {
        return plants.size();
    }

    public SimpleList<T> getPlantsByColor(PlantColor color) {
        return plants.filter(p -> p.getColor().equals(color));
    }

    public SimpleList<T> getPlants() {
        return plants;
    }
}
