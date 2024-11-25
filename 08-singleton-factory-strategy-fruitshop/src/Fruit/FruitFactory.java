package Fruit;

public class FruitFactory {
    public static Fruit createFruit(String type) {
        switch (type.toLowerCase()) {
            case "apple":
                return new Apple("Fruit.Apple", 0.75);
            case "orange":
                return new Orange("Fruit.Orange", 0.80);
            case "banana":
                return new Banana("Fruit.Banana", 0.50);
            default:
                return (Fruit) new IllegalArgumentException("Unknown fruit type");
        }
    }
}

