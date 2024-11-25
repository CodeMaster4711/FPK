package Fruit;

import java.util.HashMap;
import java.util.Map;

public class FruitShopManager {
    private static FruitShopManager instance;
    private Map<String, Integer> stock;

    private FruitShopManager() {
        stock = new HashMap<>();
    }

    public static FruitShopManager getInstance() {
        if (instance == null) {
            instance = new FruitShopManager();
        }
        return instance;
    }

    public void addFruit(String fruit, int quantity) {
      stock.put(fruit, stock.getOrDefault(fruit, 0) + quantity);
    }

    public void removeFruit(String fruit, int quantity) {
        if(stock.containsKey(fruit)) {
            int currentStock = stock.get(fruit);
            if(currentStock >= quantity) {
                stock.put(fruit, currentStock - quantity);
            } else {
                System.out.println("Not enough stock to remove");
            }
        } else {
            System.out.println("Fruit.Fruit not found in stock");
        }
    }

    public void generateReport() {
        System.out.println("Fruit.Fruit Stock Report:");
        for(Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
