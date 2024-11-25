package Fruit;

public class Banana implements Fruit {
    private String name;
    private double price;

    public Banana(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
