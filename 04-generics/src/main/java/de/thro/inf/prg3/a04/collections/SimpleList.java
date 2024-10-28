package de.thro.inf.prg3.a04.collections;

import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SimpleList<T> extends Iterable<T> {

    int size();

    void add(T item);


    T get(int index);

    void set(int index,T item);

    default SimpleList<T> filter(Predicate<T> predicate) {
        SimpleList<T> result = new SimpleListImpl<>();
        for (T item : this) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

}

