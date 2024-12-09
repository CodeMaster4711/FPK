package thro.fpk;

public class Main {
    public static void main(String[] args) {
        CoffeeShop shop = new CoffeeShop();

        // Create baristas
        Thread barista1 = new Thread(new Barista(shop, "Barista1"));
        Thread barista2 = new Thread(new Barista(shop, "Barista2"));

        // Create 5 customers
        Thread customer1 = new Thread(new Customer(shop, "Customer1"));
        Thread customer2 = new Thread(new Customer(shop, "Customer2"));
        Thread customer3 = new Thread(new Customer(shop, "Customer3"));
        Thread customer4 = new Thread(new Customer(shop, "Customer4"));
        Thread customer5 = new Thread(new Customer(shop, "Customer5"));

        // Start threads
        barista1.start();
        barista2.start();
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();
    }
}