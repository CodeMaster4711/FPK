package OrderManagment;

import java.util.LinkedList;
import java.util.Queue;

public class OrderProcessor{
    private Queue<OrderCommand> orderQueue;

    public OrderProcessor() {
        orderQueue = new LinkedList<>();
    }

    public void addOrder(OrderCommand order){
        orderQueue.add(order);
    }

    public void processOrders(){
        while(!orderQueue.isEmpty()){
            OrderCommand order = orderQueue.poll();
            order.execute();
        }
    }
}
