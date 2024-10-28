package de.thro.inf.prg3.a04.utils;

import de.thro.inf.prg3.a04.collections.SimpleList;
import de.thro.inf.prg3.a04.collections.SimpleListImpl;
import de.thro.inf.prg3.a04.model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

class PlantBedUtilityTest {

    private PlantBed<Flower> flowerBed;

    @BeforeEach
    void setup() {

        flowerBed = new PlantBed<>();

        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.4, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.5, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.3, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Golden Celebration", 0.35, PlantColor.YELLOW));
        flowerBed.add(new Flower("Rosa", "Abracadabra", 0.35, PlantColor.RED));
        flowerBed.add(new Flower("Rosa", "Rosa chinensis", 0.45, PlantColor.ORANGE));
        flowerBed.add(new Flower("Tulip", "Curly Sue", 0.55, PlantColor.VIOLETTE));
    }

    @Test
    void testSplitByBedByColorResultingSize() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        assertEquals(6, split.keySet().size());
    }

    @Test
    void testSplitByBedByColorPureness() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testSplitByBedByColorPureness2() {
        Map<PlantColor, SimpleList<Flower>> split = PlantBedUtility.splitBedByColor(flowerBed);
        for (Flower f : split.get(PlantColor.YELLOW)) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testPECS(){
        SimpleList<Plant> dest = new SimpleListImpl<>();
        PlantBedUtility.pecs(dest,flowerBed.getPlants());
        for (Plant plant : dest){
            assertTrue(plant instanceof Flower);
        }
    }

    @Test
    void testPecs_with_filter(){
        SimpleList<Plant> dest = new SimpleListImpl<>();
        PlantBedUtility.pecs_with_filter(dest,flowerBed.getPlants(),flower -> flower.getColor().equals(PlantColor.YELLOW));
        for (Plant plant : dest){
            assertEquals(PlantColor.YELLOW,plant.getColor());
        }
    }

}