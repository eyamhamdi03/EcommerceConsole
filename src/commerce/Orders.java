package commerce;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Order> allOrders;
    
    public Orders() {
        this.allOrders = new ArrayList<>();
        
    }

    public void addOrder(Order order) {
        allOrders.add(order);
        
    }
    public void addOrders (Orders O)
    {
    	for (Order order: O.allOrders )
    	{
    		addOrder(order);
    	}
    }
    public void confirmOrder(int orderId) {
        for (Order order : allOrders) {
            if (order.getOrderId() == orderId && !order.isConfirmedByAdmin()) {
                order.setConfirmedByAdmin(true);
               
                System.out.println("Order " + orderId + " has been confirmed.");
                return;
            }
        }
        System.out.println("Order " + orderId + " not found or already confirmed.");
    }
    public void displayAllOrders() {
        for (Order order : allOrders) {
            order.displayOrderDetails();
            System.out.println("======================================");
        }
    }
    
        public void displayNonConfirmedOrders() {
            for (Order order : allOrders) {
                if (!order.isConfirmedByAdmin()) {
                    order.displayOrderDetails();
                    System.out.println("======================================");
                }
            }
        }
    
    

    public List<Order> getAllOrders() {
        return allOrders;
    }
}
