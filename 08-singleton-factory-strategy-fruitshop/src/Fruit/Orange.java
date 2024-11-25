package Fruit;

public class Orange implements Fruit {
    private String name;
    private double price;

    public Orange(String name, double price) {
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
