import Fruit.FruitShopManager;
import Fruit.FruitFactory;
import Fruit.Fruit;
import discount.NoDiscountStrategy;
import discount.PercentageDiscountStrategy;
import discount.BuyTwoGetOneFreeStrategy;
import OrderManagment.OrderProcessor;
import OrderManagment.BuyFruitCommand;

public class Main {
    public static void main(String[] args) {
        // Singleton Pattern: Test FruitShopManager
        FruitShopManager manager = FruitShopManager.getInstance();
        manager.addFruit("apple", 10);
        manager.addFruit("orange", 20);
        manager.generateReport();

        // Factory Pattern: Test FruitFactory
        Fruit apple = FruitFactory.createFruit("apple");
        Fruit orange = FruitFactory.createFruit("orange");
        System.out.println("Created fruit: " + apple.getName() + " with price: " + apple.getPrice());
        System.out.println("Created fruit: " + orange.getName() + " with price: " + orange.getPrice());

        // Strategy Pattern: Test Discount Strategies
        NoDiscountStrategy noDiscount = new NoDiscountStrategy();
        PercentageDiscountStrategy percentageDiscount = new PercentageDiscountStrategy(10);
        BuyTwoGetOneFreeStrategy buyTwoGetOneFree = new BuyTwoGetOneFreeStrategy();
        double price = 100.0;
        System.out.println("No discount: " + noDiscount.applyDiscount(price));
        System.out.println("10% discount: " + percentageDiscount.applyDiscount(price));
        System.out.println("Buy two get one free: " + buyTwoGetOneFree.applyDiscount(price));

        // Command Pattern: Test Order Management
        OrderProcessor orderProcessor = new OrderProcessor();
        BuyFruitCommand buyApple = new BuyFruitCommand(manager, "apple", 5);
        BuyFruitCommand buyOrange = new BuyFruitCommand(manager, "orange", 10);
        orderProcessor.addOrder(buyApple);
        orderProcessor.addOrder(buyOrange);
        orderProcessor.processOrders();
        manager.generateReport();
    }
}