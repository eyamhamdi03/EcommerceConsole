
package commerce;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private Map<String, Map<Product, Integer>> productsByCategory;
   

    public Inventory() {
        this.productsByCategory = new HashMap<>();
        
    }
    

    public void addProductToInventory(String category, Product product, int quantity) {
        if (!productsByCategory.containsKey(category)) {
            productsByCategory.put(category, new HashMap<>());
        }
        productsByCategory.get(category).put(product, quantity);
    }
    public Map<String, Map<Product, Integer>> getProductsByCategory() {
        return productsByCategory;
    }
    public int getStockQuantity(Product product) {
        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product p : products.keySet()) {
                if (p.getId() == product.getId()) {
                    return products.get(p);
                }
            }
        }
        return 0;
    }
    public void deleteProduct(Product productToDelete, Vendor requestingVendor) {
        String category = productToDelete.getCategory();

        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            
            if (products.containsKey(productToDelete)) {
                Vendor productVendor = productToDelete.getVendor();

                
                if (productVendor.equals(requestingVendor)) {
                    products.remove(productToDelete);
                    System.out.println("Product " + productToDelete.getId() + " removed from inventory in category " + category);
                } else {
                    System.out.println("Unauthorized to delete this product. Vendor mismatch.");
                }
            } else {
                System.out.println("Product does not exist in the inventory.");
            }
        } else {
            System.out.println("Category does not exist in the inventory.");
        }
    }



    

    public void displayStockInfo() {
        if (productsByCategory.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            System.out.println("Inventory Stock Information:");

            for (Map.Entry<String, Map<Product, Integer>> entry : productsByCategory.entrySet()) {
                String category = entry.getKey();
                Map<Product, Integer> products = entry.getValue();

                System.out.println("Category: " + category);

                for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
                    Product product = productEntry.getKey();
                    int stockQuantity = productEntry.getValue();

                    System.out.println(product.getName() + " - Stock: " + stockQuantity);
                    System.out.println("----------------------------------------");
                }

                // Print a separator between categories
                System.out.println("========================================");
            }
        }
    }


    public boolean takeOrder(Order order) {
        Map<Product, Integer> productsInOrder = order.getPurchasedProducts();

        for (Map.Entry<Product, Integer> entry : productsInOrder.entrySet()) {
            Product product = entry.getKey();
            int orderQuantity = entry.getValue();
            String category = product.getCategory();

            if (productsByCategory.containsKey(category)) {
                Map<Product, Integer> products = productsByCategory.get(category);
                if (products.containsKey(product)) {
                    int availableQuantity = products.get(product);
                    int newQuantity = availableQuantity - orderQuantity;

                    if (newQuantity >= 0) {
                        products.put(product, newQuantity);
                        System.out.println("Order processed for " + orderQuantity + " of product " + product.getName() + " in category " + category);
                    } else {
                        System.out.println("Not enough stock for " + product.getName() + " in category " + category);
                        return(false);
                    }
                }
            }
        }return(true);
    }


    public Product searchProductById(int productId) {
        for (Map.Entry<String, Map<Product, Integer>> categoryEntry : productsByCategory.entrySet()) {
            Map<Product, Integer> productsInCategory = categoryEntry.getValue();
            for (Map.Entry<Product, Integer> productEntry : productsInCategory.entrySet()) {
                Product product = productEntry.getKey();
                if (product.getId() == productId) {
                    return product;
                }
            }
        }
        return null; // If the product with the given ID is not found
    }

    public void replaceProductById(int productId, Product newProduct) {
        boolean productFound = false;

        for (Map.Entry<String, Map<Product, Integer>> entry : productsByCategory.entrySet()) {
            Map<Product, Integer> products = entry.getValue();
            for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
                Product product = productEntry.getKey();
                if (product.getId() == productId) {
                    products.remove(product); // Remove the existing product
                    products.put(newProduct, productEntry.getValue()); // Add the new product
                    productFound = true;
                    break;
                }
            }
            if (productFound) {
                break;
            }
        }

        if (!productFound) {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    public void deliverProduct(String category, Product product) {
        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            if (products.containsKey(product)) {
                int quantity = products.get(product);
                System.out.println("Product " + product.getName() + " in category " + category + " delivered.");
                products.put(product, quantity - 1);
            }
        }
    }

    public void returnProduct(String category, Product product) {
        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            if (products.containsKey(product)) {
                int quantity = products.get(product);
                System.out.println("Product " + product.getName() + " in category " + category + " returned to inventory.");
                products.put(product, quantity + 1);
            }
        }
    }
    public void addStock(String category, Product product, Vendor vendor, int quantityToAdd) {
        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            if (products.containsKey(product)) {
                if (product.getVendor() == vendor) {
                    int currentStock = products.get(product);
                    products.put(product, currentStock + quantityToAdd);
                    System.out.println(quantityToAdd + " " + product.getName() + " added to the stock in category " + category);
                } else {
                    System.out.println("The vendor does not have permission to modify this product.");
                }
            } else {
                System.out.println("Product does not exist in the inventory.");
            }
        } else {
            System.out.println("Category does not exist in the inventory.");
        }
    }
    public List<Product> SearchByCategory(String category) {
        List<Product> categoryProducts = new ArrayList<>();

        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            categoryProducts.addAll(products.keySet());
        }

        return categoryProducts;
    }

    public Product searchProductByCategoryAndName(String category, String productName) {
        if (productsByCategory.containsKey(category)) {
            Map<Product, Integer> products = productsByCategory.get(category);
            for (Product product : products.keySet()) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    return product;
                }
            }
        }
        return null; // Product not found in the given category with the specified name
    }
    
    public List<Product> getProductsByVendor(Vendor vendor) {
        List<Product> productsByVendor = new ArrayList<>();

        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product product : products.keySet()) {
                if (product.getVendor().equals(vendor)) {
                    productsByVendor.add(product);
                }
            }
        }

        return productsByVendor;
    }
    
    public void displayInventoryForVendor(Vendor vendor) {
        System.out.println("Inventory for Vendor: " + vendor.getFullName());
        System.out.println("--------------------------");

        List<Product> productsByVendor = getProductsByVendor(vendor);

        if (productsByVendor.isEmpty()) {
            System.out.println("No products available for this vendor.");
        } else {
            for (Product product : productsByVendor) {
                // Display product details
                product.affiche();

                // Retrieve and display stock quantity (adjust as needed)
                int stockQuantity = getStockQuantity(product);
                System.out.println("Stock Quantity: " + stockQuantity);

                // Line between consecutive products
                System.out.println("--------------------------");
            }
        }
    }

    public List<Product> searchProductsByName(String productName) {
        List<Product> productsByName = new ArrayList<>();

        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product product : products.keySet()) {
                if (product.getName().equalsIgnoreCase(productName)) {
                    productsByName.add(product);
                }
            }
        }

        return productsByName;
    }
    

    public List<Product> searchByBrand(String brandName) {
        List<Product> productsByBrand = new ArrayList<>();

        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product product : products.keySet()) {
                if (product.getBrand().equalsIgnoreCase(brandName)) {
                    productsByBrand.add(product);
                }
            }
        }

        return productsByBrand;
    }

    public List<Product> searchByPriceRange(double minPrice, double maxPrice) {
        List<Product> productsByPriceRange = new ArrayList<>();

        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product product : products.keySet()) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    productsByPriceRange.add(product);
                }
            }
        }

        return productsByPriceRange;
    }

    public List<Product> searchByWarranty(String warrantyPeriod) {
        List<Product> productsByWarranty = new ArrayList<>();

        for (Map<Product, Integer> products : productsByCategory.values()) {
            for (Product product : products.keySet()) {
                if (product.getWarranty() == warrantyPeriod) {
                    productsByWarranty.add(product);
                }
            }
        }

        return productsByWarranty;
    }

    public void displayInventoryForAdmin() {
        System.out.println("Inventory Display:");
        System.out.println("--------------------------");

        for (Map.Entry<String, Map<Product, Integer>> categoryEntry : productsByCategory.entrySet()) {
            String category = categoryEntry.getKey();
            Map<Product, Integer> products = categoryEntry.getValue();

            System.out.println("Category: " + category);
            for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
                Product product = productEntry.getKey();
                int stockQuantity = productEntry.getValue();

                // Display product details
                product.affiche();

                // Display stock quantity
                System.out.println("Stock Quantity: " + stockQuantity);

                // Line between consecutive products
                System.out.println("--------------------------");
            }

            // Line between consecutive categories
            System.out.println("========================================");
        }
    }

        public void displayInventoryForCustomers() {
            if (productsByCategory.isEmpty()) {
                System.out.println("No products available.");
            } else {
                System.out.println("List of all the products:");

                for (Map.Entry<String, Map<Product, Integer>> entry : productsByCategory.entrySet()) {
                    String category = entry.getKey();
                    Map<Product, Integer> products = entry.getValue();

                    System.out.println("Category: " + category);

                    for (Map.Entry<Product, Integer> productEntry : products.entrySet()) {
                        Product product = productEntry.getKey();
                        int stockQuantity = productEntry.getValue();

                        product.affiche();

                        if (stockQuantity < 5 && stockQuantity > 0) {
                            System.out.println("Status: Low in stock");
                        } else if (stockQuantity == 0) {
                            System.out.println("Status: Unavailable now");
                        } else {
                            System.out.println("Status: Available");
                        }

                        System.out.println("----------------------------------------");
                    }

                    System.out.println("========================================");
                
            }
        }
    }

    


}

