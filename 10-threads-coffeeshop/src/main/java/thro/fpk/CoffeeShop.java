package thro.fpk;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {
    private final int MAX_ORDERS = 5;
    private final Queue<Order> counter = new LinkedList<>();
    private final Queue<Customer> customerQueue = new LinkedList<>();

    public synchronized void addOrder(Order order) throws InterruptedException{
       while (counter.size() == MAX_ORDERS) {
            System.out.println("Counter is full. Barista " + order.getBarista() + " is waiting.");
            wait();
       }

       counter.add(order);
       System.out.println("Order " + order.getBarista() + " added to the counter.");
       notifyAll();
    }

    public synchronized void joinQueue(Customer customer) {
        customerQueue.add(customer);
        System.out.println("Customer " + customer.getCustomerNumber() + " joined the queue.");
        notifyAll();
    }

    public synchronized void pickupOrder (String customername) throws InterruptedException{
        while (true) {
            for (Order order : counter) {
                if (order.getCustomer().getName().equals(customername)) {
                    System.out.println("Customer " + customername + " picked up order " + order.getCoffeeType());
                    counter.remove(order);
                    notifyAll();
                    return;
                }
            }

            System.out.println("Customer " + customername + " is waiting for their order.");
            wait();
        }
    }

    public synchronized Customer getNextCustomer () throws InterruptedException{
        while (customerQueue.isEmpty()) {
            System.out.println("No customers in the queue. Barista is waiting.");
            wait();
        }
        return customerQueue.poll();
    }
}
