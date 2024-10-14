package de.thro.inf.prg3.a02;

import java.util.Iterator;

public class SimpleListImpl implements SimpleList, Iterable<Object> {
    private Element head;
    private int size;

    private static class Element {
        Object item;
        Element next;

        Element(Object item, Element next) {
            this.item = item;
            this.next = next;
        }
    }

    private class SimpleIteratorImpl implements Iterator<Object> {
        private Element current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object item = current.item;
            current = current.next;
            return item;
        }
    }

    @Override
    public void add(Object item) {
        Element newElement = new Element(item, null);
        if (head == null) {
            head = newElement;
        } else {
            Element current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newElement;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleListImpl filteredList = new SimpleListImpl();
        for (Object item : this) {
            if (filter.include(item)) {
                filteredList.add(item);
            }
        }
        return filteredList;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleIteratorImpl();
    }
}