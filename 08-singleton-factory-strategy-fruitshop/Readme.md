# Design Patterns - Singleton, Factory, Strategy, Command

## Scenario
You are building a fruit shop management system. The shop can sell fruits, apply discounts, and handle customer orders. The implementation should follow best practices by using appropriate design patterns.

## Requirements

### Singleton Pattern: Fruit.FruitShopManager
   The shop has a single manager class responsible for:

- Tracking the stock of fruits.
- Adding or removing fruits.
- Generating reports on sales and stock.

Implement a Fruit.FruitShopManager class as a Singleton. Ensure it has everything needed for a singleton.

### Factory Pattern: Fruit.Fruit Factory
The shop sells various types of fruits like apples, oranges, and bananas. Each fruit has common attributes (e.g., name, price per unit) but may have additional attributes (e.g., color, size).

Tasks:

- Create an interface or abstract class Fruit.Fruit with common attributes and methods like getName() and getPrice().
- Implement concrete classes: Fruit.Apple, Fruit.Orange, and Fruit.Banana.
- Create a Fruit.FruitFactory class that generates fruit objects based on a string input (e.g., "apple" -> Fruit.Apple object).

###  Strategy Pattern: Discount Policies

The shop offers different discount policies, such as:

- No discount.
- Percentage-based discount.
- Buy-two-get-one-free.

Tasks:

- Create a DiscountStrategy interface with a method applyDiscount(double price).
- Implement concrete strategies:
  - NoDiscountStrategy.
  - PercentageDiscountStrategy.
  - BuyTwoGetOneFreeStrategy.

- Allow the shop to switch discount strategies at runtime.

### Command Pattern: Order Management
Customers can place orders, and each order is represented as a command. The shop processes these orders through a centralized system.

Tasks:

- Create an OrderCommand interface with a method execute().
- Implement concrete commands, such as BuyFruitCommand, which deducts fruit from the stock.
- Maintain a queue of orders and process them using an OrderProcessor class.


### Simple I/O

To bring our implementation to life, we will use a simple console-based interface. The interface should allow users to:

- Select seller or customer mode.
- In Seller mode:
  - View stock
  - add stock
  - add new fruits (types)
  - change discount strategy
  - exit
- In Customer mode:
  - View stock
  - View discounts
  - Place order
  - Submit order(s)
  - exit

The seller mode will request a super secure login, asking 'who are you?' and 'what is the password?' after it is selected, both questions are to be answered with the super secure string 'admin'.


## Bonus points
Creating UML diagrams for the project is a good exercise for the exam.