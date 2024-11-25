package OrderManagment;
import Fruit.FruitShopManager;

public class BuyFruitCommand implements OrderCommand{
    private FruitShopManager manager;
    private String fruit;
    private int quantity;

    public BuyFruitCommand(FruitShopManager manager, String fruit, int quantity) {
        this.manager = manager;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        manager.removeFruit(fruit, quantity);
    }
}
