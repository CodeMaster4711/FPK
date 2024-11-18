package thro.ui.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {

    private final SimpleStringProperty name;

    public Person(String name) {
        this.name = new SimpleStringProperty(name);

    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }


    @Override
    public String toString() {
        return  name.getValue();
    }
}
