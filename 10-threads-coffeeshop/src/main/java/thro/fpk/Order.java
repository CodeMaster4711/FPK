package thro.fpk;

public class Order {
    private final Customer customer;
    private final String coffeeType;
    private final String barista;

    public Order(Customer customer, String coffeeType, String barista) {
        this.customer = customer;
        this.coffeeType = coffeeType;
        this.barista = barista;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCoffeeType() {
        return coffeeType;
    }

    public String getBarista() {
        return barista;
    }

}
