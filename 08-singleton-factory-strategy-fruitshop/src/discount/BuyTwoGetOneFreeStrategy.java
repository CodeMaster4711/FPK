package discount;

public class BuyTwoGetOneFreeStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Assuming price is for three items
        return price * 2 / 3;
    }
}
