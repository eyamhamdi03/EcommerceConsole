package commerce;

import java.util.Map;
import java.util.Scanner;

import java.time.LocalDate;

public class Order {
    private int orderId;
    private static int lastId=0;
    private Customer customer ;
    private Map<Product, Integer>purchasedProducts;
    private double totalAmount;
    private LocalDate orderDate;
    private String address;
    private int phoneNumber;
    private boolean confirmedByAdmin;
    private boolean delivered;
    private Admin admin ; 
    
    
    public Order( ShoppingCart cart,Customer customer,Admin admin ) {
        this.orderId =++lastId;
        this.purchasedProducts = cart.getProductsCart();
        this.totalAmount = cart.calculateTotalSum();
        orderDate = LocalDate.now();
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();
        this.confirmedByAdmin = false; 
        this.delivered = false;
        this.customer = customer ;
        this.admin=admin ; 
        
    }
    

    public Admin getAdmin() {return(admin);}
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Map<Product, Integer> getPurchasedProducts() {
        return purchasedProducts;
    }

    

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isConfirmedByAdmin() {
        return confirmedByAdmin;
    }

    public void setConfirmedByAdmin(boolean confirmedByAdmin) {
        this.confirmedByAdmin = confirmedByAdmin;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
    public boolean canModifyOrder() {
        return !confirmedByAdmin && !delivered;
    }

    public void updateAddress(String newAddress) {
        if (canModifyOrder()) {
            this.address = newAddress;
        } else {
            System.out.println("Order can't be modified once confirmed or delivered.");
        }
    }

    public void updatePhoneNumber(int newPhoneNumber) {
        if (canModifyOrder()) {
            this.phoneNumber = newPhoneNumber;
        } else {
            System.out.println("Order can't be modified once confirmed or delivered.");
        }
    }
    
    public void updateOrderAttributes() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Current Address: " + customer.getAddress());
            System.out.println("Do you want to change the address? (yes/no)");
            String changeAddress = scanner.nextLine();

            if (changeAddress.equalsIgnoreCase("yes")) {
                System.out.println("Enter the new address:");
                String newAddress = scanner.nextLine();
                setAddress(newAddress);
            }

            System.out.println("Current Phone Number: " + customer.getPhoneNumber());
            System.out.println("Do you want to change the phone number? (yes/no)");
            String changePhoneNumber = scanner.nextLine();

            if (changePhoneNumber.equalsIgnoreCase("yes")) {
                System.out.println("Enter the new phone number:");
                int newPhoneNumber = scanner.nextInt();
                setPhoneNumber(newPhoneNumber);
            }
        }
    }
    
    
    

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products bought:");

        for (Map.Entry<Product, Integer> entry : purchasedProducts.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product.getName() + " - Quantity: " + quantity);
        }

        System.out.println("----------------------");
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Customer Name: " + customer.getFullName());
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Delivery Address: " + address);

        String status =  delivered ? "Delivered" :(confirmedByAdmin ? "Confirmed" : "In progress");
        System.out.println("Status: " + status);
    }

    
    
}
