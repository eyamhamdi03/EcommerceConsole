package commerce;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> products;
    private double totalSum;

    public Map<Product, Integer> getProductsCart()
    {return(products);}
    public ShoppingCart() {
        this.products = new HashMap<>();
        this.totalSum = 0.0;
    }

    public void clearCart() {
        products.clear();
        totalSum = 0.0;
        System.out.println("Shopping cart cleared.");
    }
    
    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
        totalSum += product.getPrice() * quantity;
    }

    public double calculateTotalSum() {
        return totalSum;
    }

    public void afficherShoppingCart() {
        System.out.println("Shopping Cart:");
        System.out.println("------------------------------");

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = product.getPrice() * quantity;

            System.out.println("Product: " + product.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Price per unit: " + product.getPrice());
            System.out.println("Total Price: " + totalPrice);
            System.out.println("------------------------------");
        }

        System.out.println("Total Sum: " + totalSum);
        System.out.println("------------------------------");
    }
    public void supprimerDeCarte(int productId) {
        Iterator<Map.Entry<Product, Integer>> iterator = products.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Product, Integer> entry = iterator.next();
            Product product = entry.getKey();

            if (product.getId() == productId) {
                totalSum -= product.getPrice() * entry.getValue();
                iterator.remove();
                System.out.println("Product with ID " + productId + " removed from the shopping cart.");
                return;
            }
        }

        System.out.println("Product with ID " + productId + " not found in the shopping cart.");
    }
}
