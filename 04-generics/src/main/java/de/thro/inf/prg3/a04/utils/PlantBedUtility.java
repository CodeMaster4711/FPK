package de.thro.inf.prg3.a04.utils;

import de.thro.inf.prg3.a04.collections.SimpleList;
import de.thro.inf.prg3.a04.model.Plant;
import de.thro.inf.prg3.a04.model.PlantBed;
import de.thro.inf.prg3.a04.model.PlantColor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;


public abstract class PlantBedUtility {

    public static <T extends Plant> void pecs(SimpleList<? super T> dest, SimpleList<? extends T> source) {
        for (T t : source) {
            dest.add(t);
        }
    }
    public static <T extends Plant> void pecs_with_filter(SimpleList<? super T>dest, SimpleList<? extends T> source, Predicate<? super T> p){
        for (T t : source){
            if (p.test(t)){
                dest.add(t);
            }
        }
    }

    public static <T extends Plant> Map<PlantColor, SimpleList<T>> splitBedByColor(PlantBed<T> plantBed) {

        Map<PlantColor, SimpleList<T>> result = new HashMap<>();

        for (PlantColor color : PlantColor.values()) {
            result.put(color, plantBed.getPlantsByColor(color));
        }
        return result;
    }


}
