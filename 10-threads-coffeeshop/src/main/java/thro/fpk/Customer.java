package thro.fpk;

public class Customer implements Runnable {
    private final CoffeeShop shop;
    private final String name;

    public Customer(CoffeeShop shop, String name) {
        this.shop = shop;
        this.name = name;
    }

    public String getCustomerNumber() {
        return name;
    }

    public String getName() {
        return name;
    }
    @Override
    public void run() {
        try {
            shop.joinQueue(this);
            shop.pickupOrder(name);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Customer " + name + " was interrupted.");
        }
    }
}
