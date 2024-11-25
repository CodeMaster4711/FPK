package discount;

public class NoDiscountStrategy implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
