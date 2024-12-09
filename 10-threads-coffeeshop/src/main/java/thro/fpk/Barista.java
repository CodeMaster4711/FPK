package thro.fpk;

import java.util.concurrent.ThreadLocalRandom;

public class Barista implements Runnable {
    private final CoffeeShop shop;
    private final String name;

    public Barista(CoffeeShop shop, String name) {
        this.shop = shop;
        this.name = name;
    }

    public String getBarista() {
        return name;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Customer customer = shop.getNextCustomer();
                String coffeeType = "Coffee for" + customer.getName();
                Order order = new Order(customer, coffeeType, name);
                shop.addOrder(order);
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Barista " + name + " was interrupted.");
        }
    }
}
