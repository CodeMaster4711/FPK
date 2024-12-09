# Threads - Coffee Shop

## Task 1 : On paper!

A dog is cute, but it has to run a lot and mark its territory at the same time.
**The problem: He can either run or mark, but not both at the same time!**

The class below should realise this: Thread t1 is the urge to run, t2 is the urge to mark.

Fill in the gaps so that the dog only does one thing at a time.

>Note: Not all blanks need to be filled.

```java
class Dog {
    
	______________ void run (int steps ) {
        
		_____________________
		
		while ( __________________ ) {
            
			_____________________________________
				
			System .out. println (" running ...");
            
			Thread . sleep (500) ; // no exception handling for space saving
			
			_____________________________________
			
			Thread . sleep (10);
			// breath
		}
	}
    
	_______________ void mark (int steps ) {
        
		_____________________

		while ( __________________ ) {

			_____________________________________
	
			System .out. println (" marking ...");
            
			Thread . sleep (150) ; // no exception handling for space saving

			_____________________________________

			Thread . sleep (10);
			// breath
		}
	}
    
	public static void main( String [] args) throws InterruptedException {
		Dog h = new Dog ();
		Thread t1 = new Thread (new Runnable () { public void run () {
			h. run(10);
			// 10 steps run
		}});
		Thread t2 = new Thread (new Runnable () { public void run () {
			h. mark(3); // 3 step mark
		}});
        
		______________________________________

		______________________________________

		______________________________________
			
		______________________________________			
		
		System .out. println (" Done.");
    }
}
```


## Task 2

## Scenario

Simulate the operations of a coffee shop.
The shop has multiple baristas preparing orders, and a counter where orders are placed.
The counter has a limited amount of space, and can hold a maximum of 5 orders at a time.
Customers place orders at the counter, and pick them up.
Customers are zoomers with no attention span, they instantly look at their phone after ordering.
Therefore, when an order is ready, the barista rings a bell, which makes every customer check if their order is ready.
If yes, they pick it up, if not, they go back to their phone.

## Requirements

### Coffee Shop

- Baristas: Prepare orders in a multithreaded fashion. Each barista works independently.
- Customers: Place orders and wait for their orders to be ready.
- Counter: Holds prepared orders for customers to pick up.
- Is our central unit of logic, and provides place and pickup order methods. 
-  Implement synchronization to:
   - Avoid race conditions (e.g., multiple baristas trying to place orders on the counter simultaneously).
   - Ensure customers wait for their orders to be prepared.



### Barista

- Implements Runnable.
- Creating orders takes time. Simulate this by sleeping for a random amount of time. (2-5 seconds), you can use ``import java.util.concurrent.ThreadLocalRandom;`` to generate random numbers.
- Orders are placed on the counter when ready.
- When the counter is full, the barista waits for space to become available.

### Customer

- Extends Thread.
- Places an order at the counter.
- Waits for the order to be prepared.
- Picks up the order when ready.


### Order

- Simple object that represents an order.
- Think about reasonable attributes for access

## Simulation

Like last time we have a main ready for you to use.